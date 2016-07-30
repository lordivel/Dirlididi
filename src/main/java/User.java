package main.java;

public class User {
	public enum UserType {
		ANONIMOUS, NORMAL, ADMINISTRATOR
	}

	private UserType type;

	private String email;

	private String pass;

	public User() {
		this.type = UserType.ANONIMOUS;
		this.email = "";
		this.pass = "";
	}

	public User(UserType type, String email, String pass) {
		this.type = type;
		this.email = email;
		this.pass = pass;
	}

	public void setRegistered(String email, String pass) {
		if (!this.type.equals(UserType.ADMINISTRATOR)) {
			this.type = UserType.NORMAL;
			this.email = email;
			this.pass = pass;
		} else {
		}
	}

	public boolean chPass(String pass, String confirmation, String newPass) {
		if (pass.equals(confirmation)) {
			this.pass = newPass;
			return true;
		}
		return false;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ProblemTest putSolutionToProblem(Problem problem, Solution sol) {
		// TODO Auto-generated method stub
		return null;
	}

	public Solution getSolution(Problem problem) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
