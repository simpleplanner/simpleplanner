package planner.strips;

/**
 * @author Sávio Mota
 *
 */
public class Parameter {
	public String name;
	public String type;
	
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
