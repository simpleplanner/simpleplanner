package planner.comparisons;

import java.util.ArrayList;
import java.util.List;

import planner.strips.Condition;
import planner.strips.Parameter;
import planner.strips.State;

public abstract class MultiCondition  implements Condition {
	public List<Condition> conditions = new ArrayList<Condition>();

    public MultiCondition() {
    }

    public MultiCondition(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public State apply(State s) {
        State novo = s.copy();
        for (Condition c : conditions) {
            novo = c.apply(novo);
        }
        return novo;
    }

	@Override
	public State unapply(State state) {
		State novo = state.copy();
		for (Condition c : conditions) {
			novo = c.unapply(novo);
		}
		return novo;
	}
	
    @Override
    public boolean verify(State s) {
        for (Condition c : conditions) {
            if (!c.verify(s)) {
                return false;
            }
        }
        return true;
    }

    public void replaceParams(List<Parameter> oldNames, List<Parameter> newNames) {
        for (Condition c : conditions) {
            c.replaceParams(oldNames, newNames);
        }
    }

    @Override
    public String toString() {
        String retorno = "(=";
        for (Condition p : conditions) {
            retorno += " " + p;
        }
        retorno += ")";
        return retorno;
    }

    
    public Condition copy() {
        MultiCondition copy = null;
		try {
			copy = this.getClass().newInstance();
			for (Condition c : conditions) {
				copy.conditions.add(c.copy());
			}
		} catch (InstantiationException | IllegalAccessException e) {
		}
        return copy;
    }
    
}
