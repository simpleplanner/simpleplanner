package planner.strips.pddl;

public class PDDLSyntaxException extends Exception {
	private static final long serialVersionUID = 8110254723174076314L;

	public PDDLSyntaxException() {
		super();
	}

	public PDDLSyntaxException(String message) {
		super(message);
	}

	public PDDLSyntaxException(Throwable cause) {
		super(cause);
	}

	public PDDLSyntaxException(String message, Throwable cause) {
		super(message, cause);
	}
}
