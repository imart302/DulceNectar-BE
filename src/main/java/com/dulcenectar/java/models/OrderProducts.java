package com.dulcenectar.java.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_products")
public class OrderProducts {
	
	@Embeddable
	public static class OrderProductId implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Column(name = "order_id")
		private Integer orderId;
		@Column(name = "product_id")
		private Integer productId;
		
		public OrderProductId(Integer orderId, Integer productId) {
			super();
			this.orderId = orderId;
			this.productId = productId;
		}
		
		public OrderProductId() {
			super();
		}

		public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		
	}
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@EmbeddedId
	private OrderProductId id;
	private Integer quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("orderId")
	@JoinColumn(name = "order_id")
	private Order order;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	private Product product;

	public OrderProducts(OrderProductId id, Integer quantity, Order order, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.order = order;
		this.product = product;
	}
	
	public OrderProducts() {
		super();
	}


	public OrderProductId getId() {
		return id;
	}

	public void setId(OrderProductId id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
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

	@Override
	public String toString() {
		return "OrderProducts [quantity=" + quantity + ", product=" + product + "]";
	}
	
}
