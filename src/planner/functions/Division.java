package planner.functions;

import planner.comparisons.MultiCondition;
import planner.fluents.Function;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por resolver a operação:
 * /: Division;
 * 
 */
public class Division extends MultiCondition {

    /** 
     * Aplica o efeito da operação:
     * Essa função não existe de fato na lista de funções do problema.
     * Ele é criada apenas para obter o resultado, que será utilizado para
     * compor um Comparação ou uma atribuição.
     */
    public Function applyOperation(Function operador1, Function operador2) {
        Function func = new Function("(/)(operador1)(operador2)", null);
        func.value = operador1.value / operador2.value;
        return func;
    }
}