package planner.strips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;


public class Planner extends AbstractPlanner{
	
	@Override
	public void graphBreadth(Problem p){
		List<State> currentSolutions = new ArrayList<State>();
		Collection<State> visited = new HashSet<State>();
		currentSolutions.add(p.init);
		State solution = null;
		int count = 1;
		while(solution == null){
			visited.addAll(currentSolutions);
			Collection<State> newSolutions = new HashSet<State>();
			System.out.println("Computing level: " + count++ + "...");
			for (State state : currentSolutions) {
				if (state.solves(p)){
					solution = state;
					break;
				}else{
					newSolutions.addAll(state.expand(p));
				}
			}
			currentSolutions = new ArrayList<State>();
			for (State state : newSolutions) {
				if (!visited.contains(state))
					currentSolutions.add(state);
			}
			
			System.out.println("   Expanded states:          "+newSolutions.size());
			System.out.println("   Number of visited states: "+visited.size());
			System.out.println("   Level width:              "+currentSolutions.size());

			if (currentSolutions.size() == 0)
				break;
			solution = searchSolution(currentSolutions, p);
		}
		if (solution != null)
			printPlan(solution);
		else
			System.out.println("NO SOLUTION FOUND");
	}

	private State searchSolution(List<State> solutions, Problem p) {
		for (State state : solutions) {
			if (state.solves(p)){
				return state;
			}
		}
		return null;
	}

	@Override
	public void graphDepth(Problem p) {
		Stack<State> currentSolutions = new Stack<State>();
		Collection<State> visited = new HashSet<State>();
		State solution = null;
		currentSolutions.push(p.init);
		while(solution == null && currentSolutions.size() != 0){
			State stateAtual = currentSolutions.pop();
			visited.add(stateAtual);
			
			if (stateAtual.solves(p)){
				solution = stateAtual;
				break;
			}
			
			Collection<State> newSolutions = new HashSet<State>();
			newSolutions.addAll(stateAtual.expand(p));
			
			for (State state : newSolutions) {
				if (!visited.contains(state))
					currentSolutions.push(state);
			}

			System.out.println("   Expanded states:          "+newSolutions.size());
			System.out.println("   Number of visited states: "+visited.size());
			System.out.println("   Level width:              "+currentSolutions.size());
		}
		if (solution != null)
			printPlan(solution);
		else
			System.out.println("NO SOLUTION FOUND");
		System.out.println("Number of visited states: "+visited.size());
	}
	
	@Override
	public void treeBreadth(Problem p) {
	}

	@Override
	public void treeDepth(Problem p) {
	}
}
