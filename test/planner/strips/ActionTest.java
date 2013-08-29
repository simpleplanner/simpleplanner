package planner.strips;

import java.util.ArrayList;
import java.util.List;

import static planner.strips.ParameterFactory.buildParameteres;
import junit.framework.Assert;

import org.junit.Test;

public class ActionTest extends CopyTest {

	@Test
	public void testCopy_empty(){
		Action a = new Action();
		a.name = "QWERTYU";
		a.effects = new Predicate("Effectzz", new ArrayList<Parameter>());
		a.precondition = new Predicate("Preconditionzz",  new ArrayList<Parameter>());
		Action copy = a.copy();
		
		Assert.assertEquals("QWERTYU", copy.name);

		Assert.assertNotNull(copy.effects);
		Assert.assertNotNull(copy.precondition);
		
		AssertUtil.assertDifferentInstance( a.effects,  copy.effects);
		AssertUtil.assertDifferentInstance( a.precondition, copy.precondition);
	}

	@Test
	public void testCopy_notEmpty(){
		Action a = new Action();
		a.name = "QWERTYU";
		
		List<Parameter> peff = buildParameteres("T1", "peff1", "peff2");
		List<Parameter> pcond = buildParameteres("T2", "pcond1", "pcond2");
		
		a.effects = new Predicate("Effectzz", peff);
		a.precondition = new Predicate("Preconditionzz",  pcond);
		
		Action copy = a.copy();
		
		Assert.assertEquals("QWERTYU", copy.name);

		Assert.assertNotNull(copy.effects);
		Assert.assertNotNull(copy.precondition);
		
		
		AssertUtil.assertSameHasCode_DifferentInstance(a.effects,  copy.effects);
		AssertUtil.assertSameHasCode_DifferentInstance(a.precondition,  copy.precondition);
	
	}
	
	
	/**
	 * verify must consider Precondition and does not matter its effects
	 */
	@Test
	public void testVerify_mustBeTrueForPreConditionTrue(){
		Action a = new Action();
		a.precondition = new ConditionImpl(true);
		a.effects = new ConditionImpl(false);
		Assert.assertTrue(a.verify(null));
	}
	
	/**
	 * verify must consider Precondition and does not matter its effects
	 */
	@Test
	public void testVerify_mustBeFalseForPreConditionFalse(){
		Action a = new Action();
		a.precondition = new ConditionImpl(false);
		a.effects = new ConditionImpl(true);
		Assert.assertFalse(a.verify(null));
	}
}
