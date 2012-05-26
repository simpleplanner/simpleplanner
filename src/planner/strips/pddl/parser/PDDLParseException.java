package planner.strips.pddl.parser;

public class PDDLParseException extends Exception {
	private static final long serialVersionUID = -479124650511858507L;

	public PDDLParseException() {
		super();
	}

	public PDDLParseException(String message) {
		super(message);
	}

	public PDDLParseException(Throwable cause) {
		super(cause);
	}

	public PDDLParseException(String message, Throwable cause) {
		super(message, cause);
	}
}
