package com.dulcenectar.java.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulcenectar.java.dtos.review.ResponseReviewDto;
import com.dulcenectar.java.models.Review;
import com.dulcenectar.java.repositories.ReviewRepository;
import com.dulcenectar.java.services.interfaces.IReviewService;

@Service
public class ReviewServiceImpl implements IReviewService {
	@Autowired ReviewRepository reviewRepository;

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
	public void saveReview(Review review) {
		reviewRepository.save(review);
		
	}

	@Override
	public void deleteReview(Integer id) {
		reviewRepository.deleteById(id);
	}
	
}