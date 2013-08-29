package planner.fluents;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import planner.comparisons.MultiCondition;
import planner.functions.Division;
import planner.functions.Minus;
import planner.functions.Multiply;
import planner.functions.Sum;
import planner.strips.Condition;
import planner.strips.Problem;
import planner.strips.State;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por resolver operações aritméticas de +, -, * e /
 * +: Sum;
 * -: Minus;
 * *: Multiply;
 * /: Division;
 * 
 */
public class BinaryOp extends MultiCondition{

    public BinaryOp() {
        int i = 0;
    }

    public BinaryOp(List<Condition> conditions) {
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


    @Override
    public BinaryOp copy() {
        BinaryOp copy = new BinaryOp();
        for (Condition c : conditions) {
            copy.conditions.add(c.copy());
        }
        return copy;
    }

    @Override
    public String toString() {
        String retorno = "(binaryOp ";
        for (Condition p : conditions) {
            retorno += " " + p;
        }
        retorno += ")";
        return retorno;
    }

    @Override
    public State apply(State s) {
        Function result = null;
        Function left = null;
        Function right = null;

        State novo = s.copy();
        Minus minus = null;
        //mudar aqui, chegando em casa vejo como é
        for (Condition c : conditions) {
            if (c instanceof planner.functions.Minus) {
                minus = (Minus) c;
            }

            if (c instanceof planner.fluents.Function) {
                Function funcao = (Function) c;
                if (funcao.params.isEmpty()) {
                    left = funcao;
                } else {
                    right = funcao;
                }
            }
            novo = c.apply(novo);
        }
        if (minus != null) {
            result = minus.applyOperation(left, right);
        }

        novo.functions.clear();
        novo.functions.add(result);
        novo.functions.add(left);
        novo.functions.add(right);
        return novo;
    }

    public void applyAssignEffects(Problem p) {
        //verificar se a função existe no problema, se existir iniciá-la com o valor do problema.
        for (Function functionProblem : p.functions) {
            int i = conditions.indexOf(functionProblem);
            if ((i != -1)) {
                Condition c = conditions.get(i);
                conditions.remove(i);
                c = functionProblem.copy();
                conditions.add(i, c);
                c = c;
            }
        }

    }

    /**
     * O getFunction() é utilizado para pegar o resultado de uma operação do 
     * tipo BinaryOp criar uma função com o resultao.
     * Essa função será utilizada por operações de comparação ou atribuição
     */
    public Function getFunction(State s) {
        Condition operando = conditions.get(0);

        Function operator1 = (Function) conditions.get(1);
        Function operator2 = (Function) conditions.get(2);

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

        Function funcResult;

        if (operando instanceof Minus) {
            Minus minus = (Minus) operando;
            funcResult = minus.applyOperation(operator1, operator2);
            return funcResult;
        }
        if (operando instanceof Sum) {
            Sum sum = (Sum) operando;
            funcResult = sum.applyOperation(operator1, operator2);
            return funcResult;
        }
        if (operando instanceof Multiply) {
            Multiply mult = (Multiply) operando;
            funcResult = mult.applyOperation(operator1, operator2);
            return funcResult;
        }
        if (operando instanceof Division) {
            Division division = (Division) operando;
            funcResult = division.applyOperation(operator1, operator2);
            return funcResult;
        }

        return null;

    }
    
	//TOOD implement me
	@Override
	public State unapply(State state) {
		return null;
	}

}