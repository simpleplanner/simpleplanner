package planner.strips;

public class PredicateMock extends Predicate{
	
	public boolean verifyResult;

	public PredicateMock(boolean verifyResult) {
		super();
		this.verifyResult = verifyResult;
	}

	@Override
	public boolean verify(State s) {
		return verifyResult;
	}


}
