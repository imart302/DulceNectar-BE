package com.dulcenectar.java.controllers;

//import java.sql.Date;
//import java.time.Instant;
//
//import javax.crypto.SecretKey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulcenectar.java.dtos.user.*;
import com.dulcenectar.java.models.User;
import com.dulcenectar.java.services.interfaces.UserService;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.io.Encoders;
//import io.jsonwebtoken.security.Keys;



@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	private final UserService userServices;
	
	public AuthController(UserService userServices) {
		this.userServices = userServices;
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody CreateUserRequestDto userRequest) {
		User user = userServices.createUser(userRequest);
		CreateUserResponseDto userRes = new CreateUserResponseDto();
		
		return new ResponseEntity<CreateUserResponseDto>(userRes.fromEntity(user), HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<LoginUserResponseDto> loginUser(@RequestBody LoginUserRequestDto userData){
		LoginUserResponseDto userDto = userServices.loginUser(userData);

//		String secretString = Encoders.BASE64.encode("hDTXtA1fyXzCQulPr07HRtwe68pY9F9G5DHY-5wQK3E".getBytes());
//		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
//		System.out.println(secretString);
//	
//		
//		String jws = Jwts.builder()
//				  .issuer("Stormpath")
//				  .subject("msilverman")
//				  .claim("name", "Micah Silverman")
//				  .claim("scope", "admins")
//				  .issuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
//				  .signWith(key)
//				  .compact();
//		
//		userDto.setToken(jws);
		
		return new ResponseEntity<LoginUserResponseDto>(userDto, HttpStatus.OK);
	}
	
}
