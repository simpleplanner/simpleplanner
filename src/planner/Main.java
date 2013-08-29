package planner;

import planner.planners.Configuration;
import planner.planners.GraphBreadthPlanner;
import planner.planners.Planner;


public class Main {

	/**
	 * -backward -problem problem_filepath -domain problem_filepath
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Configuration config= new Configuration();
		config.domainPath = "example/pddl/domain-veiculo.pddl"; 
		config.problemPath = "example/pddl/problem-veiculo.pddl"; 
	
		Planner planner = new GraphBreadthPlanner();
		
		planner.foward(config.getProblemFromPddl());
		
	}
}
