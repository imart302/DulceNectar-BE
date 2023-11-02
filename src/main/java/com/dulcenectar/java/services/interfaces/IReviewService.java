package com.dulcenectar.java.services.interfaces;

import java.util.ArrayList;

import com.dulcenectar.java.dtos.review.ResponseReviewDto;
import com.dulcenectar.java.models.Review;

public interface IReviewService {
	
	
	public ArrayList<ResponseReviewDto> getReviews();
	
	public void saveReview( Review review );
	
	public void deleteReview( Integer id ); 
}
