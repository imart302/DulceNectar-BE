package com.dulcenectar.java.dtos.user;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateUserRequestDto implements RequestDto<User> {

	@NotBlank(message = "firsName is required")
	private String firstName;
	@NotBlank(message = "lastName is required")
	private String lastName;
	@NotBlank(message = "email is required")
	@Email(message = "email should be a valid email")
	private String email;
	@NotBlank(message = "password is required")
	private String password;

	public CreateUserRequestDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public CreateUserRequestDto() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public User toEntity() {
		User user = new User();
		user.setEmail(this.email);
		user.setFirstName(this.firstName);
		user.setLastName(this.lastName);
		user.setPassword(this.password);
		return user;
	}

}