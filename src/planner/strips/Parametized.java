package planner.strips;

import java.util.ArrayList;
import java.util.List;

public abstract class Parametized implements Condition {

	public String name;
	public List<String> params = new ArrayList<String>();
	
	@Override
	public void replaceParams(List<String> oldNames, List<String> newNames) {
		List<String> newParams = new ArrayList<String>();
		for (String p : params) {
			int index = oldNames.indexOf(p);
			String newValue = newNames.get(index);
			newParams.add(newValue);
		}
		params = newParams;
	}

}