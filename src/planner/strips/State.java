package planner.strips;

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

	public State copy() {
		State novo = new State();
		novo.predicates.addAll(predicates);
		return novo;
	}

	public Parametized findSame(Predicate predicate) {
		if (predicates.contains(predicate)){
			return predicate;
		}
		return null;
	}

	public boolean solves(Problem p) {
		return p.goal.verify(this);
	}

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
		int result = 17;
		result = 31 * result + predicates.hashCode();
		return result;
	}
	
	@Override
	public String toString() {
		return predicates.toString();
	}
}
