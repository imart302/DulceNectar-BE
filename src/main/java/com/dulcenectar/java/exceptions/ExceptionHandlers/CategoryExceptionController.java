package com.dulcenectar.java.exceptions.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dulcenectar.java.dtos.ExceptionDto;
import com.dulcenectar.java.exceptions.CategoryNotFoundException;

@ControllerAdvice
public class CategoryExceptionController {
	
	@ExceptionHandler(value = CategoryNotFoundException.class)
	public ResponseEntity<ExceptionDto> CategoryNotFound(CategoryNotFoundException ex){
		ExceptionDto exception = new ExceptionDto().fromEntity(ex);
		return new ResponseEntity<ExceptionDto>(exception, HttpStatus.NOT_FOUND);
	}
}
