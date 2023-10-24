package com.dulcenectar.java.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 600326024390047201L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
