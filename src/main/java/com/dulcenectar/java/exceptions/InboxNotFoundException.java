package com.dulcenectar.java.exceptions;

public class InboxNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 99416576656526776L;

	public InboxNotFoundException() {
		super("No existe el inbox solicitado");
	}
	
}
