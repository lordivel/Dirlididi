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

	/**
	 * @return Return all registered problems.
	 */
	//GET /PROBLEM
	@RequestMapping(method = RequestMethod.GET, value = "/problem")
	public Map<String, Problem> getProblems() {
		return this.problemList;
	}

	/**
	 * Add new problem on the list of problems.
	 * @param name
	 * 			Name of the problem
	 * @param description
	 * 			Description of the problem
	 * @param code
	 * 			Problem's code
	 * @param tip
	 * 			Problem's tip
	 * @return
	 * 			This problem id. This ID is automatically created.
	 */
	//POST /PROBLEM
	@RequestMapping(method = RequestMethod.POST, value = "/problem", params = "name, description, code, tip")
	public String addProble(String name, String description, String code,
			String tip) {
		List<ProblemTest> pt = new ArrayList<ProblemTest>();
		Problem prob = new Problem(name, description, code, tip, pt);
		this.problemList.put(prob.getId(), prob);
		return prob.getId();
	}
	
	/**
	 * Get one problem by his id, or null if there is no problem with this id.
	 * @param problemId
	 * 			id of the problem you want to acess.
	 * @return
	 * 			the problem to which the specified id is mapped, or null if this map contains no problem with this id.
	 */
	//GET /PROBLEM/{id}
	@RequestMapping(method = RequestMethod.GET, value = "/problem/{id}")
	public Problem getProblemById(@PathVariable("id") String problemId) {
		return this.problemList.get(problemId);
	}

	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	//POST /LOGIN
	@RequestMapping(method = RequestMethod.POST, value = "/login", params = "login , password")
	public boolean login(String login, String password) {
		return true;
	}

	/**
	 * Add one new test on one specific problem  
	 * @param problemId
	 * 			Id of the problem you want to add the test
	 * @param name
	 * 			Name of the test
	 * @param tip
	 * 			Tip of the test
	 * @param entry
	 * 			Entry of the test
	 * @param expectedResult
	 * 			Expected Result of the test
	 * @return
	 * 			This problem id. This ID is automatically created.
	 */
	//POST /PROBLEM/{id}/TEST
	@RequestMapping(method = RequestMethod.POST, value = "/problem/{id}/test", params = "name, tip, entry, expectedResult")
	public String addTestToProbles(@PathVariable("id") String problemId,
			String name, String tip, String entry, String expectedResult) {
		ProblemTest pt = new ProblemTest(name, tip, entry, expectedResult);
		this.problemList.get(problemId).addTest(pt);
		return pt.getId();
	}

	/**
	 * Get a list of tests from one specific problem by his ID.
	 * @param problemId
	 * 			Id of the problems you want to get the test's list.
	 * @return
	 * 			List of all tests from the problem
	 */
	//GET /PROBLEM/{id}/TEST
	@RequestMapping(method = RequestMethod.GET, value = "/problem/{id}/test")
	public List<ProblemTest> getTestsFromProblem(
			@PathVariable("id") String problemId) {
		return this.problemList.get(problemId).getTests();
	}

	/**
	 * Get one specific test from one problem. Notice that same testID is completely linked with problemID, so,
	 * if you have the same testID from different problemID, it will return different test. 
	 * @param problemId
	 * 			Id of the problem you want to find the test.
	 * @param testId
	 * 			Id of the test you want to get.
	 * @return
	 * 			Chosen test from the problem.
	 */
	//GET /PROBLEM/{id}/TEST/{testid}
	// TODO Fix this, not returning the correct info
	@RequestMapping(method = RequestMethod.GET, value = "/problem/{id}/test/{testid}")
	public ProblemTest getTestFromProblem(@PathVariable("id") String problemId,
			@PathVariable("testid") String testId) {
		return this.problemList.get(problemId).getTests().get(0);
	}
	
	
	/**
	 * Create one solution from one problem
	 * @param problemId
	 * 			ID of the problem you want to add the new solution
	 * @param solutionString
	 * 			Solution of the problem
	 * @param user
	 * 			User that is sending the solution
	 * @return
	 * 			
	 */
	//POST /PROBLEM/{id}/SOLUTION
	// TODO Fix this, not returning the correct info
	@RequestMapping(method = RequestMethod.POST, value = "/problem/{id}/solution", params = "solutionString, user")
	public ProblemTest postProblemSolution(
			@PathVariable("id") String problemId, String solutionString,
			String user) {
		Solution sol = new Solution(solutionString, new ArrayList<String>());
		return this.userMap.get(user).putSolutionToProblem(
				this.problemList.get(problemId), sol);
	}

}
