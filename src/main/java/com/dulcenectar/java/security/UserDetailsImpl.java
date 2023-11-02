package com.dulcenectar.java.security;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dulcenectar.java.models.User;

public class UserDetailsImpl extends User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1833377617454173091L;
	
	public UserDetailsImpl() {
		super();
	}

	public UserDetailsImpl(Integer id, String firstName, String lastName, String email, String password, Role role,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(id, firstName, lastName, email, password, role, createdAt, updatedAt);
	}

	public UserDetailsImpl(Integer id, String firstName, String lastName, String email, String password) {
		super(id, firstName, lastName, email, password);
	}

	public UserDetailsImpl(Integer id) {
		super(id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority((role.name())));
	}

	@Override
	public String getPassword() {
		return this.getPassword();
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
