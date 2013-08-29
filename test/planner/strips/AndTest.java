package planner.strips;

import junit.framework.Assert;

import org.junit.Test;

public class AndTest extends CopyTest {

	@Test
	public void testCopy_empty(){
		And a = new And();
		And copy = a.copy();

		Assert.assertNotNull(copy.conditions);
		AssertUtil.assertSameHasCode_DifferentInstance(a.conditions, copy.conditions);
	}

	@Test
	public void testCopy_notEmpty(){
		And a = new And(ConditionFactory.build(true));
		And copy = a.copy();
		AssertUtil.assertDifferentInstance(a.conditions,  copy.conditions);
		AssertUtil.assertEquals_DifferentInstance(a.conditions.iterator().next(), copy.conditions.iterator().next());
	}
	
	@Test
	public void testVerify_severalTrueConditions(){
		And a = new And(ConditionFactory.build(true, true, true, true));
		Assert.assertTrue(a.verify(null));
	}

	@Test
	public void testVerify_oneFalseConditionAmongSeveralTrueConditions(){
		And a = new And(ConditionFactory.build(true, true, false, true));
		Assert.assertFalse(a.verify(null));
	}

	@Test
	public void testVerify_oneFalseCondition(){
		And a = new And(ConditionFactory.build(false));
		Assert.assertFalse(a.verify(null));
	}
}
