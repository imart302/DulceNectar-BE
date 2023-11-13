package com.dulcenectar.java.dtos.review;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Review;

public class UpdateReviewDto implements RequestDto<Review> {

	String review;
	Integer rating;
	Integer productId;
	
	public UpdateReviewDto( String review, Integer rating, Integer productId) {
		super();
		this.review = review;
		this.rating = rating;
		this.productId = productId;
	}

	public UpdateReviewDto() {
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
		review1.setRating(rating);
		review1.setReview(review);

		return review1;
	}
	
	
}
