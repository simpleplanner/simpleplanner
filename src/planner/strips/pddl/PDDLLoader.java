package planner.strips.pddl;

import java.io.IOException;

import planner.strips.Domain;
import planner.strips.Problem;
import planner.strips.pddl.antlr.PDDLParseException;
import planner.strips.pddl.antlr.PDDLSyntaxException;

/**
 * @author <a href="mailto:saviod2@gmail.com">Sávio Mota</a>
 * 
 */
public class PDDLLoader {
	private Domain domain;
	private Problem problem;
	
	public PDDLLoader(String domainFile, String problemFile) throws PDDLSyntaxException, IOException, PDDLParseException {
		PDDLDomainLoader domainBuilder = new PDDLDomainLoader(domainFile);
		domain = domainBuilder.loadDomain();
		
		PDDLProblemLoader problemBuilder = new PDDLProblemLoader(domain, problemFile);
		problem = problemBuilder.loadProblem();
	}
	
	public Domain getDomain() {
		return domain;
	}
	
	public Problem getProblem() {
		return problem;
	}
}
