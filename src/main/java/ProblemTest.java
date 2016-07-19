package main.java;

public class ProblemTest {
	public enum TestType {
		PUBLIC, PRIVATE
	}
	
	private String name;
	private String tip;
	private String entry;
	private String expectedResult;
	
	/**
	 * One unique test for one problem. 
	 * This test contains one entry and one expected result for the entry.
	 * 
	 * @param name
	 * @param tip
	 * @param entry
	 * @param expectedResult
	 */
	public ProblemTest(String name, String tip, String entry,
			String expectedResult) {
		super();
		this.name = name;
		this.tip = tip;
		this.entry = entry;
		this.expectedResult = expectedResult;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	
	
}
