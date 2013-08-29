package planner.strips;

import junit.framework.Assert;

import org.junit.Test;

public class ORTest extends CopyTest {

	@Test
	public void testCopy_empty(){
		OR a = new OR();
		OR copy = a.copy();

		Assert.assertNotNull(copy.conditions);
		AssertUtil.assertSameHasCode_DifferentInstance(a.conditions, copy.conditions);
	}

	@Test
	public void testCopy_notEmpty(){
		OR a = new OR(ConditionFactory.build(true));
		OR copy = a.copy();
		AssertUtil.assertDifferentInstance(a.conditions,  copy.conditions);
		AssertUtil.assertEquals_DifferentInstance(a.conditions.iterator().next(), copy.conditions.iterator().next());
	}
	
	@Test
	public void testVerify_severalTrueConditions(){
		OR a = new OR(ConditionFactory.build(true, true, true, true));
		Assert.assertTrue(a.verify(null));
	}

	@Test
	public void testVerify_oneFalseConditionAmongSeveralTrueConditions(){
		OR a = new OR(ConditionFactory.build(true, true, false, true));
		Assert.assertTrue(a.verify(null));
	}

	@Test
	public void testVerify_oneFalseCondition(){
		OR a = new OR(ConditionFactory.build(false));
		Assert.assertFalse(a.verify(null));
	}
}
