package planner.strips;
import java.util.List;

import planner.strips.Condition;
import planner.strips.Parameter;
import planner.strips.State;


public class ConditionImpl implements Condition {

	public boolean verifyResult;
	
	public ConditionImpl(boolean verifyResult) {
		super();
		this.verifyResult = verifyResult;
	}

	@Override
	public boolean verify(State s) {
		return verifyResult;
	}

	@Override
	public State apply(State s) {
		return s.copy();
	}

	@Override
	public void replaceParams(List<Parameter> oldNames, List<Parameter> newNames) {
	}

	@Override
	public Condition copy() {
		return new ConditionImpl(this.verifyResult);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (verifyResult ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConditionImpl other = (ConditionImpl) obj;
		if (verifyResult != other.verifyResult)
			return false;
		return true;
	}

	@Override
	public State unapply(State state) {
		return state.copy();
	}
	
}
