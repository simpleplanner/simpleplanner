package planner.strips;

import planner.strips.xml.Loader;

public class Main {
	
	public static void main(String[] args) {
		Planner planner = new PlannerBFS();
		
		Loader l = new Loader();
		l.load("src/planner/strips/gripper.xml");
		Problem p = l.problem("gripper8");
		
		long t1 = System.nanoTime();
		planner.plan(p);
		long t2 = System.nanoTime();
		System.out.println("Tempo gasto => " + ((t2 - t1)/1000000000.0) + " segundos");
	}

}
