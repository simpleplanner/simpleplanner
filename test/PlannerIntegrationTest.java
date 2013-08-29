import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import planner.planners.GraphBreadthPlanner;
import planner.planners.Planner;
import planner.planners.SolutionPrinter;
import planner.strips.Problem;
import planner.strips.State;
import planner.strips.pddl.PDDLLoader;
import planner.strips.pddl.antlr.PDDLParseException;
import planner.strips.pddl.antlr.PDDLSyntaxException;


public class PlannerIntegrationTest {

	@Test
	public void testStripProblem() throws Exception {
		Planner planner = new GraphBreadthPlanner();
		Problem problem = getGripperProblemFromPddl();
		State solution = planner.foward(problem);
		Assert.assertTrue(problem.goal.verify(solution));
	}

	@Test
	public void testFluentProblem() throws Exception {
		Planner planner = new GraphBreadthPlanner();
		Problem problem = getFluentProblemFromPddl();
		State solution = planner.foward(problem);

		Assert.assertTrue(problem.goal.verify(solution));
	}

	@Test
	public void testBackwardProblem() throws Exception {
		GraphBreadthPlanner planner = new GraphBreadthPlanner();
		Problem problem = getGripperProblemFromPddl();
		State solution = planner.backward(problem);
		Assert.assertNotNull("A solução não deveria ser nula", solution);
		SolutionPrinter.getInstance().printPlan(solution);
//		Assert.assertTrue(problem.goal.verify(solution));
	}

	private static Problem getGripperProblemFromPddl() throws PDDLSyntaxException, IOException, PDDLParseException{
		String domainFile = new String("testResource/domain-gripper.pddl");
		String problemFile = new String("testResource/problem-gripper2.pddl");
		PDDLLoader pddlLoader = new PDDLLoader(domainFile, problemFile);
		return pddlLoader.getProblem();
	}

	private static Problem getFluentProblemFromPddl() throws PDDLSyntaxException, IOException, PDDLParseException{
		String domainFile = new String("testResource/domain-simple-plan.pddl");
		String problemFile = new String("testResource/problem-simple-plan.pddl");

		PDDLLoader pddlLoader = new PDDLLoader(domainFile, problemFile);
		return pddlLoader.getProblem();
	}

}
