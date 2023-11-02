package com.dulcenectar.java.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dulcenectar.java.models.User;
import com.dulcenectar.java.services.interfaces.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userServices;

    public UserDetailsServiceImpl(UserService userServices) {
        this.userServices = userServices;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User u = this.userServices.findUserByEmail(username);
        if (u == null)
            throw new UsernameNotFoundException("No existe el usuario");

        return new UserDetailsImpl(u.getId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword(),
                u.getRole(), u.getCreatedAt(), u.getUpdatedAt());
    }

}