package com.dulcenectar.java.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulcenectar.java.dtos.product.CreateProductRequestDto;
import com.dulcenectar.java.dtos.product.CreateProductResponseDto;
import com.dulcenectar.java.services.interfaces.ProductService;



@RestController
@RequestMapping(path = "/product")
public class ProductController {

	private final ProductService productServices;
	
	public ProductController(ProductService productServices) {
		super();
		this.productServices = productServices;
	}

	@GetMapping()
	public ResponseEntity< ArrayList <CreateProductResponseDto>> getProductsList(){
		return new ResponseEntity< ArrayList <CreateProductResponseDto>>(productServices.getProductsList(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<CreateProductResponseDto> createProduct(@RequestBody CreateProductRequestDto productRequest){
		CreateProductResponseDto productRes = productServices.createProduct(productRequest);

		return new ResponseEntity<CreateProductResponseDto>(productRes, HttpStatus.CREATED);
	}
	@PutMapping(path ="/{id}")
	//Aqui va una cosa de PathAvriable
	//Tmabien se recibe un @RequestBody
	public ResponseEntity<CreateProductResponseDto> updateProduct(@PathVariable Integer id, @RequestBody CreateProductRequestDto productModifyRequest){
		CreateProductResponseDto updatedProduct = productServices.updateProduct(id, productModifyRequest);
		return new ResponseEntity<CreateProductResponseDto>(updatedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Integer id){
		productServices.deleteProduct(id);
		return new ResponseEntity<Object>("Succesfully deleted", HttpStatus.OK);
	}
}
