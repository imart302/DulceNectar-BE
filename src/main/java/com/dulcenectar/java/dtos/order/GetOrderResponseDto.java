package com.dulcenectar.java.dtos.order;

import java.util.List;

import com.dulcenectar.java.dtos.ResponseDto;
import com.dulcenectar.java.models.Order;

public class GetOrderResponseDto implements ResponseDto<Order> {

	public static class OrderItem {
		private Integer productId;
		private long quantity;
		
		public OrderItem(Integer productId, long quantity) {
			super();
			this.productId = productId;
			this.quantity = quantity;
		}
		
		public OrderItem() {}
		
		public Integer getProductId() {
			return productId;
		}
		
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		
		public long getQuantity() {
			return quantity;
		}
		
		public void setQuantity(long quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "OrderItem [productId=" + productId + ", quantity=" + quantity + "]";
		}
		
	}
	
	Integer id;
	Double totalGross;
	List<OrderItem> orderItems;
	
	public GetOrderResponseDto() {
		super();
	}

	@Override
	public ResponseDto<Order> fromEntity(Order entity) {
		
		List<OrderItem> orderItems = entity.getOrderProducts().stream().map((orderProduct) -> {
			OrderItem ot = new OrderItem();
			ot.setProductId(orderProduct.getProduct().getId());
			ot.setQuantity(orderProduct.getQuantity());
			
			return ot;
		}).toList();
		
		this.id = entity.getId();
		this.totalGross = entity.getTotalGross();
		this.orderItems = orderItems;
		
		return this;
	}

	@Override
	public String toString() {
		return "GetOrderReponseDto [id=" + id + ", totalGross=" + totalGross + ", orderItems=" + orderItems + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotalGross() {
		return totalGross;
	}

	public void setTotalGross(Double totalGross) {
		this.totalGross = totalGross;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
