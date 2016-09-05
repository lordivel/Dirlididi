package main.java;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.ldap.odm.annotations.Id;

public class Problem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	private String code;
	private String tip;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="problem_id")
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
	
	//TODO Update solution to use Entries
	public boolean checkSolution(Solution solution) {
		List<String> auxList = getAllExpectedResults();
		if (solution.getResults().size() != auxList.size()) return false;
		auxList.retainAll(solution.getResults());
		return auxList.equals(getAllExpectedResults());
		
	}

	public String getId() {
		return this.id;
	}

	public void addTest(ProblemTest test) {
		this.tests.add(test);
	}
	
}
