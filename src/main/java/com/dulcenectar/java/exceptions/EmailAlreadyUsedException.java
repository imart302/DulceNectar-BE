package com.dulcenectar.java.exceptions;


/**
 * Exception que se dispara cuando se intenta crear un usuario
 * que tiene un email que ya existe en la db
 */
public class EmailAlreadyUsedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 66670657514895329L;

	public EmailAlreadyUsedException() {
		super("Email ya ha sido usado");
	}
}
