package planner.strips.pddl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.antlr.runtime.tree.Tree;

import planner.fluents.Function;
import planner.strips.And;
import planner.strips.Condition;
import planner.strips.Domain;
import planner.strips.OR;
import planner.strips.Predicate;
import planner.strips.Problem;
import planner.strips.pddl.antlr.PDDLLexer;
import planner.strips.pddl.antlr.PDDLParseException;
import planner.strips.pddl.antlr.PDDLSyntaxException;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 * Classe alterada por: Ellen Gera, Helcio Soares e Rogerio Figueredo.
 * A alteração permitiu que a classe reconheça tokens do tipo:
 * -> FUNC_HEAD
 * -> INIT_EQ
 * -> NUMBER
 */
public class PDDLProblemLoader extends PDDLAbstractLoader {
	private Problem problem;
	private Problem problemB;

	public PDDLProblemLoader(Domain domain, String file) throws PDDLSyntaxException, IOException {
		super(file);
		this.domain = domain;


	}

	public Problem loadProblem() throws PDDLParseException, PDDLSyntaxException {
		if (problem == null) {
			problem = new Problem();
			int type = rootTree.getType();
			if (type == PDDLLexer.PROBLEM) {
				buildProblem(rootTree);
			} else {
				throw new PDDLParseException("The file " + file + " does not contain a PDDL problem");
			}
		}
		problem.computeActions();
		return problem;
	}

	public Problem loadProblemB() throws PDDLParseException, PDDLSyntaxException {
		if (problemB == null) {
			problemB = new Problem();
			int type = rootTree.getType();
			if (type == PDDLLexer.PROBLEM) {
				buildProblemB(rootTree);
			} else {
				throw new PDDLParseException("The file " + file + " does not contain a PDDL problem");
			}

		}
		problemB.computeActions();
		return problemB;
	}

	private void buildProblem(Tree problemTree) throws PDDLParseException, PDDLSyntaxException {
		for (int i = 0; i < problemTree.getChildCount(); i++) {
			final Tree child = problemTree.getChild(i);
			final int type = child.getType();
			switch (type) {
			case PDDLLexer.PROBLEM_NAME:
				problem.name = child.getChild(0).getText();
				break;
			case PDDLLexer.PROBLEM_DOMAIN:
				String domainName = child.getChild(0).getText();
				if (!domain.name.equals(domainName)) {
					throw new PDDLSyntaxException("Invalid domain");
				}
				problem.domain = domain;
				break;
			case PDDLLexer.REQUIREMENTS:
				//Nothing
				break;
			case PDDLLexer.OBJECTS:
				addObjects(child);
				break;
			case PDDLLexer.INIT:
				addInitialState(child);
				break;
			case PDDLLexer.GOAL:
				problem.goal = loadChildCondition(problem, child).get(0);

				break;
			case PDDLLexer.PROBLEM_CONSTRAINT:
				throw new UnsupportedOperationException("Constraints not supported yet");
			case PDDLLexer.PROBLEM_METRIC:
				throw new UnsupportedOperationException("Metrics not supported yet");
			default:
				throw new UnsupportedOperationException("Unsupported :problem child element - " + child.getText());
			}
		}
	}

	public boolean isAndOr(Tree problemTree){
		// verica se GOAL � OR ou AND 
		boolean r=false;
		for (int j=0;j<problemTree.getChild(problemTree.getChildCount()-1).getChildCount();j++){
			if (problemTree.getChild(problemTree.getChildCount()-1).getChild(j).getType()==PDDLLexer.AND_GD){
				r=true;
				break;
			}
		}
		return r;
	}

	private void buildProblemB(Tree problemTree) throws PDDLParseException, PDDLSyntaxException {
		boolean and_or =isAndOr(problemTree);		

		for (int i = 0; i < problemTree.getChildCount(); i++) {
			final Tree child = problemTree.getChild(i);

			final int type = child.getType();
			switch (type) {
			case PDDLLexer.PROBLEM_NAME:
				problemB.name = child.getChild(0).getText();
				break;
			case PDDLLexer.PROBLEM_DOMAIN:
				String domainName = child.getChild(0).getText();
				if (!domain.name.equals(domainName)) {
					throw new PDDLSyntaxException("Invalid domain");
				}
				problemB.domain = domain;
				break;
			case PDDLLexer.REQUIREMENTS:
				//Nothing
				break;
			case PDDLLexer.OBJECTS:
				addObjectsB(child);
				break;
			case PDDLLexer.GOAL:
				addInitialStateB(child);
				break;
			case PDDLLexer.INIT:
				addGoalStateB(child,and_or);
				break;
			case PDDLLexer.PROBLEM_CONSTRAINT:
				throw new UnsupportedOperationException("Constraints not supported yet");
			case PDDLLexer.PROBLEM_METRIC:
				throw new UnsupportedOperationException("Metrics not supported yet");
			default:
				throw new UnsupportedOperationException("Unsupported :problem child element - " + child.getText());
			}
		}




	}

	/**
	 * Alterado Por: Ellen Gera, Helcio Soares e Rogerio Figueredo
	 * Método alterado para aceitar o token:
	 * -> INIT_EQ;
	 * Adicionada funcionalidade para carregar as funções do problema.
	 */
	private void addInitialState(Tree tree) throws PDDLParseException {
		Collection<Predicate> predicates = new HashSet<Predicate>();
		Collection<Function> functions = new HashSet<Function>();
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);
			final int type = child.getType();
			switch (type) {
			case PDDLLexer.PRED_INST:
				Predicate p = addPredicate(problem, child);
				predicates.add(p);
				break;
			case PDDLLexer.INIT_EQ:
				addInitEq(child, functions);
				break;
			default:
				throw new PDDLParseException("Unknown node: " + child.getText());
			}
		}
		problem.init.predicates = predicates;
		problem.init.functions = functions;
		problem.functions      = functions;
	}

	private void addInitialStateB(Tree tree) throws PDDLParseException {
		Collection<Predicate> predicates = new HashSet<Predicate>();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);

			Predicate p = new Predicate();
			final int type = child.getType();
			switch (type) {

			case PDDLLexer.AND_GD:

				for (int j = 0; j < child.getChildCount(); j++){
					p = addPredicate(problemB, child.getChild(j));
					predicates.add(p);
				}
				break;

			case PDDLLexer.NOT_GD:
				for (int j = 0; j < child.getChildCount(); j++){
					p = addPredicate(problemB, child.getChild(j));
					predicates.add(p);
				}
				break;
			case PDDLLexer.OR_GD:
				for (int j = 0; j < child.getChildCount(); j++){
					p = addPredicate(problemB, child.getChild(j));
					predicates.add(p);
				}
				break;

			default:
				throw new PDDLParseException("Unknown node: " + child.getText());
			}
		}
		problemB.goalAsState.predicates = predicates;
		//problemB.init.predicates = predicates;
		//**
	}

	private void addGoalStateB(Tree tree, boolean or_and) throws PDDLParseException {
		Condition c;
		And and = new And();
		OR or = new OR();
		List<Predicate> p= new ArrayList<>();
		List<Predicate> pre = new ArrayList<>();
		for (int j=0;j<tree.getChildCount();j++){
			p.add(addPredicate(problem, tree.getChild(j)));
			pre.add(addPredicate(problemB, tree.getChild(j)));
		}
		if (or_and){
			and.conditions.addAll(pre);
			problemB.initAsCondition = and;
		}else{
			or.conditions.addAll(p);
			problemB.initAsCondition = or;
		}


	}

	private void addObjects(Tree objects) throws PDDLParseException {
		for (int i = 0; i < objects.getChildCount(); i++) {
			final Tree object = objects.getChild(i);
			problem.params.add(addParameter(object));
		}
	}

	private void addObjectsB(Tree objects) throws PDDLParseException {
		for (int i = 0; i < objects.getChildCount(); i++) {
			final Tree object = objects.getChild(i);
			problemB.params.add(addParameter(object));

		}
	}

	/**
	 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
	 * Método alterado para aceitar o token:
	 * -> FUNC_HEAD;
	 * -> NUMBER;
	 * Adicionada funcionalidade para carregar as funções do problema.
	 */        
	private void addInitEq(Tree tree, Collection<Function> functions) throws PDDLParseException{
		Function f = null;
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);
			final int type = child.getType();
			switch (type) {
			case PDDLLexer.FUNC_HEAD:
				f = addFunction(problem, child);
				functions.add(f);
				break;
			case PDDLLexer.NUMBER:
				f.value = Integer.parseInt(child.getText());
				break;
			default:
				throw new PDDLParseException("Unknown node: " + child.getText());
			}
		}

	}

}