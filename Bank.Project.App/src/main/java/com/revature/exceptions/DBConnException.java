package com.revature.exceptions;

public class DBConnException extends Exception {

	public DBConnException() {
		super();
	}
	
	public DBConnException(String message) {
		super(message);
	}
	
	public DBConnException(Throwable cause) {
		super(cause);
	}
	
	public DBConnException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DBConnException(String message, Throwable cause, boolean enableExpression, boolean writeableStackTrace) {
		super(message, cause, enableExpression, writeableStackTrace);
	}

}
