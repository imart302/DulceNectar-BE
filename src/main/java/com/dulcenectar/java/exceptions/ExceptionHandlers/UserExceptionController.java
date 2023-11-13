package com.dulcenectar.java.exceptions.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dulcenectar.java.dtos.ExceptionDto;
import com.dulcenectar.java.exceptions.EmailAlreadyUsedException;
import com.dulcenectar.java.exceptions.JwtErrorException;
import com.dulcenectar.java.exceptions.UserNotFoundException;


/**
 * Controlador de excepciones del Usuario
 */
@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value = EmailAlreadyUsedException.class)
	public ResponseEntity<ExceptionDto> emailExistsHandler(EmailAlreadyUsedException exception){
		ExceptionDto exc = new ExceptionDto();
		exc.fromEntity(exception);
		return new ResponseEntity<ExceptionDto>(exc, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ExceptionDto> userNotFoundHandler(UserNotFoundException exception){
		ExceptionDto exc = new ExceptionDto();
		exc.fromEntity(exception);
		return new ResponseEntity<ExceptionDto>(exc, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = JwtErrorException.class)
	public ResponseEntity<ExceptionDto> jwtErrorHandler(JwtErrorException exception){
		ExceptionDto exc = new ExceptionDto();
		exc.fromEntity(exception);
		return new ResponseEntity<ExceptionDto>(exc, HttpStatus.FORBIDDEN);
	}
	
}
