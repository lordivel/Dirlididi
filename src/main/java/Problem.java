package main.java;

import java.util.ArrayList;
import java.util.List;

public class Problem {
	private String name;
	private String description;
	private String code;
	private String tip;
	private List<ProblemTest> tests;

	public Problem(String name, String description, String code, String tip,
			List<ProblemTest> tests) {
		super();
		this.name = name;
		this.description = description;
		this.code = code;
		this.tip = tip;
		this.tests = tests;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<ProblemTest> getTests() {
		return tests;
	}

	public void setTests(List<ProblemTest> tests) {
		this.tests = tests;
	}

	public List<String> getAllExpectedResults() {
		List<String> allSolutions = new ArrayList<String>();
		for (ProblemTest test : getTests()) {
			allSolutions.add(test.getExpectedResult());
		}
		return allSolutions;
	}

	public boolean checkSolution(Solution solution) {
		List<String> auxList = getAllExpectedResults();
		if (solution.getResults().size() != auxList.size()) return false;
		auxList.retainAll(solution.getResults());
		return auxList.equals(getAllExpectedResults());
		
	}

}
