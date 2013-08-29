package planner.functions;

import java.util.ArrayList;
import java.util.List;

import planner.comparisons.MultiCondition;
import planner.fluents.Function;
import planner.strips.Condition;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por resolver a operação de atribuição e incremento:
 * - Increase  : incremento (+=);
 * 
 */
public class Increase extends MultiCondition  {

    public List<Condition> conditions = new ArrayList<Condition>();

    public Increase() {
    }

    public Increase(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /** 
     * Aplica o efeito da atribuição
     */
    public void applyEffects(Function left, Function right) {
        left.value += right.value;
    }
}