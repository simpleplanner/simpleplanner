package planner.strips;

/**
 * @author <a href="mailto:erickpassos@gmail.com">Erick Passos</a> 
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class Predicate extends Parametized implements Condition {

	@Override
	public State apply(State s) {
		State novo = s.copy();
		novo.predicates.add(this);
		return novo;
	}

	public boolean verify(State s) {
		if (s.findSame(this) != null)
			return true;
		return false;
	}
	
	@Override
	public Predicate copy() {
		Predicate copy = new Predicate();
		copy.name = name;
		copy.params = params;
		return copy;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj instanceof Parametized) {
			Parametized other = (Parametized) obj;
			if (name.equals(other.name) && params.size() == other.params.size()) {
				for (int i = 0; i < params.size(); i++) {
					if (!params.get(i).equals(other.params.get(i)))
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Implementação baseada no Item 9 do livro Effective java...
	 * 
	 * @author Sávio Mota
	 * 
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + params.hashCode();
		return result;
	}

	@Override
	public String toString() {
		String retorno = "(" + name;
		for (Parameter p : params) {
			retorno += " " + p;
		}
		retorno += ")";
		return retorno;
	}

}
