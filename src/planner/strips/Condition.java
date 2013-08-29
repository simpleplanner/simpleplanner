package planner.strips;

import java.util.List;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public interface Condition {
	public boolean verify(State s);
	public State apply(State s);
	public void replaceParams(List<Parameter> oldNames, List<Parameter> newNames);
	public Condition copy();
	public State unapply(State state);
}
