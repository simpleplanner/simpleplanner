package planner.strips;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class And implements Condition {
	
	public List<Condition> conditions = new ArrayList<Condition>();

	public And() {
	}
	
	public And(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
	@Override
	public State apply(State s) {
		State novo = s.copy();
		for (Condition c : conditions) {
			novo = c.apply(novo);
		}
		return novo;
	}

	@Override
	public boolean verify(State s) {
		for (Condition c : conditions) {
			if (!c.verify(s))
				return false;
		}
		return true;
	}

	public void replaceParams(List<Parameter> oldNames, List<Parameter> newNames) {
		for (Condition c : conditions) {
			c.replaceParams(oldNames,newNames);
		}
	}

	@Override
	public And copy() {
		And copy = new And();
		for (Condition c : conditions) {
			copy.conditions.add(c.copy());
		}
		return copy;
	}
	
	@Override
	public String toString() {
		String retorno = "(and";
		for (Condition p : conditions) {
			retorno += " "+p;
		}
		retorno += ")";
		return retorno;
	}

}
