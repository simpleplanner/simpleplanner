package planner;

import java.io.IOException;

import planner.strips.Problem;
import planner.strips.pddl.PDDLLoader;
import planner.strips.pddl.antlr.PDDLParseException;
import planner.strips.pddl.antlr.PDDLSyntaxException;
import planner.strips.planners.AbstractPlanner;
import planner.strips.planners.Planner;
import planner.strips.xml.Loader;

public class Main {
	static String[] tokenNames;

	public static void main(String[] args) throws Exception {
		AbstractPlanner planner = new Planner();
		
		Problem problem = null;
		
		problem = getProblemFromPddl();
		//problem = getProblemFromXml();
		
		long time1 = System.nanoTime();
		planner.graphBreadth(problem);
		long time2 = System.nanoTime();

		System.out.println("Tempo gasto => " + ((time2 - time1)/1000000000.0) + " segundos");
	}
	
	
	private static Problem getProblemFromXml() {
		Loader l = new Loader("example/xml/gripper.xml");
		return l.problem("gripper8");
	}


	private static Problem getProblemFromPddl() throws PDDLSyntaxException, IOException, PDDLParseException{
		String domainFile = new String("example/pddl/domain-gripper.pddl");
		String problemFile = new String("example/pddl/problem-gripper8.pddl");
		PDDLLoader pddlLoader = new PDDLLoader(domainFile, problemFile);
		
		return pddlLoader.getProblem();
	}

}
