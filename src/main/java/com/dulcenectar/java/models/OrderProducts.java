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
import jakarta.persistence.Table;

@Entity
@Table(name = "order_products")
public class OrderProducts {
	//Se pone porque Spring se quejó
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long user_id;
	
	private long order_id;
	
	private long quantity;
	
	//private double subtotal;
	
	
	public OrderProducts(long id, long user_id, long order_id, long quantity) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.order_id = order_id;
		this.quantity = quantity;
		//this.subtotal = subtotal;
	}
	
	

	  public OrderProducts(long id) {
		super();
		this.id = id;
	}
     
	public OrderProducts() {
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

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	//public double getSubtotal() {
		//return subtotal;
	//}

	//public void setSubtotal(double subtotal) {
		//this.subtotal = subtotal;
	//}

}
