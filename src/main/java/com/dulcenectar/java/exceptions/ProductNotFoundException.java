package com.dulcenectar.java.exceptions;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException() {
		super ("El producto no existe");
	}

}
