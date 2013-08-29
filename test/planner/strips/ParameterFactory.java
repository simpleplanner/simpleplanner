package planner.strips;

import java.util.LinkedList;
import java.util.List;

public class ParameterFactory {
	
	public static List<Parameter> buildParameteres(String typeName, String... paramNames) {
		Type t = new Type(typeName);
		List<Parameter> params = new LinkedList<Parameter>();
		for (String name : paramNames) {
			params.add(new Parameter(name, t));
		}
		return params;
	}
	
}