package com.dulcenectar.java.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@ManyToOne
	//@JoinColumn(name = "user_id")
	//private User user;
	
	private long user_id;
	private String review;
	private int rating;
	
	//@ManyToOne
	//@JoinColumn(name = "product_id")
	//private Product product;
	
	@CreationTimestamp
	private LocalDateTime created_at;
	
	@UpdateTimestamp
	private LocalDateTime updated_at;

	public Review(Long id, long user_id, String review, int rating, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.review = review;
		this.rating = rating;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public Review (Long id) {
		this.id = id;
	}
	
	public Review () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", user_id=" + user_id + ", review=" + review + ", rating=" + rating
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

	
}
