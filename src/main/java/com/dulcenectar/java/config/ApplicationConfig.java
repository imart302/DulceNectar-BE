//package com.dulcenectar.java.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.dulcenectar.java.exceptions.UserNotFoundException;
//import com.dulcenectar.java.models.User;
//import com.dulcenectar.java.repositories.UserRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Configuration
//@RequiredArgsConstructor
//public class ApplicationConfig {
//
//    private final UserRepository userRepository;
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
//    {
//        return config.getAuthenticationManager();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider()
//    {
//        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailService() {
//        return email -> { 
//        	User u = userRepository.findByEmail(email);
//        	//userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not fournd"))
//        	if(u == null) {
//        		throw new UserNotFoundException("User not found");
//        	}
//        	return u;
//        };
//    }
//
//}