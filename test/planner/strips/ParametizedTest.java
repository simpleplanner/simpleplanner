package planner.strips;

import static planner.strips.ParameterFactory.buildParameteres;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author <a href="mailto:danilobmedeiros@gmail.com">Danilo Medeiros</a>
 */
public class ParametizedTest {

	class ParametizedImpl extends Parametized{}

	private Parametized instance;

	@Before
	public void setUp(){
		this.instance = new ParametizedImpl();
	}


	@Test
	public void testeReplaceParams_simpleCase() {
		List<Parameter> velhos= buildParameteres("TipoA", "p1", "p2");
		List<Parameter> novos = buildParameteres("TipoB", "p1", "p2");
		instance.params.addAll(velhos);
		instance.replaceParams(velhos, novos);
		Assert.assertArrayEquals(novos.toArray(), instance.params.toArray());
	}
	
	@Test
	public void teste_paramsEmpty(){
		instance.buildTypeMap();
		Assert.assertTrue("TypeMap must be empty when params is empty. ", instance.typeMap.isEmpty());
	}

	@Test
	public void teste_manyParametersOneType(){
		List<Parameter> as = buildParameteres("A", "a1", "a2","a3");
		instance.params.addAll(as);
		
		instance.buildTypeMap();
		Assert.assertEquals("TypeMap must have k differnst keys if there are params of k differnt types. ", 1, instance.typeMap.size());
		Assert.assertEquals("there should be 3 parameters for the type A ",3, instance.typeMap.get("A").size());
	}
	
	@Test
	public void teste_manyParametersManyTypes(){
		List<Parameter> as = buildParameteres("A", "a1", "a2","a3");
		List<Parameter> bs = buildParameteres("B", "b1", "b2");
		instance.params.addAll(as);
		instance.params.addAll(bs);
		
		instance.buildTypeMap();
		Assert.assertEquals("TypeMap must have k differnst keys if there are params of k differnt types. ", 2, instance.typeMap.size());
		Assert.assertEquals("there should be 3 parameters for the type A ",3, instance.typeMap.get("A").size());
		Assert.assertEquals("there should be 2 parameters for the type B ",2, instance.typeMap.get("B").size());
		
	}

}