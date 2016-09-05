package main.java.exception;

public class NoPermitionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Exception when there is one blank space when it was
	 * suppose to have one message.
	 * @param msg Exception Message.
	 */
	public NoPermitionException(String msg){
        super(msg);
    }
}
