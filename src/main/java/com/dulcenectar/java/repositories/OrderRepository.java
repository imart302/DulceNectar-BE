package com.dulcenectar.java.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dulcenectar.java.models.Order;


public interface OrderRepository extends CrudRepository <Order, Integer> {

}
