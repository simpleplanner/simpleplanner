package planner.planners;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import planner.strips.Problem;
import planner.strips.State;

public class GraphBreadthPlanner implements Planner {

	State solution;

	public GraphBreadthPlanner() {
	}
	
	@Override
	public State foward(Problem p) {
		List<State> currentSolutions = new ArrayList<State>();
		Collection<State> visited = new HashSet<State>();
		currentSolutions.add(p.init);
		solution = null;
		int count = 1;
		while(solution == null){
			visited.addAll(currentSolutions);
			Collection<State> newSolutions = new HashSet<State>();
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
		
			printStatis(count++, currentSolutions, visited, newSolutions);

			if (currentSolutions.size() == 0)
				break;
			solution = searchSolution(currentSolutions, p);
		}
		SolutionPrinter.getInstance().printPlan(solution);
		return solution;
	}

	
	private void printStatis(int count, List<State> currentSolutions,
			Collection<State> visited, Collection<State> newSolutions) {
			log("Computing level: " + count+ "...");
			log("   Expanded states:          "+newSolutions.size());
			log("   Number of visited states: "+visited.size());
			log("   Level width:              "+currentSolutions.size());
	}
	
	private void log(String string) {
		System.out.println(string);
	}
	
	@Override
	public State backward(Problem p){
		List<State> currentSolutions = new ArrayList<State>();
		Collection<State> visited = new HashSet<State>();
		System.out.println(p.goalAsState);
		currentSolutions.add(p.goalAsState);
		solution = null;
		int count = 1;
		while(solution == null){
			visited.addAll(currentSolutions);
			Collection<State> newSolutions = new HashSet<State>();
			for (State state : currentSolutions) {
				if (state.solvesBack(p)){
					solution = state;
					break;
				}else{
					newSolutions.addAll(state.regression(p));
				}
			}
			currentSolutions = new ArrayList<State>();
			for (State state : newSolutions) {
				if (!visited.contains(state))
					currentSolutions.add(state);
			}
			printStatis(count++, currentSolutions, visited, newSolutions);
			if (currentSolutions.size() == 0)
				break;
			solution = searchSolutionBack(currentSolutions, p);
		}
		SolutionPrinter.getInstance().printPlan(solution);
		return solution;
	}
	
	private State searchSolutionBack(List<State> solutions, Problem p) {
		for (State state : solutions) {
			if (state.solvesBack(p)){
				return state;
			}
		}
		return null;
	}
	

	private State searchSolution(List<State> solutions, Problem p) {
		for (State state : solutions) {
			if (state.solves(p)){
				return state;
			}
		}
		return null;
	}

}
