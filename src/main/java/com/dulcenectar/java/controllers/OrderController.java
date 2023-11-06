package com.dulcenectar.java.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.dulcenectar.java.dtos.order.CreateOrderRequestDto;
import com.dulcenectar.java.dtos.order.GetOrderResponseDto;
import com.dulcenectar.java.services.interfaces.OrderService;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
	
	private final OrderService orderService;
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<Long> createOrder(@RequestBody CreateOrderRequestDto orderRequest) {
		Long id = this.orderService.createNewOrder(orderRequest);
		
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<GetOrderResponseDto>> getAllOrders(){
		List<GetOrderResponseDto> orderList = this.orderService.getOrders();
		
		return new ResponseEntity<List<GetOrderResponseDto>>(orderList, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable(name = "id") Integer id){
		String res = this.orderService.deleteOrder(id);
		
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
    // Otros métodos del controlador

}
