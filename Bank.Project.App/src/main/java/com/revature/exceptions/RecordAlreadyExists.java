package com.revature.exceptions;

public class RecordAlreadyExists extends Exception{
	
	public RecordAlreadyExists() {
		super();
	}
	
	public RecordAlreadyExists(String message) {
		super(message);
	}
	
	public RecordAlreadyExists(Throwable cause) {
		super(cause);
	}
	
	public RecordAlreadyExists(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RecordAlreadyExists(String message, Throwable cause, boolean enableExpression, boolean writeableStackTrace) {
		super(message, cause, enableExpression, writeableStackTrace);
	}


}
