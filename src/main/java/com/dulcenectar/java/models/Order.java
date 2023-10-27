package com.dulcenectar.java.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long user_id;
	
	private double total_gross;
	
	private String address;
	
	
	@CreationTimestamp
	private LocalDateTime created_at;
	

	public Order(long id, long user_id, double total_gross, String address,
			LocalDateTime created_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.total_gross = total_gross;
		this.address = address;
		this.created_at = created_at;
	}
	
	public Order(long id) {
		super();
		this.id = id;
	}

	public Order() {
		super();
	}

	//Setters and Getters

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public double getTotal_gross() {
		return total_gross;
	}

	public void setLastName(double total_gross) {
		this.total_gross = total_gross;
	}

	public String getAddress() {
		return address;
	}

	public void setEmail(String address) {
		this.address = address;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
