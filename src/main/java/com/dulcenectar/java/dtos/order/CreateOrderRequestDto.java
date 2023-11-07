package com.dulcenectar.java.dtos.order;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Order;

import java.util.List;


public class CreateOrderRequestDto implements RequestDto<Order> {
	

	public static class OrderItem {
		private Integer productId;
		private Integer quantity;
		
		public OrderItem(Integer productId, Integer quantity) {
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
		
		public Integer getQuantity() {
			return quantity;
		}
		
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		
	}

	private Float totalGross;
	private String address;
	private List<OrderItem> orderItems;

	public CreateOrderRequestDto(Float totalGross, String address, List<OrderItem> orderItems) {
		super();
		this.totalGross = totalGross;
		this.address = address;
		this.orderItems = orderItems;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public CreateOrderRequestDto(){
		super();
	}
	
    public Float getTotalGross() {
        return totalGross;
    }

    public void setTotalGross(Float totalGross) {
        this.totalGross = totalGross;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Order toEntity() {
        Order order = new Order();
        order.setTotalGross(this.totalGross);
        order.setAddress(this.address);
        return order;
    }

}
