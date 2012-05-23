package planner.strips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class Parametized {

	public String name;
	public List<Parameter> params = new ArrayList<Parameter>();
	public Map<String, Collection<Parameter>> typeMap = new HashMap<String, Collection<Parameter>>();
	public Map<String, Parameter> paramsMap = new HashMap<String, Parameter>();
	
	public void replaceParams(List<Parameter> oldNames, List<Parameter> newNames) {
		List<Parameter> newParams = new ArrayList<Parameter>();
		for (Parameter p : params) {
			int index = oldNames.indexOf(p);
			Parameter newValue = newNames.get(index);
			newParams.add(newValue);
		}
		params = newParams;
	}
	
	/**
	 * Método criado para possibilitar o suporte a tipos 
	 * e para facilitar a substituição dos parâmetros pelos 
	 * respectivos objetos
	 * 
	 * @author Sávio Mota
	 * 
	 */
	public void buildTypeMap(){
		for (Parameter parameter : params) {
			//Criação do mapa de tipos
			Collection<Parameter> parameters = null;
			if (!typeMap.containsKey(parameter.type)){
				parameters = new HashSet<Parameter>();
			}else{
				parameters = typeMap.get(parameter.type);
			}
			
			parameters.add(parameter);
			typeMap.put(parameter.type, parameters);
			
			//Criação do mapa de parâmetros
			paramsMap.put(parameter.name, parameter);
		}
	}

}