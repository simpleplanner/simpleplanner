package planner.strips.pddl;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 *
 */
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

}
