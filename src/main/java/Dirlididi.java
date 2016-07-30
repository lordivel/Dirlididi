package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Dirlididi {

	Map<String, Problem> problemList;
	Map<String, User> userMap;

	
	public Dirlididi() {
		this.problemList = new HashMap<String, Problem>();
		this.userMap = new HashMap<String, User>();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/problem")
	public Map<String, Problem> getProblems() {
		return this.problemList;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login", params = "login , password")
	public boolean login(String login, String password) {
		return true;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/problem", params = "name, description, code, tip")
	public String addProble(String name, String description, String code, String tip) {
		List<ProblemTest> pt = new ArrayList<ProblemTest>();
		Problem prob = new Problem(name, description, code, tip, pt);
		this.problemList.put(prob.getId(), prob);
		return prob.getId();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/problem/{id}/test", params = "name, tip, entry, expectedResult")
	public String addTestToProbles( @PathVariable("id") String problemId, String name, String tip, String entry, String expectedResult) {
		ProblemTest pt = new ProblemTest(name, tip, entry, expectedResult);
		this.problemList.get(problemId).addTest(pt);
		return pt.getId();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/problem/{id}/test")
	public List<ProblemTest> getTestsFromProblem( @PathVariable("id") String problemId) {
		return this.problemList.get(problemId).getTests();
	}
	
	//TODO Fix this, not returning the correct info
	@RequestMapping(method = RequestMethod.GET, value = "/problem/{id}/test/{testid}")
	public ProblemTest getTestFromProblem( @PathVariable("id") String problemId, @PathVariable("testid") String testId) {
		return this.problemList.get(problemId).getTests().get(0);
	}
	
	//TODO Fix this, not returning the correct info
		@RequestMapping(method = RequestMethod.POST, value = "/problem/{id}/solution", params = "solutionString, user")
		public ProblemTest postProblemSolution( @PathVariable("id") String problemId, String solutionString, String user) {
			Solution sol = new Solution(solutionString, new ArrayList<String>());
			return this.userMap.get(user).putSolutionToProblem(this.problemList.get(problemId), sol);
		}
	
	
	
}
