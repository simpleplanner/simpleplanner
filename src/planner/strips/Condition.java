package planner.strips;

import java.util.List;

public interface Condition {
	public boolean verify(State s);
	public State apply(State s);
	public void replaceParams(List<String> oldNames, List<String> newNames);
	public Condition copy();
}
