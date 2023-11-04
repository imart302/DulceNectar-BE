package com.dulcenectar.java.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.dulcenectar.java.dtos.order.CreateOrderRequestDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double totalGross;
	private String address;
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<OrderProducts> orderProducts;

	public Order(Long id, Double totalGross, String address, LocalDateTime createdAt, User user,
			List<OrderProducts> orderProducts) {
		super();
		this.id = id;
		this.totalGross = totalGross;
		this.address = address;
		this.createdAt = createdAt;
		this.user = user;
		this.orderProducts = orderProducts;
	}
	
	public Order(Long id) {
		super();
		this.id = id;
	}

	public Order() {
		super();
	}

	public void setId(Long orderId) {
		this.id = orderId;
	}
	public Long getId() {
		return id;
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

	public List<OrderProducts> getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderProducts(List<OrderProducts> orderProducts) {
		this.orderProducts = orderProducts;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", totalGross=" + totalGross + ", address=" + address + ", createdAt=" + createdAt
				+ ", user=" + user + ", orderProducts=" + orderProducts + "]";
	}
}