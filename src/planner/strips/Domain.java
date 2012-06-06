package planner.strips;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class Domain {
	public String name;
	public Collection<Action> actions = new HashSet<Action>();
	public Map<String, Type> types = new HashMap<String, Type>();
	public Collection<String> requirements = new HashSet<String>();
	public Map<String, Predicate> predicates = new HashMap<String, Predicate>();
	
	public Domain() {
		Type object = new Type("object");
		types.put(object.name, object);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("(define (domain " + name + ")\n");
		builder.append("	(:requirements ");
		for (String req : requirements) {
			builder.append(req + " ");
		}
		builder.append(")\n	(:types ");
		for (String key : types.keySet()) {
			builder.append(types.get(key) + " ");
		}
		builder.append("	)\n	(:predicates\n");
		for (String key : predicates.keySet()) {
			builder.append("		" + predicates.get(key) + "\n");
		}
		builder.append("	)\n");
		
		for (Action action : actions) {
			builder.append("	" + action + "\n");
		}
		builder.append(")");
		
		return builder.toString();
	}
}
