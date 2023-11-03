package com.dulcenectar.java.dtos.review;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Review;

public class CreateReviewDto implements RequestDto<Review>{
	
	String review;
	Integer rating;
	Integer productId;
	
	
	public CreateReviewDto(String review, Integer rating, Integer productId) {
		super();
		this.review = review;
		this.rating = rating;
		this.productId = productId;
	}

	public CreateReviewDto() {
		super();
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public Review toEntity() {
		Review review1 = new Review();
		review1.setReview(review);
		review1.setRating(rating);
		
		return review1;
	}
	
	
	
	
	
}
