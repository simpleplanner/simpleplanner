package planner.strips;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class Parameter {
	public String name;
	public Type type;
	
	public Parameter() {
	}
	
	public Parameter(String name) {
		this.name = name;
	}
	
	public Parameter(String name, Type type) {
		this(name);
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj instanceof Parameter){
			Parameter other = (Parameter) obj;
			return other.name.equals(name) && other.type.equals(type);
		}
		return false;
	}
	
	/**
	 * Implementação baseada no Item 9 do livro Effective java...
	 * 
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + type.hashCode();
		return result;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
