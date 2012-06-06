package planner.strips;

import java.util.List;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class Action extends Parametized implements Condition{

	public Condition precondition;
	public Condition effects;
	
	public Action() {
	}
	
	public Action(String name, List<Parameter> params, Condition precondition, Condition effects) {
		this.name = name;
		this.params = params;
		this.precondition = precondition;
		this.effects = effects;
	}
	
	public void replaceParams(List<Parameter> oldNames, List<Parameter> newNames){
		precondition.replaceParams(params,newNames);
		effects.replaceParams(params,newNames);
		super.replaceParams(oldNames, newNames);
	}

	@Override
	public State apply(State s) {
		return effects.apply(s);
	}

	@Override
	public boolean verify(State s) {
		return precondition.verify(s);
	}
	
	public Action copy(){
		Action copy = new Action();
		copy.name = name;
		copy.params = params;
		copy.precondition = precondition.copy();
		copy.effects = effects.copy();
		return copy;
	}
	
	@Override
	public String toString() {
		String retorno = "("+name;
		for (Parameter parameter : params) {
			retorno += " "+ parameter;
		}
		retorno +=")";
		return retorno; 
	}
}
