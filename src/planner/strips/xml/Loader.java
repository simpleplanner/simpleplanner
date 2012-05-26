package planner.strips.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import planner.strips.Action;
import planner.strips.And;
import planner.strips.Condition;
import planner.strips.Domain;
import planner.strips.Not;
import planner.strips.Parameter;
import planner.strips.Parametized;
import planner.strips.Predicate;
import planner.strips.Problem;
import planner.strips.Type;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class Loader {
	private Domain domain;
	private Map<String, Problem> problems = new HashMap<String, Problem>();

	public void load(String path) {
		XMLParser parser = new XMLParser(path, "strips");
		loadDomain(parser);
		loadProblems(parser);
	}

	private void loadProblems(XMLParser parser) {
		for (XMLParser problemXML : parser.children("problem")) {
			Problem problem = new Problem();
			problem.domain = domain;
			problem.name = problemXML.string("name");
			for (XMLParser objectXML : problemXML.children("object")) {
				Parameter parameter = loadTypedParameter(objectXML);
				problem.params.add(parameter);
			}
			problem.buildTypeMap();
			for (Condition c : loadChildCondition(problemXML.child("init"), problem)) {
				problem.init.predicates.add((Predicate) c);
			}
			problem.goal = loadChildCondition(problemXML.child("goal"), problem).get(0);
			problem.computeActions();
			problems.put(problem.name, problem);
		}
	}

	private void loadDomain(XMLParser parser) {
		XMLParser domainXML = parser.child("domain");
		domain = new Domain();
		domain.name = domainXML.string("name");
		domain.types.put("object", new Type("object"));
		for (XMLParser typeXML : domainXML.children("type")) {
			Type type = loadType(typeXML);
			domain.types.put(type.name, type);
		}
		for (XMLParser actionXML : domainXML.children("action")) {
			domain.actions.add(loadAction(actionXML));
		}
	}

	private Type loadType(XMLParser typeXML) {
		String name = typeXML.string("name");
		String parent = new String();
		try{
			 parent = typeXML.string("parent");
		}catch (RuntimeException e) {}
		
		Type type = new Type(name);
		if (domain.types.containsKey(parent)){
			type.type = domain.types.get(parent);
		}else{
			type.type = domain.types.get("object");
		}
		
		return type;
	}

	private Action loadAction(XMLParser actionXML) {
		Action a = new Action();
		a.name = actionXML.string("name");
		for (XMLParser paramXML : actionXML.children("param")) {
			a.params.add(loadTypedParameter(paramXML));
		}
		a.buildTypeMap();
		a.precondition = loadChildCondition(actionXML.child("precondition"), a).get(0);
		a.effects = loadChildCondition(actionXML.child("effect"), a).get(0);
		return a;
	}

	private List<Condition> loadChildCondition(XMLParser parent, Parametized parametized) {
		List<Condition> conditions = new ArrayList<Condition>();
		try {
			for (XMLParser notXML : parent.children("not")) {
				Not not = new Not();
				not.predicate = (Predicate) loadChildCondition(notXML, parametized).get(0);
				conditions.add(not);
			}
		} catch (Exception e) {
		}

		try {
			for (XMLParser andXML : parent.children("and")) {
				And and = new And();
				and.conditions.addAll(loadChildCondition(andXML, parametized));
				conditions.add(and);
			}
		} catch (Exception e) {
		}

		try {
			for (XMLParser pXML : parent.children("predicate")) {
				Predicate p = new Predicate();
				p.name = pXML.string("name");
				for (XMLParser paramXML : pXML.children("param")) {
					p.params.add(loadParameter(paramXML, parametized));
				}
				conditions.add(p);
			}
		} catch (Exception e) {
		}

		return conditions;
	}

	private Parameter loadParameter(XMLParser paramXML, Parametized parametized) {
		Parameter parameter = new Parameter();
		String name = paramXML.string("name");

		if (!parametized.paramsMap.containsKey(name)) {
			System.out.println("Parameter " + name.toUpperCase() + " not declared");
			System.exit(0);
		} else {
			parameter = parametized.paramsMap.get(name);
		}
		return parameter;
	}

	private Parameter loadTypedParameter(XMLParser paramXML) {
		Parameter parameter = new Parameter();
		String type = null;
		try {
			type = paramXML.string("type");
		} catch (RuntimeException e) {
			System.out.print("Informe o tipo para o parametro " + paramXML.string("name"));
			System.exit(0);
		}
		if (!domain.types.containsKey(type)) {
			System.out.println("Type " + type.toUpperCase() + " not declared");
			System.exit(0);
		} else {
			parameter.name = paramXML.string("name");
			parameter.type = domain.types.get(type);
		}
		return parameter;
	}

	public Problem problem(String problemName) {
		return problems.get(problemName);
	}
}
