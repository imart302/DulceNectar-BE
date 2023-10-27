package com.dulcenectar.java.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dulcenectar.java.models.OrderProducts;


public interface OrderProductsRepository extends CrudRepository <OrderProducts, Integer> {

}

