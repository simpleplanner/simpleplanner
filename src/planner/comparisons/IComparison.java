package planner.comparisons;

import planner.fluents.Function;
import planner.strips.State;

public interface IComparison {

	 public boolean verifyComparision(Function operator1, Function operator2, State s) ;
}
