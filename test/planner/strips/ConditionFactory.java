package planner.strips;

import java.util.LinkedList;
import java.util.List;

public class ConditionFactory {
	
	public static List<Condition> build(boolean... verifyResults) {
		List<Condition> conditions = new LinkedList<Condition>();
		for (boolean vResult : verifyResults) {
			conditions.add(new ConditionImpl(vResult));
		}
		return conditions;
	}
	
}