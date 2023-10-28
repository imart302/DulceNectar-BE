package com.dulcenectar.java.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	//private long user_id;
	private double totalGross;
	private String address;
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Order(long id, double total_gross, String address,
			LocalDateTime createdAt, User user) {
		super();
		this.id = id;
		//this.user_id = user_id;
		this.totalGross = total_gross;
		this.address = address;
		this.createdAt = createdAt;
		this.user = user;
	}
	
	public Order(long id) {
		super();
		this.id = id;
	}

	public Order() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalGross() {
		return totalGross;
	}

	public void setTotalGross(double totalGross) {
		this.totalGross = totalGross;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}