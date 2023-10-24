package com.dulcenectar.java.dtos.user;

import com.dulcenectar.java.dtos.ResponseDto;
import com.dulcenectar.java.models.User;

public class LoginUserResponseDto implements ResponseDto<User> {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String token;

	public LoginUserResponseDto(long id, String firstName, String lastName, String email, String token) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.token = token;
	}

	public LoginUserResponseDto(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public LoginUserResponseDto() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public LoginUserResponseDto fromEntity(User entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.email = entity.getEmail();
		return this;
	}

}
