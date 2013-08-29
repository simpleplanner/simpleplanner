package planner.strips;

import java.util.ArrayList;
import java.util.List;

import planner.comparisons.MultiCondition;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class OR extends MultiCondition{
	
	public OR() {
	}
	
	public OR(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
	public OR(Condition conditions) {
		this.conditions.add(conditions);
	}
	
	@Override
	public boolean verify(State s) {
		for (Condition c : conditions) {
			if (c.verify(s))
				return true;
		}
		return false;
	}
	
	@Override
	public OR copy() {
		OR copy = new OR();
		for (Condition c : conditions) {
			copy.conditions.add(c.copy());
		}
		return copy;
	}

	@Override
	public String toString() {
		String retorno = "(or";
		for (Condition p : conditions) {
			retorno += " "+p;
		}
		retorno += ")";
		return retorno;
	}

}
