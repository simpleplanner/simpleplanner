package planner.strips;

import java.util.Collection;
import java.util.HashSet;

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
		for (Parametized p : predicates) {
			if (predicate.equals(p)){
				return p;
			}
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
	public boolean equals(Object other) {
		if (other.getClass().equals(State.class)){
			State o = (State) other;
			//System.out.println(predicates);
			//System.out.println(o.predicates);
			if (o.predicates.containsAll(predicates) && predicates.containsAll(o.predicates))
				return true;
		}
		return false;
	}

}
