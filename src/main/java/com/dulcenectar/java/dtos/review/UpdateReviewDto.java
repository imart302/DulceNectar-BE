package com.dulcenectar.java.dtos.review;

import org.hibernate.validator.constraints.Range;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Review;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UpdateReviewDto implements RequestDto<Review> {

	@Size(min = 1, max = 100, message = "review size not allowed")
	String review;
	@Range(min = 1, max = 5, message = "rating must be between 1 and 5")
	Integer rating;
	@Positive(message = "productId must be positive")
	Integer productId;

	public UpdateReviewDto(String review, Integer rating, Integer productId) {
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
