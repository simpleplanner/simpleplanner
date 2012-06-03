package planner.strips.pddl;

import planner.strips.Domain;
import planner.strips.pddl.parser.PDDLDomainLoader;
import planner.strips.pddl.parser.PDDLProblemLoader;

public class Main {
	static String[] tokenNames;

	public static void main(String[] args) throws Exception {
		String domainFile = new String("lib/blocks.pddl");
		String problemFile = new String("lib/blocksprob1.pddl");

		PDDLDomainLoader builder = new PDDLDomainLoader(domainFile);
		Domain domain = builder.loadDomain();
		
		PDDLProblemLoader problemBuilder = new PDDLProblemLoader(domain, problemFile);
		problemBuilder.loadProblem();
		System.out.println(domain);
	}

}
