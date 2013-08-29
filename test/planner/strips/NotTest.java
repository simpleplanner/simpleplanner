package planner.strips;

import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Test;

public class NotTest extends CopyTest {

	@Test
	public void testCopy(){
		Not a = new Not();
		a.predicate = new Predicate("P1", new LinkedList<Parameter>());
		
		Not copy = a.copy();

		Assert.assertNotNull(copy.predicate);
		AssertUtil.assertSameHasCode_DifferentInstance(a.predicate, copy.predicate);
	}

	@Test
	public void testVerify_mustBeTrueForFalsePredicate(){
		Not a = new Not();
		a.predicate = new PredicateMock(false);
		Assert.assertTrue(a.verify(null));
	}

	@Test
	public void testVerify_mustBeFalseForTruePredicate(){
		Not a = new Not();
		a.predicate = new PredicateMock(true);
		Assert.assertFalse(a.verify(null));
	}
}
