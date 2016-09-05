package main.java;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.ldap.odm.annotations.Id;

public class Solution {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@Column(nullable = false)
	private String solutionBody;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="solution_id")
	private List<String> results;

	@ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="problem_id", nullable = false)
    private Problem problem;
	
	private boolean isCorrect = false;

	public Solution(String solutionBody, List<String> results) {
		this.solutionBody = solutionBody;
		this.results = (ArrayList<String>) results;
	}

	public String getSolutionBody() {
		return solutionBody;
	}

	public void setSolutionBody(String solutionBody) {
		this.solutionBody = solutionBody;
	}

	public List<String> getResults() {
		return results;
	}

	public void setResults(List<String> results) {
		this.results = results;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public void correctSolution() {
		this.isCorrect = true;
	}
}
