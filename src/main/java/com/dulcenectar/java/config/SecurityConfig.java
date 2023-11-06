package com.dulcenectar.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dulcenectar.java.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@Bean
	AuthenticationProvider authProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(this.userDetailsService);
		authenticationProvider.setPasswordEncoder(this.passwordEncoder);
		return authenticationProvider;
	}

	@Bean
	AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}


	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						authRequest -> authRequest
						.requestMatchers("/auth/**").permitAll()
						.requestMatchers(HttpMethod.GET, "/product").permitAll()
						.requestMatchers(HttpMethod.POST, "/product").hasAnyAuthority("ADMIN")
						//Como se agrega el path variable?
						//.requestMatchers(HttpMethod.PUT, "/product").hasAnyAuthority("ADMIN")
						//.requestMatchers(HttpMethod.DELETE, "/product").hasAnyAuthority("ADMIN")
						.requestMatchers(HttpMethod.GET, "/reviews").permitAll()
						.requestMatchers(HttpMethod.GET, "/review").permitAll()
						.requestMatchers(HttpMethod.POST, "/review").hasAnyAuthority("USER")
						.requestMatchers(HttpMethod.DELETE, "/review/**").hasAnyAuthority("USER")
						.requestMatchers(HttpMethod.PUT, "/review/**").hasAnyAuthority("USER")
						.requestMatchers(HttpMethod.GET, "/inbox").hasAnyAuthority("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/inbox/**").hasAnyAuthority("ADMIN")
						.anyRequest().permitAll())
				.sessionManagement(
						sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authProvider())
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class).build();

	}

}