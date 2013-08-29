package planner.functions;

import junit.framework.Assert;

import org.junit.Test;

import planner.fluents.Function;

public class SumTest {

	Sum op= new Sum();
	Function left = new Function();
	Function rigth = new Function();
	
	@Test
	public void testeApplyEffects_sumZERO(){
		left.value = 1;
		rigth.value = 0;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(1, result.value.intValue());
	}

	@Test
	public void testeApplyEffects_sumPositiveValue(){
		left.value = 2;
		rigth.value = 3;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(5, result.value.intValue());
	}
	
	@Test
	public void testeApplyEffects_sumNegativeValue(){
		left.value = 3;
		rigth.value = -1;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(2, result.value.intValue());
	}
	
}