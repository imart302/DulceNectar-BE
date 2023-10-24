package com.dulcenectar.java.dtos;

public class ExceptionDto implements ResponseDto<Exception> {

	private String message;
	
	public ExceptionDto() {
		
	}
	
	public ExceptionDto(String message) {
		this.setMessage(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public ExceptionDto fromEntity(Exception entity) {
		this.message = entity.getMessage();
		return this;
	}
	
}
