package com.dulcenectar.java.services.interfaces;

import com.dulcenectar.java.dtos.user.*;
import com.dulcenectar.java.models.User;


public interface UserService {
	public CreateUserResponseDto createUser(CreateUserRequestDto user);
	public LoginUserResponseDto loginUser(LoginUserRequestDto user);
	public User findUserByEmail(String email);
}
