package planner.strips.pddl.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import planner.strips.Action;
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
public class PDDLLoader {
	protected CommonTree rootTree;
	private final String file;
	private Domain domain;
	private Map<String, Problem> problems = new HashMap<String, Problem>();
	public Collection<String> types = new HashSet<String>();

	public PDDLLoader(String file) {
		this.file = file;
	}

	public void buildTree() throws PDDLSyntaxException, IOException {
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

	public Domain loadDomain() throws PDDLParseException {
		if (domain == null) {
			domain = new Domain();
			int type = rootTree.getType();
			if (type == PddlLexer.DOMAIN) {
				buildDomain(rootTree);
			} else {
				throw new PDDLParseException("The file " + file + " does not contain a PDDL domain");
			}
		}
		return domain;
	}

	private void buildDomain(Tree domainTree) throws PDDLParseException {
		for (int i = 0; i < domainTree.getChildCount(); i++) {
			final Tree child = domainTree.getChild(i);
			final int type = child.getType();
			switch (type) {
			case PddlLexer.DOMAIN_NAME:
				domain.name = child.getChild(0).getText();
				break;
			case PddlLexer.REQUIREMENTS:
				addRequirements(child);
				break;
			case PddlLexer.TYPES:
				addTypes(child);
				break;
			case PddlLexer.PREDICATES:
				addPredicates(child);
				break;
			case PddlLexer.ACTION:
				addAction(child);
				break;
			case PddlLexer.CONSTANTS:
				throw new UnsupportedOperationException("Constants not supported yet");
			case PddlLexer.FUNCTIONS:
				throw new UnsupportedOperationException("Functions not supported yet");
			default:
				// DURATIVE_ACTION, ':derived', ':constraints'
				throw new UnsupportedOperationException("Unsupported :domain child element - " + child.getText());
			}
		}
	}

	private void addRequirements(Tree requirements) {
		for (int i = 0; i < requirements.getChildCount(); i++) {
			final Tree req = requirements.getChild(i);
			domain.requirements.add(req.getText());
		}
	}

	private void addTypes(Tree types) throws PDDLParseException {
		for (int i = 0; i < types.getChildCount(); i++) {
			final Tree type = types.getChild(i);
			if (type.getChildCount() != 0) {
				String parentTypeName = type.getChild(0).getText();
                Type parentType = domain.types.get(parentTypeName);
                domain.types.put(parentTypeName, new Type(parentTypeName, parentType));
			}
		}
	}

	private void addPredicates(Tree preds) throws PDDLParseException {
		for (int i = 0; i < preds.getChildCount(); i++) {
			Predicate predicate = new  Predicate();
			final Tree tree = preds.getChild(i);
			
			predicate.name = tree.getText();

			predicate.params = addParameters(tree);
			domain.predicates.put(predicate.name, predicate);
		}
	}

	private List<Parameter> addParameters(Tree tree) throws PDDLParseException {
		List<Parameter> params = new ArrayList<Parameter>();
		
		for (int j = 0; j < tree.getChildCount(); j++) {
			params.add(addParameter(tree.getChild(j)));
		}
		
		return params;
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

	
	private void addAction(Tree tree) throws PDDLParseException{
		Action a = new Action();
        a.name = tree.getChild(0).getText();
        
        for (int i = 1; i < tree.getChildCount(); i++) {
            final Tree child = tree.getChild(i);
            final int type = child.getType();
            //Esta passando tudo logo no addParameteres (tudo = effects e preconditions)
            switch (type) {
                case PddlLexer.VARIABLE:
                    a.params.add(addParameter(child));
                    break;
                case PddlLexer.PRECONDITION:
                    a.precondition = loadChildCondition(child).get(0);
                    break;
                case PddlLexer.EFFECT:
                    a.effects = loadChildCondition(child).get(0);
                    break;
                default:
                    throw new PDDLParseException("Invalid action child node: " + child.getText());
            }
        }
        
        domain.actions.add(a);
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
}