package planner.strips;

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
	public boolean equals(Object other) {
		if (other instanceof Parametized) {
			Parametized o = (Parametized) other;
			if (name.equals(o.name) && params.size() == o.params.size()) {
				for (int i = 0; i < params.size(); i++) {
					if (!params.get(i).equals(o.params.get(i)))
						return false;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public Predicate copy() {
		Predicate copy = new Predicate();
		copy.name = name;
		copy.params.addAll(params);
		return copy;
	}

	@Override
	public String toString() {
		String retorno = "(" + name;
		for (String p : params) {
			retorno += " " + p;
		}
		retorno += ")";
		return retorno;
	}

}
