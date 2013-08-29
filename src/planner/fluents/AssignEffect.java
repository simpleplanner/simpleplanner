package planner.fluents;

import java.util.ArrayList;
import java.util.List;
import planner.functions.Assign;
import planner.functions.Decrease;
import planner.functions.Increase;
import planner.strips.Condition;
import planner.strips.Parameter;
import planner.strips.Problem;
import planner.strips.State;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por resolver operações de atribuição de valores:
 * - Increase: Incremento (+=);
 * - Decrease: Decremento (-=);
 * - Assign  : Atribuição (=);
 * 
 */
public class AssignEffect implements Condition {

    public List<Condition> conditions = new ArrayList<Condition>();

    public AssignEffect() {
        int i = 0;
    }

    public AssignEffect(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean verify(State s) {
        for (Condition c : conditions) {
            if (!c.verify(s)) {
                return false;
            }
        }
        return true;
    }

    public void replaceParams(List<Parameter> oldNames, List<Parameter> newNames) {
        for (Condition c : conditions) {
            c.replaceParams(oldNames, newNames);
        }
    }

    @Override
    public AssignEffect copy() {
        AssignEffect copy = new AssignEffect();
        for (Condition c : conditions) {
            copy.conditions.add(c.copy());
        }
        return copy;
    }

    @Override
    public String toString() {
        String retorno = "(assign_effects ";
        for (Condition p : conditions) {
            retorno += " " + p;
        }
        retorno += ")";
        return retorno;
    }

    @Override
    /**
     * Esse método busca as conditions do AssignEffects.
     * Elas podem ser: increase, decrease e assign.
     * Dependendo do tipo, o fluxo busca a classe que resolverá a atribuição
     */
    public State apply(State s) {
        Function left = null;
        Function right = null;

        State novo = s.copy();
        Increase increase = null;
        Decrease decrease = null;
        Assign assign = null;
        
        //a lista de conditions possui os operadores da operação de atribuição
        for (Condition c : conditions) {
            //a primeira condition determina o tipo de atribuição
            if (c instanceof planner.functions.Increase) {
                increase = (Increase) c;
            }

            if (c instanceof planner.functions.Decrease) {
                decrease = (Decrease) c;
            }

            if (c instanceof planner.functions.Assign) {
                assign = (Assign) c;
            }

            //as próximas serão os operadores da esquerda e direita.
            if (c instanceof planner.fluents.Function) {
                Function funcao = (Function) c;
                if (funcao.params.isEmpty() && left == null) {
                    left = funcao;
                } else {
                    right = funcao;
                }
            }else if (c instanceof planner.fluents.BinaryOp && assign != null) {
                right = ((BinaryOp) c).getFunction(s);
            }
            //novo = c.apply(novo);
        }
        //executar a atribuição
        if (increase != null) {
            increase.applyEffects(left, right);
        }
        if (decrease != null) {
            decrease.applyEffects(left, right);
        }
        if (assign != null) {
            assign.applyEffects(left, right);
        }

        //o operador da esquerda será alterado e seu valor deve ser atualizado
        //na lista de funções
        novo.functions.remove(left);
        novo.functions.add(left);

        //novo.functions.clear();
        //novo.functions.add(left);
        //novo.functions.add(right);
        return novo;
    }

    public void applyAssignEffects(Problem p) {
        //verificar se a função existe no problema, 
        //se existir iniciá-la com o valor do problema.
        for (Function functionProblem : p.functions) {
            int i = conditions.indexOf(functionProblem);
            if ((i != -1)) {
                Condition c = conditions.get(i);
                conditions.remove(i);
                c = functionProblem;
                conditions.add(i, c);
                c = c;
            }
        }

    }
	@Override
	public State unapply(State state) {
		State novo = state.copy();
		for (Condition c : conditions) {
			novo = c.unapply(novo);
		}
		return novo;
	}
}