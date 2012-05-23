package planner.strips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class Problem extends Parametized{
	public State init = new State();
	public Condition goal;
	public Domain domain;
	public Collection<Action> actions = new HashSet<Action>();

	public void computeActions() {
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
			if (typeMap.containsKey(p.type)){
				Collection<Parameter> ps = typeMap.get(p.type);
				for (Parameter parameter : ps) {
					List<Parameter> newParams = new ArrayList<Parameter>(params);
					newParams.add(parameter);
					computeActions(newParams,action,left-1);
				}
			}else{
				System.out.println("Nenhum objeto do tipo " + p.type.toUpperCase() + " foi declarado.");
				System.exit(0);
			}
		} else {
			Action a = action.copy();
			a.replaceParams(a.params, params);
			actions.add(a);
		}
	}
	
}
