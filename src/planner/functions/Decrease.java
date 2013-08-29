package planner.functions;

import planner.comparisons.MultiCondition;
import planner.fluents.Function;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por resolver a operação de atribuição e incremento:
 * - Decrease  : incremento (-=);
 * 
 */
public class Decrease extends MultiCondition{

    public Decrease() { }

    /** 
     * Aplica o efeito da atribuição
     */
    public void applyEffects(Function left, Function right) {
        left.value -= right.value;
    }
}