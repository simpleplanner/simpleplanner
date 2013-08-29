package planner.functions;

import junit.framework.Assert;

import org.junit.Test;

import planner.fluents.Function;

public class DivisionTest {

	Division op= new Division();
	Function left = new Function();
	Function rigth = new Function();
	
	@Test(expected = ArithmeticException.class)
	public void testeApplyEffects_divZERO(){
		left.value = 1;
		rigth.value = 0;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(0, result.value.intValue());
	}
	
	@Test
	public void testeApplyEffects_divONE(){
		left.value = 1;
		rigth.value = 1;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(1, result.value.intValue());
	}

	@Test
	public void testeApplyEffects_divPositiveValue(){
		left.value =6;
		rigth.value = 3;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(2, result.value.intValue());
	}
	
	@Test
	public void testeApplyEffects_divNegativeValue(){
		left.value = 3;
		rigth.value = -1;
		Function result = op.applyOperation(left, rigth);
		Assert.assertEquals(-3, result.value.intValue());
	}
	
}