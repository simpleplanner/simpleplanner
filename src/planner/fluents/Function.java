package planner.fluents;

import java.util.List;
import planner.strips.Condition;
import planner.strips.Parameter;
import planner.strips.Parametized;
import planner.strips.State;

/**
 * Autores: Ellen Gera, Helcio Soares e Rogerio Figueredo
 * 
 * Classe responsável por representar as funções dos fluents
 * Toda função tem um valor, no caso o atributo value, do tipo Integer;
 * 
 */
public class Function extends Parametized implements Condition {

	private Integer hashCode;
        public Integer value = 0;

	public Function() {
	}
	
	public Function(String name, List<Parameter> params) {
		this.name = name;
		this.params = params;
	}
	
	@Override
	public State apply(State s) {
		State novo = s.copy();
		novo.functions.add(this);

		return novo;
	}

	
	public boolean verify(State s) {
		if (s.findSame(this) != null)
			return true;
		return false;
	}
	
	
	@Override
	public Function copy() {
		Function copy = new Function();
		copy.name   = name;
		copy.params = params;
                copy.value  = new Integer(value);
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
		if (hashCode == null){
			int result = 17;
			result = 31 * result + name.hashCode();
			result = 31 * result + params.hashCode();
			hashCode = result;
		}
		return hashCode;
	}

	@Override
	public String toString() {
		String retorno = "(" + name;
		for (Parameter p : params) {
			retorno += " " + p;
		}
		retorno += " = "+ value +")";
		return retorno;
	}

	//TOOD implement me
	@Override
	public State unapply(State state) {
		return null;
	}

}
