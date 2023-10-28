package com.dulcenectar.java.dtos.user;

import com.dulcenectar.java.dtos.ResponseDto;
import com.dulcenectar.java.models.User;

public class CreateUserResponseDto implements ResponseDto<User> {

	private long id;
	private String firstName;
	private String lastName;
	private String email;

	public CreateUserResponseDto(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public CreateUserResponseDto() {
		super();
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public CreateUserResponseDto fromEntity(User entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.email = entity.getLastName();
		return this;
	}
}
