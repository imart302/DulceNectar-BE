package com.dulcenectar.java.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dulcenectar.java.models.Review;

public interface ReviewRepository extends CrudRepository <Review, Integer> {
	
}
