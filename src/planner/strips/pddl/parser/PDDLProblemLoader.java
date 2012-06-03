package planner.strips.pddl.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import planner.strips.And;
import planner.strips.Condition;
import planner.strips.Domain;
import planner.strips.Not;
import planner.strips.Parameter;
import planner.strips.Predicate;
import planner.strips.Problem;
import planner.strips.Type;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class PDDLProblemLoader {
	protected CommonTree rootTree;
	private final String file;
	private Domain domain;
	private Problem problem;

	public PDDLProblemLoader(Domain domain, String file) throws PDDLSyntaxException, IOException {
		this.file = file;
		this.domain = domain;
		buildTree();
	}

	private void buildTree() throws PDDLSyntaxException, IOException {
		PddlLexer lex = new PddlLexer(new ANTLRFileStream(file));
		CommonTokenStream tokens = new CommonTokenStream(lex);

		PddlParser parser = new PddlParser(tokens);

		try {
			PddlParser.pddlDoc_return t = parser.pddlDoc();
			rootTree = (CommonTree) t.getTree();

			if (parser.invalidGrammar()) {
				throw new PDDLSyntaxException();
			}

		} catch (RecognitionException e) {
			throw new PDDLSyntaxException(e);
		}
	}

	public Problem loadProblem() throws PDDLParseException, PDDLSyntaxException {
		if (problem == null) {
			problem = new Problem();
			int type = rootTree.getType();
			if (type == PddlLexer.PROBLEM) {
				buildProblem(rootTree);
			} else {
				throw new PDDLParseException("The file " + file + " does not contain a PDDL problem");
			}
		}
		return problem;
	}

	private void buildProblem(Tree problemTree) throws PDDLParseException, PDDLSyntaxException {
		for (int i = 0; i < problemTree.getChildCount(); i++) {
			final Tree child = problemTree.getChild(i);
			final int type = child.getType();
			switch (type) {
			case PddlLexer.PROBLEM_NAME:
				problem.name = child.getChild(0).getText();
				break;
			case PddlLexer.PROBLEM_DOMAIN:
                String domainName = child.getChild(0).getText();
                if (!domain.name.equals(domainName)) {
                    throw new PDDLSyntaxException("Invalid domain");
                }
                break;
            case PddlLexer.REQUIREMENTS:
                //Nothing
                break;
            case PddlLexer.OBJECTS:
                addObjects(child);
                break;
            case PddlLexer.INIT:
                addInitialState(child);
                break;
            case PddlLexer.GOAL:
            	problem.goal = loadChildCondition(child).get(0);
                break;
            case PddlLexer.PROBLEM_CONSTRAINT:
                throw new UnsupportedOperationException("Constraints not supported yet");
            case PddlLexer.PROBLEM_METRIC:
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
			case PddlLexer.PRED_INST:
				Predicate p = new Predicate();
				p.name = child.getChild(0).getText();
				if (child.getChildCount() > 1){
					for (int j = 1; j < child.getChildCount(); j++) {
						p.params.add(addParameter(child.getChild(j)));
					}
				}
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
	
	
	
	
	private List<Condition> loadChildCondition(Tree tree) throws PDDLParseException{
		List<Condition> conditions = new ArrayList<Condition>();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);
			final int type = child.getType();
	        switch (type) {
	        	case PddlLexer.PRED_HEAD:
	        		Predicate p = new Predicate();
					p.name = child.getChild(0).getText();
					if (child.getChildCount() > 1){
						for (int j = 1; j < child.getChildCount(); j++) {
							p.params.add(addParameter(child.getChild(j)));
						}
					}
					conditions.add(p);
					break;
	        	case PddlLexer.NOT_GD:
	        	case PddlLexer.NOT_EFFECT:
	        		Not not = new Not();
					not.predicate = (Predicate) loadChildCondition(child).get(0);
					conditions.add(not);
	        		break;
	            case PddlLexer.AND_GD:
	            case PddlLexer.AND_EFFECT:
	            	And and = new And();
            		and.conditions.addAll(loadChildCondition(child));
					conditions.add(and);
					break;
	            case PddlLexer.OR_GD:
	                throw new UnsupportedOperationException("OR goalDescs not supported yet");
	            case PddlLexer.COMPARISON_GD:
	            	throw new UnsupportedOperationException("COMPARISON not supported yet");
	            case PddlLexer.IMPLY_GD:
	                throw new UnsupportedOperationException("IMPLY not supported yet");
	            case PddlLexer.EXISTS_GD:
	                throw new UnsupportedOperationException("EXISTS not supported yet");
	            case PddlLexer.FORALL_GD:
	                throw new UnsupportedOperationException("FORALL not supported yet");
	            default:
	                throw new PDDLParseException("Unknown node: " + child.getText());
	        }
		}
		
        return conditions;
    }
	
	private Parameter addParameter(Tree tree) throws PDDLParseException {
		Parameter p = new Parameter();
		p.name = tree.getText();
			
		if (tree.getChildCount() == 0) {
	        p.type = domain.types.get("object");
	    } else {
	    	String typeName = tree.getChild(0).getText();
	    	Type type = domain.types.get(typeName);
	    	if (type == null){
	    		throw new PDDLParseException("Type " + typeName + " not declared");
	    	}
	        p.type = type;
	    }
			
		return p;
	}
}