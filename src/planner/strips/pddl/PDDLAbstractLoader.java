package planner.strips.pddl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import planner.comparisons.Comparison;
import planner.comparisons.Equal;
import planner.comparisons.GreaterThan;
import planner.comparisons.GreaterThanEq;
import planner.comparisons.LessThan;
import planner.comparisons.LessThanEq;
import planner.fluents.AssignEffect;
import planner.fluents.BinaryOp;
import planner.fluents.Function;
import planner.functions.Assign;
import planner.functions.Decrease;
import planner.functions.Division;
import planner.functions.Increase;
import planner.functions.Minus;
import planner.functions.Multiply;
import planner.functions.Sum;
import planner.strips.And;
import planner.strips.Condition;
import planner.strips.Domain;
import planner.strips.Not;
import planner.strips.Parameter;
import planner.strips.Parametized;
import planner.strips.Predicate;
import planner.strips.Type;
import planner.strips.pddl.antlr.PDDLLexer;
import planner.strips.pddl.antlr.PDDLParseException;
import planner.strips.pddl.antlr.PDDLParser;
import planner.strips.pddl.antlr.PDDLSyntaxException;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 *
 * Classe alterada por: Ellen Gera, Helcio Soares e Rogerio Figueredo.
 * A alteração permitiu que a classe reconheça tokens do tipo:
 * -> ASSIGN_EFFECT
 * -> T__98 (increase)
 * -> T__95 (assign)
 * -> T__99 (decrease)
 * -> FUNC_HEAD
 * -> COMPARISON_GD
 * -> NUMBER
 * -> T__90 (>)
 * -> T__91 (<)
 * -> T__92 (=)
 * -> T__93 (>=)
 * -> T__94 (<=)
 * -> BINARY_OP
 * -> T__59 (-)
 * -> T__87 (*)
 * -> T__88 (+)
 * -> T__89 (/)
 * 
 */
public abstract class PDDLAbstractLoader {

    protected String file;
    protected CommonTree rootTree;
    protected Domain domain;

    public PDDLAbstractLoader(String file) throws PDDLSyntaxException, IOException {
        this.file = file;
        buildTree();
    }

    private void buildTree() throws PDDLSyntaxException, IOException {
        PDDLLexer lex = new PDDLLexer(new ANTLRFileStream(file));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        PDDLParser parser = new PDDLParser(tokens);

        try {
            PDDLParser.pddlDoc_return t = parser.pddlDoc();
            rootTree = (CommonTree) t.getTree();

            if (parser.invalidGrammar()) {
                throw new PDDLSyntaxException();
            }

        } catch (RecognitionException e) {
            throw new PDDLSyntaxException(e);
        }
    }

    protected Parameter addParameter(Parametized parametized, Tree tree) throws PDDLParseException {
        String parameterName = tree.getText();

        if (parametized.paramsMap.isEmpty()) {
            parametized.buildTypeMap();
        }

        if (parametized.paramsMap.containsKey(parameterName)) {
            return parametized.paramsMap.get(parameterName);
        } else {
            throw new PDDLParseException("Parameter " + parameterName + " not declared");
        }
    }

    protected List<Condition> loadChildCondition(Parametized parametized, Tree tree) throws PDDLParseException {
        List<Condition> conditions = new ArrayList<Condition>();

        for (int i = 0; i < tree.getChildCount(); i++) {
            Tree child = tree.getChild(i);
            final int type = child.getType();
            switch (type) {
                case PDDLLexer.PRED_HEAD:
                    Predicate p = addPredicate(parametized, child);
                    conditions.add(p);
                    break;
                case PDDLLexer.NOT_GD:
                case PDDLLexer.NOT_EFFECT:
                    Not not = new Not();
                    not.predicate = (Predicate) loadChildCondition(parametized, child).get(0);
                    conditions.add(not);
                    break;
                case PDDLLexer.AND_GD:
                case PDDLLexer.AND_EFFECT:
                    And and = new And();
                    and.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(and);
                    break;
                case PDDLLexer.ASSIGN_EFFECT:
                    AssignEffect assignEffect = new AssignEffect();
                    assignEffect.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(assignEffect);
                    break;
                case PDDLLexer.T__98:
                    Increase increase = new Increase();
                    increase.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(increase);
                    break;
                case PDDLLexer.T__95:
                    Assign assign = new Assign();
                    assign.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(assign);
                    break;
                case PDDLLexer.T__99:
                    Decrease decrease = new Decrease();
                    decrease.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(decrease);
                    break;
                case PDDLLexer.FUNC_HEAD:
                    Function f = addFunction(parametized, child);
                    conditions.add(f);
                    break;
                case PDDLLexer.OR_GD:
                    throw new UnsupportedOperationException("OR goalDescs not supported yet");
                case PDDLLexer.COMPARISON_GD:
                    Comparison comparison = new Comparison();
                    comparison.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(comparison);
                    break;
                case PDDLLexer.T__94:
                    LessThanEq lessThanEq = new LessThanEq();
                    conditions.add(lessThanEq);
                    break;
                case PDDLLexer.T__93:
                    GreaterThanEq greaterThanEq = new GreaterThanEq();
                    conditions.add(greaterThanEq);
                    break;
                case PDDLLexer.T__92:
                    Equal equal = new Equal();
                    conditions.add(equal);
                    break;
                case PDDLLexer.T__91:
                    LessThan lessThan = new LessThan();
                    conditions.add(lessThan);
                    break;
                case PDDLLexer.T__90:
                    GreaterThan greaterThan = new GreaterThan();
                    conditions.add(greaterThan);
                    break;
                case PDDLLexer.NUMBER:
                    Function number = addFunction(parametized, child);
                    conditions.add(number);
                    break;
                case PDDLLexer.BINARY_OP:
                    BinaryOp binaryOp = new BinaryOp();
                    binaryOp.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(binaryOp);
                    break;
                case PDDLLexer.T__59:
                    Minus minus = new Minus();
                    minus.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(minus);
                    break;
                case PDDLLexer.T__87:
                    Multiply mult = new Multiply();
                    mult.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(mult);
                    break;
                case PDDLLexer.T__88:
                    Sum sum = new Sum();
                    sum.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(sum);
                    break;
                case PDDLLexer.T__89:
                    Division division = new Division();
                    division.conditions.addAll(loadChildCondition(parametized, child));
                    conditions.add(division);
                    break;
                case PDDLLexer.IMPLY_GD:
                    throw new UnsupportedOperationException("IMPLY not supported yet");
                case PDDLLexer.EXISTS_GD:
                    throw new UnsupportedOperationException("EXISTS not supported yet");
                case PDDLLexer.FORALL_GD:
                    throw new UnsupportedOperationException("FORALL not supported yet");
                default:
                    throw new PDDLParseException("Unknown node: " + child.getText());
            }
        }

        return conditions;
    }

    protected Predicate addPredicate(Parametized parametized, Tree tree) throws PDDLParseException {
        Predicate p = new Predicate();
        String predicateName = tree.getChild(0).getText();

        if (domain.predicates.containsKey(predicateName)) {
            p.name = predicateName;
            if (tree.getChildCount() > 1) {
                for (int j = 1; j < tree.getChildCount(); j++) {
                    p.params.add(addParameter(parametized, tree.getChild(j)));
                }
            }
            return p;
        } else {
            throw new PDDLParseException("Predicate " + predicateName + " not declared");
        }
    }

    /**
     * Método criado para adicionar funções, similar ao que adiciona predicados
     */
    protected Function addFunction(Parametized parametized, Tree tree) throws PDDLParseException {
        Function f = new Function();
        String funtionName;

        try {
            funtionName = tree.getChild(0).getText();

            if (domain.functions.containsKey(funtionName)) {
                f.name = funtionName;
                if (tree.getChildCount() > 1) {
                    for (int j = 1; j < tree.getChildCount(); j++) {
                        f.params.add(addParameter(parametized, tree.getChild(j)));
                    }
                }
                return f;
            } else {
                throw new PDDLParseException("Funcao " + funtionName + " not declared");
            }
        }//Se a função for um literal 
        catch (NullPointerException e) {
            funtionName = tree.getText();
            f.name = funtionName;
            f.value = Integer.parseInt(funtionName);
            return f;
        }
    }

    protected Parameter addParameter(Tree tree) throws PDDLParseException {
        Parameter p = new Parameter();
        p.name = tree.getText();

        if (tree.getChildCount() == 0) {
            p.type = domain.types.get("object");
        } else {
            String typeName = tree.getChild(0).getText();
            Type type = domain.types.get(typeName);
            if (type == null) {
                throw new PDDLParseException("Type " + typeName + " not declared");
            }
            p.type = type;
        }

        return p;
    }
}