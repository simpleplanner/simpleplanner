package planner.strips.pddl;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 *
 */
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
}
