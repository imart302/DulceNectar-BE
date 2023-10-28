package com.dulcenectar.java.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inbox")
public class Inbox {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String message;
	private String senderEmail;
	private String phoneNumber;
	private String name;
	
	@CreationTimestamp
	private LocalDateTime createdAt;

	public Inbox(long id, String message, String senderEmail, String phoneNumber, String name,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.message = message;
		this.senderEmail = senderEmail;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.createdAt = createdAt;
	}
	
	public Inbox(long id) {
		super();
		this.id = id;
	}
	
	public Inbox() {
		super();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getSenderEmail() {
		return senderEmail;
	}
	
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
