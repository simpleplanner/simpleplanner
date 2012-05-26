package planner.strips.pddl;

import planner.strips.Domain;
import planner.strips.pddl.parser.PDDLLoader;

public class Main {
	static String[] tokenNames;

	public static void main(String[] args) throws Exception {
		String file = new String("lib/blocks.pddl");
		args = new String[1];
		args[0] = file;
		
		PDDLLoader builder = new PDDLLoader(file);
		builder.buildTree();
		Domain domain = builder.loadDomain();

		System.out.println(domain);
	}

}
