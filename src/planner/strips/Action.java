package planner.strips;

import java.util.List;

import planner.comparisons.Comparison;
import planner.fluents.AssignEffect;

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
        
        public void applyAssignEffects(Problem p){
            //fazer um cast para AND, depois procurar o assignEffect e mudar os parametros na funcao.
           AssignEffect  assignEffect = null; 
           And and = (And) effects;
           
           for (Condition effect : and.conditions){
               if (effect instanceof planner.fluents.AssignEffect){
                   assignEffect = (AssignEffect) effect;
                   assignEffect.applyAssignEffects(p);
               }
           }
        }

        void applyPreConditions(Problem p) {
            //fazer um cast para AND, depois procurar o assignEffect e mudar os parametros na funcao.
           Comparison  condition = null; 
           And and = (And) precondition;
           
           for (Condition comparision : and.conditions){
               if (comparision instanceof planner.comparisons.Comparison){
                   condition = (Comparison) comparision;
                   condition.applyComparision(p);
               }
           }
    }
        
	public State unapply(State state) {
		return effects.unapply(state);
	}
}
