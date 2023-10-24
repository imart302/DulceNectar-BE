package com.dulcenectar.java.services;

import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.dulcenectar.java.exceptions.JwtErrorException;
import com.dulcenectar.java.models.User;
import com.dulcenectar.java.services.interfaces.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

	
	private final String SECRET_KEY;
	
	public JwtServiceImpl(@Value("${security.jwtsecret}") String secretKey) {
		this.SECRET_KEY = secretKey;
	}
	
	//public JwtServiceImpl() {}
	
	@Override
	public String getToken(User user) {
		String jws = Jwts.builder()
				.issuer("DulceNectarSys")
				.subject(user.getEmail())
				.claim("id", user.getId())
				.claim("role", user.getRole().name())
				.issuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
				.signWith(this.getKey()).compact();

		return jws;
	}
	
	@Override
	public String getToken(Map<String, Object> extraClaims, UserDetails user) {
		String jws = Jwts.builder()
				.issuer("DulceNectarSys")
				.subject(user.getUsername()) // username is substituted by email
				.claims(extraClaims)
				.issuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
				.signWith(this.getKey()).compact();

		return jws;
	}

	@Override
	public SecretKey getKey() {
		String secretString = Encoders.BASE64.encode(SECRET_KEY.getBytes());
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
		return key;
	}

	@Override
	public String getUserEmailFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}

	@Override
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String useremail = getUserEmailFromToken(token);
		return (useremail.equals(userDetails.getUsername()));
	}

	@Override
	public Claims getAllClaims(String token) {
		try {
			Jws<Claims> claims = Jwts.parser()
			.verifyWith(getKey())
			.build()
			.parseSignedClaims(token);
			
			return claims.getPayload();
			
		} catch (JwtException exception) {
			throw new JwtErrorException("Hubo un error en el JWT");
		}	
	}

	@Override
	public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public Date getExpiration(String token) {
		return getClaim(token, Claims::getExpiration);
	}

	public boolean isTokenExpired(String token) {
		return getExpiration(token).before(new Date());
	}
}
