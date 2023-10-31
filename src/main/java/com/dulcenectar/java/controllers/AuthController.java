package com.dulcenectar.java.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulcenectar.java.dtos.user.*;
import com.dulcenectar.java.services.interfaces.UserService;


@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	private final UserService userServices;
	
	public AuthController(UserService userServices) {
		this.userServices = userServices;
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody CreateUserRequestDto userRequest) {
		CreateUserResponseDto userRes = userServices.createUser(userRequest);
		
		return new ResponseEntity<CreateUserResponseDto>(userRes, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<LoginUserResponseDto> loginUser(@RequestBody LoginUserRequestDto userData){
		LoginUserResponseDto userDto = userServices.loginUser(userData);
	
		return new ResponseEntity<LoginUserResponseDto>(userDto, HttpStatus.OK);
	}
	
}
