package com.dulcenectar.java.services;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dulcenectar.java.dtos.review.CreateReviewDto;
import com.dulcenectar.java.dtos.review.ResponseReviewDto;
import com.dulcenectar.java.dtos.review.UpdateReviewDto;
import com.dulcenectar.java.exceptions.ReviewNotFoundException;
import com.dulcenectar.java.models.Product;
import com.dulcenectar.java.models.Review;
import com.dulcenectar.java.repositories.ProductRepository;
import com.dulcenectar.java.repositories.ReviewRepository;
import com.dulcenectar.java.security.UserDetailsImpl;
import com.dulcenectar.java.services.interfaces.IReviewService;


@Service
public class ReviewServiceImpl implements IReviewService {
	@Autowired ReviewRepository reviewRepository;
	@Autowired ProductRepository productRepository;

	@Override
	public ArrayList<ResponseReviewDto> getReviews() {
		ArrayList<Review> reviewsList = (ArrayList<Review>)reviewRepository.findAll();
		ArrayList<ResponseReviewDto> reviewsResponse = new ArrayList<>();
		
		for(Review review: reviewsList) {
			ResponseReviewDto reviewResponseDto = new ResponseReviewDto();
			reviewsResponse.add(reviewResponseDto.fromEntity(review));
		}
		return reviewsResponse;
	}

	@Override
	public ResponseReviewDto saveReview(CreateReviewDto review) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl currentUser = (UserDetailsImpl)authentication.getPrincipal();
		
		Optional<Product> product = productRepository.findById(review.getProductId());
		if(product.isEmpty()) throw new ProductNotFoundException; 
		
		Review reviewEntity = review.toEntity();
		reviewEntity.setProduct(product.get());
		reviewEntity.setUser(currentUser);
		reviewRepository.save(reviewEntity);
		
		ResponseReviewDto response = new ResponseReviewDto();
		return response.fromEntity(reviewEntity);
	}
	
	
	
	@Override
	public ResponseReviewDto deleteReview(Integer id) {
		Optional<Review> reviewCheck = reviewRepository.findById(id);
		
		if(reviewCheck.isEmpty()) throw new ReviewNotFoundException();
		
		ResponseReviewDto response = new ResponseReviewDto();
		response.fromEntity(reviewCheck.get());
		reviewRepository.delete(reviewCheck.get());
		
		return response;
	}

	@Override
	public ResponseReviewDto updateReview(Integer id, UpdateReviewDto review) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl currentUser = (UserDetailsImpl)authentication.getPrincipal();
		
		Optional<Review> reviewDb = reviewRepository.findById(id);
		if(reviewDb.get() == null) throw new ReviewNotFoundException();
		
		Review initialReview = reviewDb.get();
		Optional<Product> productDb = productRepository.findById(review.getProductId());
		//if(productDb.isEmpty()) throw new ProductNotFoundException();
		
		Product entityProduct = productDb.get();
		initialReview.setUser(currentUser);
		initialReview.setRating(review.getRating());
		initialReview.setReview(review.getReview());
		initialReview.setProduct(entityProduct);
		reviewRepository.save(initialReview);
		
		ResponseReviewDto response = new ResponseReviewDto();
		return response.fromEntity(initialReview);
	}
	
}