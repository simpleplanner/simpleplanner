package planner.strips;

import java.util.List;

public class Action extends Parametized implements Condition{

	public Condition precondition;
	public Condition effects;
	
	public void replaceParams(List<String> oldNames, List<String> newNames){
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
		copy.params.addAll(params);
		copy.precondition = precondition.copy();
		copy.effects = effects.copy();
		return copy;
	}
	
	@Override
	public String toString() {
		String retorno = "("+name;
		for (String p : params) {
			retorno += " "+p;
		}
		retorno +=")\n";
		retorno += "[pre:" + precondition + " eff: " + effects+"]";
		return retorno; 
	}
}
