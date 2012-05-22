package planner.strips;

import planner.strips.xml.Loader;



public class Main {

	public static void main(String[] args) {
		Loader l = new Loader();
		l.load("src/planner/strips/gripper.xml");
		l.plan("gripper2");
	}

}
