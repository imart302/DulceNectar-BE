package com.dulcenectar.java.services.interfaces;

import java.util.ArrayList;

import com.dulcenectar.java.dtos.review.CreateReviewDto;
import com.dulcenectar.java.dtos.review.ResponseReviewDto;
import com.dulcenectar.java.dtos.review.UpdateReviewDto;

public interface IReviewService {
	
	
	public ArrayList<ResponseReviewDto> getReviews();
	
	public ResponseReviewDto saveReview(CreateReviewDto review);
	
	public ResponseReviewDto deleteReview( Integer id ); 
	
	public ResponseReviewDto updateReview(Integer id, UpdateReviewDto review);

	
}
