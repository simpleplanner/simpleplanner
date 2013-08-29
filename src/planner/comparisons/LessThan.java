package planner.comparisons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import planner.fluents.Function;
import planner.strips.Condition;
import planner.strips.Parameter;
import planner.strips.State;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por resolver a comparação:
 * (<): LessThan;
 * 
 */
public class LessThan extends MultiCondition implements IComparison{

    public LessThan() {
    }

    public LessThan(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * o verifyComparasion resolve de fato a comparação         
     */
    public boolean verifyComparision(Function operator1, Function operator2, State s) {

        HashSet<Function> functionsStates = (HashSet<Function>) s.functions;

        for (Iterator<Function> it = functionsStates.iterator(); it.hasNext();) {
            Function function = it.next();
            if (function.name.equals(operator1.name)) {
                operator1 = function;
            }
            if (function.name.equals(operator2.name)) {
                operator2 = function;
            }
        }
        return operator1.value < operator2.value;

    }
}
