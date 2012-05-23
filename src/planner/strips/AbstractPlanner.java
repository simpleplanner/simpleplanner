package planner.strips;

import java.util.Stack;

/**
 * @author Sávio Mota
 *
 */
public abstract class AbstractPlanner {

	public abstract void treeBreadth(Problem p);
	public abstract void treeDepth(Problem p);
	public abstract void graphBreadth(Problem p);
	public abstract void graphDepth(Problem p);
	
	
	public void printPlan(State solution) {
		Stack<Action> actionStack = new Stack<Action>();
		while (solution.cause != null){
			actionStack.add(solution.cause);
			solution = solution.last;
		}
		while (!actionStack.empty()) {
			System.out.println("Action: "+actionStack.pop());
		}
	}
}
