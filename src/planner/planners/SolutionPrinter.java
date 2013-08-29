package planner.planners;

import java.util.Stack;

import planner.strips.Action;
import planner.strips.State;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class SolutionPrinter {

	private static final SolutionPrinter INSTANCE = new SolutionPrinter();
	
	public static SolutionPrinter getInstance(){
		return INSTANCE;
	}
	
	public void printPlan(State solution) {
		if(solution != null){
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
		}else{
			System.out.println("NO SOLUTION FOUND");
		}
	}
}
