package planner.strips.pddl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.tree.Tree;

import planner.strips.Action;
import planner.strips.Domain;
import planner.strips.Parameter;
import planner.strips.Predicate;
import planner.strips.Type;
import planner.strips.pddl.antlr.PDDLLexer;
import planner.strips.pddl.antlr.PDDLParseException;
import planner.strips.pddl.antlr.PDDLSyntaxException;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class PDDLDomainLoader extends PDDLAbstractLoader {
	
	public PDDLDomainLoader(String file) throws PDDLSyntaxException, IOException {
		super(file);
	}

	public Domain loadDomain() throws PDDLParseException {
		if (domain == null) {
			domain = new Domain();
			int type = rootTree.getType();
			if (type == PDDLLexer.DOMAIN) {
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
			case PDDLLexer.DOMAIN_NAME:
				domain.name = child.getChild(0).getText();
				break;
			case PDDLLexer.REQUIREMENTS:
				addRequirements(child);
				break;
			case PDDLLexer.TYPES:
				addTypes(child);
				break;
			case PDDLLexer.PREDICATES:
				domain.predicates = addPredicates(child);
				break;
			case PDDLLexer.ACTION:
				addAction(child);
				break;
			case PDDLLexer.CONSTANTS:
				throw new UnsupportedOperationException("Constants not supported yet");
			case PDDLLexer.FUNCTIONS:
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
		domain.types.put("object", new Type("object"));
		for (int i = 0; i < types.getChildCount(); i++) {
			final Tree type = types.getChild(i);
			String typeName = type.getText();
			Type parentType = null;
			if (type.getChildCount() != 0) {
				parentType = domain.types.get(type.getChild(0).getText());
			}else{
				parentType = domain.types.get("object");
			}
			domain.types.put(typeName, new Type(typeName, parentType));
		}
	}

	private void addAction(Tree tree) throws PDDLParseException{
		Action a = new Action();
        a.name = tree.getChild(0).getText();
        
        for (int i = 1; i < tree.getChildCount(); i++) {
            final Tree child = tree.getChild(i);
            final int type = child.getType();
            switch (type) {
                case PDDLLexer.VARIABLE:
                    a.params.add(addParameter(child));
                    break;
                case PDDLLexer.PRECONDITION:
                    a.precondition = loadChildCondition(a, child).get(0);
                    break;
                case PDDLLexer.EFFECT:
                    a.effects = loadChildCondition(a, child).get(0);
                    break;
                default:
                    throw new PDDLParseException("Invalid action child node: " + child.getText());
            }
        }
        
        domain.actions.add(a);
    }
	
	private Map<String, Predicate> addPredicates(Tree preds) throws PDDLParseException {
		Map<String, Predicate> predicates = new HashMap<String, Predicate>();
		
		for (int i = 0; i < preds.getChildCount(); i++) {
			final Tree tree = preds.getChild(i);
			Predicate predicate = addDomainPredicate(tree);
			
			predicates.put(predicate.name, predicate);
		}
		
		return predicates;
	}
	
	private Predicate addDomainPredicate(Tree tree) throws PDDLParseException{
		Predicate predicate = new  Predicate();
		
		predicate.name = tree.getText();
		predicate.params = addDomainParameters(tree);
		
		return predicate;
	}
	
	private List<Parameter> addDomainParameters(Tree tree) throws PDDLParseException {
		List<Parameter> params = new ArrayList<Parameter>();
		
		for (int j = 0; j < tree.getChildCount(); j++) {
			params.add(addParameter(tree.getChild(j)));
		}
		
		return params;
	}

}