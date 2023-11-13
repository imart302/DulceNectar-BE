package com.dulcenectar.java.dtos.user;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.User;

import jakarta.validation.constraints.NotBlank;

public class LoginUserRequestDto implements RequestDto<User> {

	@NotBlank(message = "email is required")
	private String email;
	@NotBlank(message = "password is required")
	private String password;
	
	public LoginUserRequestDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public LoginUserRequestDto() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public User toEntity() {
		return null;
	}
}
