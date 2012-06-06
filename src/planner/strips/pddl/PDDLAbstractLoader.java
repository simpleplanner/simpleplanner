package planner.strips.pddl;

import java.io.IOException;
import java.util.ArrayList;
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
import planner.strips.Type;
import planner.strips.pddl.antlr.PDDLLexer;
import planner.strips.pddl.antlr.PDDLParseException;
import planner.strips.pddl.antlr.PDDLParser;
import planner.strips.pddl.antlr.PDDLSyntaxException;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 *
 */
public abstract class PDDLAbstractLoader {
	protected String file;
	protected CommonTree rootTree;
	protected Domain domain;

	public PDDLAbstractLoader(String file) throws PDDLSyntaxException, IOException {
		this.file = file;
		buildTree();
	}

	private void buildTree() throws PDDLSyntaxException, IOException {
		PDDLLexer lex = new PDDLLexer(new ANTLRFileStream(file));
		CommonTokenStream tokens = new CommonTokenStream(lex);
	
		PDDLParser parser = new PDDLParser(tokens);
	
		try {
			PDDLParser.pddlDoc_return t = parser.pddlDoc();
			rootTree = (CommonTree) t.getTree();
	
			if (parser.invalidGrammar()) {
				throw new PDDLSyntaxException();
			}
	
		} catch (RecognitionException e) {
			throw new PDDLSyntaxException(e);
		}
	}

	protected Parameter addParameter(Tree tree) throws PDDLParseException {
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

	protected List<Condition> loadChildCondition(Tree tree) throws PDDLParseException {
		List<Condition> conditions = new ArrayList<Condition>();
	
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);
			final int type = child.getType();
	        switch (type) {
	        	case PDDLLexer.PRED_HEAD:
	        		Predicate p = addPredicate(child);
					conditions.add(p);
					break;
	        	case PDDLLexer.NOT_GD:
	        	case PDDLLexer.NOT_EFFECT:
	        		Not not = new Not();
					not.predicate = (Predicate) loadChildCondition(child).get(0);
					conditions.add(not);
	        		break;
	            case PDDLLexer.AND_GD:
	            case PDDLLexer.AND_EFFECT:
	            	And and = new And();
	        		and.conditions.addAll(loadChildCondition(child));
					conditions.add(and);
					break;
	            case PDDLLexer.OR_GD:
	                throw new UnsupportedOperationException("OR goalDescs not supported yet");
	            case PDDLLexer.COMPARISON_GD:
	            	throw new UnsupportedOperationException("COMPARISON not supported yet");
	            case PDDLLexer.IMPLY_GD:
	                throw new UnsupportedOperationException("IMPLY not supported yet");
	            case PDDLLexer.EXISTS_GD:
	                throw new UnsupportedOperationException("EXISTS not supported yet");
	            case PDDLLexer.FORALL_GD:
	                throw new UnsupportedOperationException("FORALL not supported yet");
	            default:
	                throw new PDDLParseException("Unknown node: " + child.getText());
	        }
		}
		
	    return conditions;
	}

	protected Predicate addPredicate(Tree tree) throws PDDLParseException {
		Predicate p = new Predicate();
		String predicateName = tree.getChild(0).getText();
		
		if (domain.predicates.containsKey(predicateName)){
			p.name = predicateName;
			if (tree.getChildCount() > 1){
				for (int j = 1; j < tree.getChildCount(); j++) {
					p.params.add(addParameter(tree.getChild(j)));
				}
			}
			return p;
		}else{
			throw new PDDLParseException("Predicate " + predicateName + " not declared");
		}
	}

}