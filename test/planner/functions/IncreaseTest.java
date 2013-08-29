package planner.functions;

import junit.framework.Assert;

import org.junit.Test;

import planner.fluents.Function;

public class IncreaseTest {

	Increase op = new Increase();
	Function left = new Function();
	Function rigth = new Function();
	
	@Test
	public void testeApplyEffects_plusZERO(){
		left.value = 1;
		rigth.value = 0;
		op.applyEffects(left, rigth);
		Assert.assertEquals(1, left.value.intValue());
	}

	@Test
	public void testeApplyEffects_plusPositiveValue(){
		left.value = 1;
		rigth.value = 1;
		op.applyEffects(left, rigth);
		Assert.assertEquals(2, left.value.intValue());
	}
	
	
	@Test
	public void testeApplyEffects_plusNegativeValue(){
		left.value = 1;
		rigth.value = -1;
		op.applyEffects(left, rigth);
		Assert.assertEquals(0, left.value.intValue());
		
	}
	
}