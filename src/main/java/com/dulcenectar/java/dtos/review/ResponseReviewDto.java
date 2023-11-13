package com.dulcenectar.java.dtos.review;

import com.dulcenectar.java.dtos.ResponseDto;
import com.dulcenectar.java.models.Review;

public class ResponseReviewDto implements ResponseDto<Review> {
	private Integer id;
	private String userName;
	private String review;
	private Integer rating;
	private String productName;
	private String imgUrl;
	
	public ResponseReviewDto(Integer id, String userName, String review, Integer rating, String productName,
			String imgUrl) {
		super();
		this.id = id;
		this.userName = userName;
		this.review = review;
		this.rating = rating;
		this.productName = productName;
		this.imgUrl = imgUrl;
	}
	
	
	
	public ResponseReviewDto(Integer id) {
		super();
		this.id = id;
	}

	public ResponseReviewDto() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
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



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getImgUrl() {
		return imgUrl;
	}



	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	@Override
	public ResponseReviewDto fromEntity(Review entity) {
		id = entity.getId();
		userName = entity.getUser().getFirstName() + " " + entity.getUser().getLastName();
		review = entity.getReview();
		rating = entity.getRating();
		productName = entity.getProduct().getName();
		imgUrl = entity.getProduct().getImgUrl();
		
		return this;
	}
}

