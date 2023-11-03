package com.dulcenectar.java.exceptions.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dulcenectar.java.dtos.ExceptionDto;
import com.dulcenectar.java.exceptions.ReviewNotFoundException;

@ControllerAdvice
public class ReviewExceptionController {
	
	@ExceptionHandler(value = ReviewNotFoundException.class)
		public ResponseEntity<ExceptionDto> reviewNotFoundHandler(ReviewNotFoundException exeption){
			ExceptionDto exceptionDto = new ExceptionDto();
			exceptionDto.fromEntity(exeption);
			
			return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.NOT_FOUND);
		}
	
}
