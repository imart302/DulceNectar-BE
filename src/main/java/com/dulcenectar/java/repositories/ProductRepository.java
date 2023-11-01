package com.dulcenectar.java.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dulcenectar.java.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	}
