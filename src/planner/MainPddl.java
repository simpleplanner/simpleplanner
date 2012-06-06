package planner;

import planner.strips.Domain;
import planner.strips.Problem;
import planner.strips.pddl.PDDLDomainLoader;
import planner.strips.pddl.PDDLProblemLoader;
import planner.strips.planners.AbstractPlanner;
import planner.strips.planners.Planner;

public class MainPddl {
	static String[] tokenNames;

	public static void main(String[] args) throws Exception {
		String domainFile = new String("example/pddl/blocks.pddl");
		String problemFile = new String("example/pddl/blocksprob1.pddl");

		PDDLDomainLoader builder = new PDDLDomainLoader(domainFile);
		Domain domain = builder.loadDomain();
		
		PDDLProblemLoader problemBuilder = new PDDLProblemLoader(domain, problemFile);
		Problem problem = problemBuilder.loadProblem();
		System.out.println(domain);
		System.out.println();System.out.println();
		System.out.println(problem);
		
		
		AbstractPlanner planner = new Planner();
		
		long time1 = System.nanoTime();
		planner.graphBreadth(problem);
		long time2 = System.nanoTime();
		
		System.out.println("Tempo gasto => " + ((time2 - time1)/1000000000.0) + " segundos");
	}

}
