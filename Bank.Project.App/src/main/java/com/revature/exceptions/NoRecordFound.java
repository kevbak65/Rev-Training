package com.revature.exceptions;

public class NoRecordFound extends Exception {
	
	public NoRecordFound() {
		super();
	}
	
	public NoRecordFound(String message) {
		super(message);
	}
	
	public NoRecordFound(Throwable cause) {
		super(cause);
	}
	
	public NoRecordFound(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NoRecordFound(String message, Throwable cause, boolean enableExpression, boolean writeableStackTrace) {
		super(message, cause, enableExpression, writeableStackTrace);
	}


}
