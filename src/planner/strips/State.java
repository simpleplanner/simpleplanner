package planner.strips;

import planner.fluents.Function;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class State {
	public Collection<Predicate> predicates = new HashSet<Predicate>();
	public State last;
	public Action cause;
	private Integer hashCode;

	public Collection<Function> functions = new HashSet<Function>();
	
	public State copy() {
		State novo = new State();
		novo.predicates.addAll(predicates);
        novo.functions.addAll(functions);
		return novo;
	}

	public Parametized findSame(Predicate predicate) {
		if (predicates.contains(predicate)){
			return predicate;
		}
		return null;
	}
	
	public Parametized findSame(Condition predicate) {
		if (predicates.contains(predicate)){
			return (Predicate) predicate;
		}
		return null;
	}

	public Parametized findSame(Function function) {
		if (functions.contains(function)){
			return function;
		}
		return null;
	}
	
	
	public boolean solves(Problem p) {
		return p.goal.verify(this);
	}
	
	/**
	 * For backward support
	 */
	public boolean solvesBack(Problem p) {
		return p.initAsCondition.verify(this);
	}
	
	//***
	
	public Collection<State> expand(Problem p) {
		Collection<State> states = new HashSet<State>();
		for (Action a : p.actions) {
			if (a.verify(this)){
				State novo = a.apply(this);
				novo.last = this;
				novo.cause = a;
				states.add(novo);
			}
		}
		return states;
	}
	
	/**
	 * For backward support
	 */
	public Collection<State> regression(Problem p){
		Collection<State> states = new HashSet<State>();
		
		for (Action a : p.actions) {
			if(a.effects.verify(this)){
				State novo = a.unapply(this);
				if(a.precondition.verify(novo)){
					novo.last = this;
					novo.cause = a;
					states.add(novo);				
				}
			}
		}
		return states;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj instanceof State){
			State other = (State) obj;
			return (predicates.size() == other.predicates.size() && predicates.containsAll(other.predicates));
		}
		return false;
	}

	/**
	 * Implementação baseada no Item 9 do livro Effective java...
	 * 
	 * @author Sávio Mota
	 * 
	 */
	@Override
	public int hashCode() {
		if (hashCode == null){
			int result = 17;
			result = 31 * result + predicates.hashCode();
			hashCode = result;
		}
		return hashCode;
	}
	
	@Override
	public String toString() {
		return predicates.toString();
	}
        
        public String printFunction(){
            String retorno = "";
            for (Function f : functions){
                retorno = retorno+ " " + f.toString();
            }
            return retorno;
            
        }
}