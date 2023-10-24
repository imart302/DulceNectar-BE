package com.dulcenectar.java.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dulcenectar.java.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByEmail(String email);
}
