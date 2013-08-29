package planner.comparisons;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import planner.fluents.Function;
import planner.strips.State;

public class EqualTest {

	Equal op= new Equal();
	Function left;
	Function rigth;
	private State state;
	
	@Before
	public void setUp(){
		left = new Function();
		rigth = new Function();
		this.state = new State();

		left.name = "left";
		rigth.name = "right";
		
		this.state.functions.add(left);
		this.state.functions.add(rigth);
	}
	
	@Test
	public void testeVerifyComparision_differentValues(){
		left.value = 1;
		rigth.value = 0;
		boolean result = op.verifyComparision(left, rigth, state);
		Assert.assertFalse(result);
	}
	
	@Test
	public void testeVerifyComparision_equalValues(){
		left.value = 1;
		rigth.value = 1;
		boolean result = op.verifyComparision(left, rigth, state);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testeVerifyComparision_equalValuesDifferenceInstances(){
		left.value = new Integer(34);
		rigth.value =  new Integer(34);
		boolean result = op.verifyComparision(left, rigth, state);
		Assert.assertTrue(result);
	}

	
}