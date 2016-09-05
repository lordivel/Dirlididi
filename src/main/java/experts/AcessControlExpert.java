package main.java.experts;

public class AcessControlExpert {
	
	private AcessControl permition;

	public AcessControlExpert(AcessControl acess){
		setPermition(acess);
	}

	public AcessControl getPermition() {
		return permition;
	}

	public void setPermition(AcessControl permition) {
		this.permition = permition;
	}
}

enum AcessControl{
	ADMIN,USER,ANONIMOUS;
}