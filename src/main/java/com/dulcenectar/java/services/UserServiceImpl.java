package com.dulcenectar.java.services;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dulcenectar.java.dtos.user.CreateUserRequestDto;
import com.dulcenectar.java.dtos.user.LoginUserRequestDto;
import com.dulcenectar.java.dtos.user.LoginUserResponseDto;
import com.dulcenectar.java.exceptions.EmailAlreadyUsedException;
import com.dulcenectar.java.exceptions.UserNotFoundException;
import com.dulcenectar.java.models.User;
import com.dulcenectar.java.repositories.UserRepository;
import com.dulcenectar.java.services.interfaces.JwtService;
import com.dulcenectar.java.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.jwtService = jwtService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public User createUser(CreateUserRequestDto user) {
		User preUser = this.userRepository.findByEmail(user.getEmail());
		
		if(preUser != null) throw new EmailAlreadyUsedException();
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return this.userRepository.save(user.toEntity());
	}

	@Override
	public LoginUserResponseDto loginUser(LoginUserRequestDto user) {
		User userDb = this.userRepository.findByEmail(user.getEmail());
		if(userDb == null) {
			throw new UserNotFoundException("No existe el usuario");
		}
		LoginUserResponseDto userDto = new LoginUserResponseDto();
		userDto.fromEntity(userDb);
		String jws = this.jwtService.getToken(userDb);
		userDto.setToken(jws);
		return userDto;
	}
	
	@Override
	public User findUserByEmail(String email) {
		User userDb = this.userRepository.findByEmail(email);
		return userDb;
	}
}
