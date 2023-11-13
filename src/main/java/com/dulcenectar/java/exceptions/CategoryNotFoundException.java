package com.dulcenectar.java.exceptions;

public class CategoryNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CategoryNotFoundException() {
		super("La categoría no existe");
	}

}
