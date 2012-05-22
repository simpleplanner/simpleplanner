package planner.strips;

import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;

public class PlannerDFS extends Planner{
	private Collection<State> visited = new HashSet<State>();
	
	public void plan(Problem p){
		Stack<State> currentSolutions = new Stack<State>();
		State solution = null;
		currentSolutions.push(p.init);
		int count = 1;
		while(solution == null && currentSolutions.size() != 0){
			State stateAtual = currentSolutions.pop();
			visited.add(stateAtual);
			
			if (stateAtual.solves(p)){
				solution = stateAtual;
				break;
			}
			
			Collection<State> newSolutions = new HashSet<State>();
			System.out.println("Computing level: " + count++ + "...");
			newSolutions.addAll(stateAtual.expand(p));
			
			for (State state : newSolutions) {
				if (!visited.contains(state))
					currentSolutions.push(state);
			}
			
		}
		if (solution != null)
			printPlan(solution);
		else
			System.out.println("NO SOLUTION FOUND");
		System.out.println("Number of visited states: "+visited.size());
	}

}
