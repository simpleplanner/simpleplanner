package planner.strips.pddl;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.antlr.runtime.tree.Tree;

import planner.strips.Domain;
import planner.strips.Predicate;
import planner.strips.Problem;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class PDDLProblemLoader extends PDDLLoader {
	private Problem problem;

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
            	problem.goal = loadChildCondition(child).get(0);
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
	
	private void addInitialState(Tree tree) throws PDDLParseException {
		Collection<Predicate> predicates = new HashSet<Predicate>();
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);
			final int type = child.getType();
			switch (type) {
			case PDDLLexer.PRED_INST:
				Predicate p = addPredicate(child);
				predicates.add(p);
				break;
			default:
				throw new PDDLParseException("Unknown node: " + child.getText());
			}
		}
		problem.init.predicates = predicates;
	}

	private void addObjects(Tree objects) throws PDDLParseException {
		for (int i = 0; i < objects.getChildCount(); i++) {
			final Tree object = objects.getChild(i);
			problem.params.add(addParameter(object));
		}
	}
	
}