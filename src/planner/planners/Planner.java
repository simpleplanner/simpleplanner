package planner.planners;

import planner.strips.Problem;
import planner.strips.State;

public interface Planner{

	public State foward(Problem p);
	public State backward(Problem p);

}
