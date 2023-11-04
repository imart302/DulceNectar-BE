package com.dulcenectar.java.exceptions.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dulcenectar.java.dtos.ExceptionDto;
import com.dulcenectar.java.exceptions.OrderNotFoundException;

@ControllerAdvice
public class OrderExceptionController {
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<ExceptionDto> OrderNotFoundHandler(OrderNotFoundException exp){
		ExceptionDto expDto = new ExceptionDto();
		expDto.fromEntity(exp);
		
		return new ResponseEntity<ExceptionDto>(expDto, HttpStatus.NOT_FOUND);
	}
}
