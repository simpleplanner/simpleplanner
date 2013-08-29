package planner.functions;

import junit.framework.Assert;

import org.junit.Test;

import planner.fluents.Function;

public class DecreaseTest {

	Decrease d = new Decrease();
	Function left = new Function();
	Function rigth = new Function();
	
	@Test
	public void testeApplyEffects_minusZERO(){
		left.value = 1;
		rigth.value = 0;
		d.applyEffects(left, rigth);
		Assert.assertEquals(1, left.value.intValue());
	}

	@Test
	public void testeApplyEffects_minusPositiveValue(){
		left.value = 1;
		rigth.value = 1;
		d.applyEffects(left, rigth);
		Assert.assertEquals(0, left.value.intValue());
	}
	
	
	@Test
	public void testeApplyEffects_minusNegativeValue(){
		left.value = 1;
		rigth.value = -1;
		d.applyEffects(left, rigth);
		Assert.assertEquals(2, left.value.intValue());
		
	}
	
}