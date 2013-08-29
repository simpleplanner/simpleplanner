package planner.strips;

import junit.framework.Assert;

public class AssertUtil {
	
	public static void assertDifferentInstance(Object obj1, Object obj2){
		Assert.assertTrue(obj1 != obj2);
	}
	
	public static void assertSameHasCode_DifferentInstance(Object obj1, Object obj2){
		assertDifferentInstance(obj1, obj2);
		Assert.assertEquals( obj1.hashCode() ,  obj2.hashCode());
	}
	
	public static void assertEquals_DifferentInstance(Object obj1, Object obj2){
		assertDifferentInstance(obj1, obj2);
		Assert.assertEquals( obj1 ,  obj2);
	}
}
