package com.dulcenectar.java.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.dulcenectar.java.models.Category;

public interface CategoryRepository extends CrudRepository <Category, String>{
	public Optional<Category> findByName(String name);
}
