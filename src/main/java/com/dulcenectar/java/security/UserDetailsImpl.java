package com.dulcenectar.java.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dulcenectar.java.models.User;

public class UserDetailsImpl implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1833377617454173091L;
	
	private Integer id;
	private String email;
	private String password;
	private User.Role role;
	
	public UserDetailsImpl(Integer id, String email, String password, User.Role role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public UserDetailsImpl(String email, String password, User.Role role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority((role.name())));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "UserDetailsImpl [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
	
}
