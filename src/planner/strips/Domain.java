package planner.strips;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class Domain {
	public String name;
	public Collection<Action> actions = new HashSet<Action>();
	public Collection<String> types = new HashSet<String>();
}
