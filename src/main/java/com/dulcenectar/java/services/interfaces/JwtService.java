package com.dulcenectar.java.services.interfaces;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;

import com.dulcenectar.java.models.User;

import io.jsonwebtoken.Claims;


public interface JwtService {
	public String getToken(User userDto);
	public String getToken(Map<String, Object> extraClaims, UserDetails user);
	public SecretKey getKey();
	public String getUserEmailFromToken(String token);
	public boolean isTokenValid(String token, UserDetails userDetails);
	public Claims getAllClaims(String token);
	public <T> T getClaim(String token, Function<Claims, T> claimsResolver);
	public Date getExpiration(String token);
	public boolean isTokenExpired(String token);

}
