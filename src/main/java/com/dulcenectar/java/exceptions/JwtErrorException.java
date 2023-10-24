package com.dulcenectar.java.exceptions;

public class JwtErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4702874997895867447L;

	public JwtErrorException(String message) {
		super(message);
	}
	
}
