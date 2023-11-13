package com.dulcenectar.java.exceptions;

public class OrderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8894947839572684859L;

	
	public OrderNotFoundException() {
		super("No existe esta order");
	}
	
}
