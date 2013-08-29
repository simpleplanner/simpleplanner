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
 * Classe responsável por resolver a operação:
 * -: Minus;
 */
public class Minus extends MultiCondition  {

    /** 
     * Aplica o efeito da operação:
     * Essa função não existe de fato na lista de funções do problema.
     * Ele é criada apenas para obter o resultado, que será utilizado para
     * compor um Comparação ou uma atribuição.
     */
    public Function applyOperation(Function operador1, Function operador2) {
        Function func = new Function("(-)(operador1)(operador2)", null);
        func.value = operador1.value - operador2.value;
        return func;
    }
}