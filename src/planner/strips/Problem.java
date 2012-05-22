package planner.strips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Problem {
	public String name;
	public State init = new State();
	public Condition goal;
	public Domain domain;
	public Collection<Action> actions = new HashSet<Action>();
	public Collection<String> objects = new HashSet<String>();

	public void computeActions() {
		for (Action action : domain.actions) {
			computeAllActions(action);
		}
	}

	private void computeAllActions(Action action) {
		int x = action.params.size();
		List<String> params = new ArrayList<String>();
		computeActions(params, action, x);
	}

	private void computeActions(List<String> params, Action action, int left) {
		if (left == 0) {
			Action a = action.copy();
			a.replaceParams(a.params, params);
			actions.add(a);
		} else {
			for (String o : objects) {
				List<String> newParams = new ArrayList<String>(params);
				newParams.add(o);
				computeActions(newParams,action,left-1);
			}
		}
	}

}
