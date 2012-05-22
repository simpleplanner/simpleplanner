package planner.strips;

import java.util.Collection;
import java.util.HashSet;

public class Domain {
	public String name;
	public Collection<Action> actions = new HashSet<Action>();
	public Collection<String> types = new HashSet<String>();
}
