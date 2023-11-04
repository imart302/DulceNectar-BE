package com.dulcenectar.java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dulcenectar.java.dtos.order.CreateOrderRequestDto;
import com.dulcenectar.java.dtos.order.GetOrderResponseDto;
import com.dulcenectar.java.exceptions.OrderNotFoundException;
import com.dulcenectar.java.models.Order;
import com.dulcenectar.java.models.OrderProducts;
import com.dulcenectar.java.models.Product;
import com.dulcenectar.java.repositories.OrderProductsRepository;
import com.dulcenectar.java.repositories.OrderRepository;
import com.dulcenectar.java.security.UserDetailsImpl;
import com.dulcenectar.java.services.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private final OrderProductsRepository orderProductsRepository;
    
    

    public OrderServiceImpl(OrderRepository orderRepository, OrderProductsRepository orderProductsRepository) {
		super();
		this.orderRepository = orderRepository;
		this.orderProductsRepository = orderProductsRepository;
	}

    public Long createNewOrder(CreateOrderRequestDto order) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl user = (UserDetailsImpl)authentication.getPrincipal();
		
		List<CreateOrderRequestDto.OrderItem> orderItems = order.getOrderItems();
	
		
		Order orderEntity = new Order();
		orderEntity.setUser(user);
		orderEntity.setAddress(order.getAddress());
		orderEntity.setTotalGross(order.getTotalGross());
		
		Order savedOrder = this.orderRepository.save(orderEntity);
		
		List<OrderProducts> orderProductList = orderItems.stream().map((item) -> {
			OrderProducts op = new OrderProducts();
			op.setOrder(savedOrder);
			op.setQuantity(item.getQuantity());
			op.setProduct(new Product(item.getProductId()));
			return op;
		}).toList();
		
		this.orderProductsRepository.saveAll(orderProductList);
		
		return savedOrder.getId();
	}

	public List<GetOrderResponseDto> getOrders() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl user = (UserDetailsImpl)authentication.getPrincipal();
		
		List<Order> orders = this.orderRepository.findAllByUserId(user.getId());
		List<GetOrderResponseDto> orderDtos = orders.stream().map((order) -> {
			GetOrderResponseDto dto = new GetOrderResponseDto();
			dto.fromEntity(order);
			return dto;
		}).toList();
		
		return orderDtos;
	}


	public String deleteOrder(Integer orderId) {

		Optional<Order> order = this.orderRepository.findById(orderId);
		
		if(order.isEmpty()) {
			throw new OrderNotFoundException();
		}
		
		this.orderRepository.delete(order.get());
		
		return "OK";
	}
    // Puedes agregar más métodos según las necesidades de tu aplicación
}
