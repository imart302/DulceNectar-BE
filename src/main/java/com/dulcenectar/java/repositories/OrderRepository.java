package com.dulcenectar.java.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dulcenectar.java.models.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	List<Order> findAllByUserId(Integer userId);
	boolean existsById(Long orderId);
    // Puedes agregar consultas personalizadas si es necesario
}
