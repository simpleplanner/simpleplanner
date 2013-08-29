package planner.strips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import planner.fluents.Function;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */

public class Problem extends Parametized{
	public State init = new State();
	public Condition initAsCondition;
	public Condition goal;
	public State goalAsState = new State();
	public Domain domain;
	public Collection<Action> actions = new HashSet<Action>();
        public Collection<Function> functions = new HashSet<Function>();

	public void computeActions() {
		buildTypeMap();
		for (Action action : domain.actions) {
			computeAllActions(action);
		}
	}

	private void computeAllActions(Action action) {
		int x = action.params.size();
		List<Parameter> params = new ArrayList<Parameter>();
		computeActions(params, action, x);
	}
	
	/**
	 * Suporte a tipos...
	 * 
	 * @author Sávio Mota
	 * 
	 */
	
	private void computeActions(List<Parameter> params, Action action, int left) {
		if (left != 0) {
			Parameter p = action.params.get(action.params.size() - left);
			if (typeMap.containsKey(p.type.name)){
				Collection<Parameter> ps = typeMap.get(p.type.name);
				for (Parameter parameter : ps) {
					List<Parameter> newParams = new ArrayList<Parameter>(params);
					newParams.add(parameter);
					computeActions(newParams,action,left-1);
				}
			}else{
				System.out.println("Nenhum objeto do tipo " + p.type.name.toUpperCase() + " foi declarado.");
				System.exit(0);
			}
		} else {
                       
			Action a = action.copy();
			a.replaceParams(a.params, params);
                        a.applyAssignEffects(this);
                        a.applyPreConditions(this);
			actions.add(a);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("(define (problem " + name + ")\n");
		builder.append("	(:domain " + domain.name);
		builder.append(")\n	(:objects ");
		for (Parameter p : params) {
			builder.append(p.name + " - " + p.type);
		}
		builder.append("	)\n	(:init\n");
		for (Predicate p : init.predicates) {
			builder.append("		" + p + "\n");
		}
		for (Function f : init.functions) {
			builder.append("		" + f + "\n");
		}
		builder.append("	)\n	(:goal " + goal);
		builder.append("	)\n");
		builder.append(")");
		
		return builder.toString();
	}
}
