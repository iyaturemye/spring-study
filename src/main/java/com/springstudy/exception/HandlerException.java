package com.springstudy.exception;

public class HandlerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HandlerException(String message, Throwable cause) {
		super(message, cause);
	}

	public HandlerException(String message) {
		super(message);
	}

	public HandlerException(Throwable cause) {
		super(cause);
	}
	

	
	public HandlerException() {
		
	}

}
