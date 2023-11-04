package com.dulcenectar.java.exceptions;

public class ReviewNotFoundException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReviewNotFoundException() {
		super("No se ha encontrado la reseña");
	}
}
