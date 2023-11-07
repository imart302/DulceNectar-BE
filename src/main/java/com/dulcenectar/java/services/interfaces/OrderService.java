package com.dulcenectar.java.services.interfaces;

import java.util.List;

import com.dulcenectar.java.dtos.order.CreateOrderRequestDto;
import com.dulcenectar.java.dtos.order.GetOrderResponseDto;


public interface OrderService {
	public Integer createNewOrder(CreateOrderRequestDto order);
	public List<GetOrderResponseDto> getOrders();
	public String deleteOrder(Integer orderId);
}
