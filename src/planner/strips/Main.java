package planner.strips;

import planner.strips.xml.Loader;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * 
 */
public class Main {
	
	public static void main(String[] args) {
		AbstractPlanner planner = new Planner();
		
		Loader l = new Loader();
		l.load("src/planner/strips/gripper.xml");
		Problem p = l.problem("gripper8");
		
		long time1 = System.nanoTime();
		
		planner.graphBreadth(p);
		//planner.graphDepth(p);
		
		long time2 = System.nanoTime();
		
		System.out.println("Tempo gasto => " + ((time2 - time1)/1000000000.0) + " segundos");
	}

}
