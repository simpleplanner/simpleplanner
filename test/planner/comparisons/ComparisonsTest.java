package planner.comparisons;

import java.util.Collection;
import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import planner.fluents.Function;
import planner.strips.State;

@RunWith(value = Parameterized.class)
public class ComparisonsTest {
	Function left = new Function();
	Function rigth = new Function();
	State state = new State();
	boolean expected;
	private Class klass;

	public ComparisonsTest(Class klass, int  vF1, int vF2, boolean expected) throws InstantiationException, IllegalAccessException {
		
		this.klass = klass;
		left.name = "left";
		rigth.name = "right";

		left.value = vF1;
		rigth.value = vF2;
		
		state.functions.add(left);
		state.functions.add(rigth);
		this.expected  = expected;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Collection<Object[]> data = new LinkedList<Object[]>();
		data.add(new Object[]{ Equal.class, 1,0, false}); 
		data.add(new Object[]{ Equal.class, 1,1, true});
		
		data.add(new Object[]{ GreaterThanEq.class, 1,1, true});
		data.add(new Object[]{ GreaterThanEq.class, 2,1, true});
		data.add(new Object[]{ GreaterThanEq.class, 1,2, false});

		data.add(new Object[]{ GreaterThan.class, 1,1, false});
		data.add(new Object[]{ GreaterThan.class, 2,1, true});
		data.add(new Object[]{ GreaterThan.class, 1,2, false});

		data.add(new Object[]{ LessThan.class, 1,1, false});
		data.add(new Object[]{ LessThan.class, 2,1, false});
		data.add(new Object[]{ LessThan.class, 1,2, true});
		
		data.add(new Object[]{ LessThanEq.class, 1,1, true});
		data.add(new Object[]{ LessThanEq.class, 2,1, false});
		data.add(new Object[]{ LessThanEq.class, 1,2, true});
		return data;
	}

	@Test
	public void verifyComparisonTest() throws InstantiationException, IllegalAccessException {
		IComparison	op = (IComparison) klass.newInstance();
		boolean result = op.verifyComparision(left, rigth, state);
		Assert.assertEquals(this.klass.getName(), expected, result);
	}


}