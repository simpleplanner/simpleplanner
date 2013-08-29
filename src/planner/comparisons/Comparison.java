package planner.comparisons;

import java.util.List;

import planner.fluents.BinaryOp;
import planner.fluents.Function;
import planner.strips.Condition;
import planner.strips.Problem;
import planner.strips.State;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por resolver as comparações: >, <, >=, <=, =
 * (=): Equal;
 * (>): GreaterThan;
 * (>=): GreaterThanEq;
 * (<): LessThan;
 * (<=): LessThanEq;
 * 
 */
public class Comparison extends MultiCondition{

    public Comparison() {
    }

    public Comparison(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /** O verify desta classe é responsável por realizar as comparações.
     *  O retorno é true ou false.
     */
    @Override    
    public boolean verify(State s) { 

        Condition comp = conditions.get(0);

        Function operator1;
        Function operator2;

        //Caso os operadores sejam operações +, -, * ou /, 
        //retornar um função representando o resultado da operação
        if (conditions.get(1) instanceof BinaryOp) {
            operator1 = ((BinaryOp) conditions.get(1)).getFunction(s);
        } else {
            operator1 = (Function) conditions.get(1);
        }        
        
        if (conditions.get(2) instanceof BinaryOp) {
            operator2 = ((BinaryOp) conditions.get(2)).getFunction(s);
        } else {
            operator2 = (Function) conditions.get(2);
        }

        if (comp instanceof IComparison) {
            IComparison comparision = (IComparison) comp;
            return comparision.verifyComparision(operator1, operator2, s);
        }
        return false;
    }

    @Override
    public Comparison copy() {
        Comparison copy = new Comparison();
        for (Condition c : conditions) {
            copy.conditions.add(c.copy());
        }
        return copy;
    }

    @Override
    public String toString() {
        String retorno = "(and";
        for (Condition p : conditions) {
            retorno += " " + p;
        }
        retorno += ")";
        return retorno;
    }

    /**
     * Verificar se a função existe no problema, se existir iniciá-la com o valor do problema.
     */
    public void applyComparision(Problem p) {
           for(Function functionProblem :p.functions){
               int i = conditions.indexOf(functionProblem);
               if ((i != -1)){
                   Condition c = conditions.get(i);
                   conditions.remove(i);
                   c = functionProblem.copy();
                   conditions.add(i, c);
                   c = c;
               }
           }

    }

}
