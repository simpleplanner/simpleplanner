package planner.strips;

import java.util.Stack;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
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
		System.out.println("\nSOLUTION FOUND:");
		System.out.println("======================================================");
		while (!actionStack.empty()) {
			System.out.println("Action: "+actionStack.pop());
		}
		System.out.println("======================================================\n");
	}
}
