package planner.planners;

import java.io.IOException;

import planner.strips.Problem;
import planner.strips.pddl.PDDLLoader;
import planner.strips.pddl.antlr.PDDLParseException;
import planner.strips.pddl.antlr.PDDLSyntaxException;

public class Configuration {

	public String problemPath = ""; 
	public String domainPath = "";
	
	public Configuration() {
		problemPath = "example/pddl/problem-veiculo.pddl";
		domainPath = "example/pddl/domain-veiculo.pddl";
	}
	
	public Problem getProblemFromPddl() throws PDDLSyntaxException, IOException, PDDLParseException{
		PDDLLoader pddlLoader = new PDDLLoader(domainPath, problemPath);
		return pddlLoader.getProblem();
	}

}
