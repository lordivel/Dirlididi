package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private String solutionBody;

	private List<String> results;

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
