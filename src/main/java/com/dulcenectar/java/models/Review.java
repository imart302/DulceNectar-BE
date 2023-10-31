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
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	private String review;
	private int rating;
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	@CreationTimestamp
	private LocalDateTime created_at;
	@UpdateTimestamp
	private LocalDateTime updated_at;

	
	public Review(Integer id, User user, String review, int rating, Product product, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.id = id;
		this.user = user;
		this.review = review;
		this.rating = rating;
		this.product = product;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Review (Integer id) {
		this.id = id;
	}
	
	public Review () {}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
		return "Review [id=" + id + ", user=" + user + ", review=" + review + ", rating=" + rating + ", product="
				+ product + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}	
}