package com.dulcenectar.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulcenectar.java.models.Review;
import com.dulcenectar.java.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired ReviewRepository reviewrepository;
	
	
	public void postReviews(Review review) {
		reviewrepository.save(review);
	}
}
