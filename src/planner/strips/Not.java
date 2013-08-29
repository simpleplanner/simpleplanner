package planner.strips;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class Not implements Condition {
	
	public Predicate predicate;
	
	public Not() {
		
	}
	
	@Override
	public State apply(State s) {
		State novo = s.copy();
		Parametized other = s.findSame(predicate);
		if (other != null)
			novo.predicates.remove(other);
		return novo;
	}

	@Override
	public State unapply(State s) {
		State novo = s.copy();
		Parametized other = novo.findSame(predicate);
		if (other == null){
			novo.predicates.add(predicate);
		}
		return novo;
	}

	
	@Override
	public boolean verify(State s) {
		return !predicate.verify(s);
	}

	@Override
	public void replaceParams(List<Parameter> oldNames,List<Parameter> newNames) {
		predicate.replaceParams(oldNames,newNames);
	}

	@Override
	public Not copy() {
		Not copy = new Not();
		copy.predicate = predicate.copy();
		return copy;
	}

	@Override
	public String toString() {
		return "(not "+predicate+")";
	}
	
}
