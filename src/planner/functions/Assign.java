package planner.functions;

import java.util.ArrayList;
import java.util.List;

import planner.comparisons.MultiCondition;
import planner.fluents.Function;
import planner.strips.Condition;
import planner.strips.Parameter;
import planner.strips.State;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por resolver a operação de atribuição simples:
 * - Assign  : Atribuição (=);
 * 
 */
public class Assign extends MultiCondition {

    public Assign() {
    }

    public Assign(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Assign copy() {
        Assign copy = new Assign();
        for (Condition c : conditions) {
            copy.conditions.add(c.copy());
        }
        return copy;
    }

    /** 
     * Aplica o efeito da atribuição
     */
    public void applyEffects(Function left, Function right) {
        left.value = right.value;
    }
}