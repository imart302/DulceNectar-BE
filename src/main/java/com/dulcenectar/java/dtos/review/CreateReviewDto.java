package com.dulcenectar.java.dtos.review;

import org.hibernate.validator.constraints.Range;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateReviewDto implements RequestDto<Review> {

	@NotBlank(message = "review is required")
	@Size(min = 100, message = "reviews only can have 100 characters")
	String review;
	@NotNull(message = "rating is required")
	@Range(min = 1, max = 5, message = "rating should be between 1 and 5")
	Integer rating;
	@NotNull(message = "productId is required")
	@Positive(message = "productId should be positive")
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
