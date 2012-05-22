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
import planner.strips.Planner;
import planner.strips.Predicate;
import planner.strips.Problem;

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
			for (Condition c : loadChildCondition(problemXML.child("init"))) {
				problem.init.predicates.add((Predicate) c);
			}
			problem.goal = loadChildCondition(problemXML.child("goal")).get(0);
			for (XMLParser objectXML : problemXML.children("object")) {
				problem.objects.add(objectXML.string("name"));
			}
			problem.computeActions();
			problems.put(problem.name, problem);
		}
	}

	private void loadDomain(XMLParser parser) {
		XMLParser domainXML = parser.child("domain");
		domain = new Domain();
		domain.name = domainXML.string("name");
		for (XMLParser actionXML : domainXML.children("action")) {
			domain.actions.add(loadAction(actionXML));
		}
	}

	private Action loadAction(XMLParser actionXML) {
		Action a = new Action();
		a.name = actionXML.string("name");
		for (XMLParser paramXML : actionXML.children("param")) {
			a.params.add(paramXML.string("name"));
		}
		a.precondition = loadChildCondition(actionXML.child("precondition")).get(0);
		a.effects = loadChildCondition(actionXML.child("effect")).get(0);
		return a;
	}

	private List<Condition> loadChildCondition(XMLParser parent) {
		List<Condition> conditions = new ArrayList<Condition>();
		try {
			for (XMLParser notXML : parent.children("not")) {
				Not not = new Not();
				not.predicate = (Predicate) loadChildCondition(notXML).get(0);
				conditions.add(not);
			}
		} catch (Exception e) {
		}

		try {
			for (XMLParser pXML : parent.children("predicate")) {
				Predicate p = new Predicate();
				p.name = pXML.string("name");
				for (XMLParser paramXML : pXML.children("param")) {
					p.params.add(paramXML.string("name"));
				}
				conditions.add(p);
			}
		} catch (Exception e) {
		}

		try {
			for (XMLParser andXML : parent.children("and")) {
				And and = new And();
				and.conditions.addAll(loadChildCondition(andXML));
				conditions.add(and);
			}
		} catch (Exception e) {
		}

		return conditions;
	}

	private Planner planner = new Planner();

	public void plan(String problemName) {
		planner.plan(problems.get(problemName));
	}

}
