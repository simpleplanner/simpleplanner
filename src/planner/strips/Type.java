package planner.strips;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 *
 */
public class Type {
	public String name;
	public Type type;

	public Type() {
	}

	public Type(String name) {
		this.name = name;
	}
	
	public Type(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj instanceof Type){
			Type other = (Type) obj;
			return other.name.equals(name);
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
		return result;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
