package planner.functions;

import junit.framework.Assert;

import org.junit.Test;

import planner.fluents.Function;

public class MultiplyTest {

	Multiply op= new Multiply();
	Function left = new Function();
	Function rigth = new Function();
	
	@Test
	public void testeApplyEffects_timesZERO(){
		left.value = 1;
		rigth.value = 0;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(0, result.value.intValue());
	}

	@Test
	public void testeApplyEffects_timesPositiveValue(){
		left.value = 2;
		rigth.value = 3;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(6, result.value.intValue());
	}
	
	@Test
	public void testeApplyEffects_timesNegativeValue(){
		left.value = 3;
		rigth.value = -1;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(-3, result.value.intValue());
	}
	
}