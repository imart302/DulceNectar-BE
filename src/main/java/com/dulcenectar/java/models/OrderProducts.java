package com.dulcenectar.java.models;

//import java.time.LocalDateTime;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_products")
public class OrderProducts {
	//Se pone porque Spring se quejó
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long quantity;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public OrderProducts(long id, long quantity, Order order, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.order = order;
		this.product = product;
	}

	public OrderProducts(long id) {
		super();
		this.id = id;
	}
	
	public OrderProducts() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}