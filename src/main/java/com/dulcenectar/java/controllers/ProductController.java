package com.dulcenectar.java.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/product")
public class ProductController {

	
	@GetMapping()
	public ResponseEntity<Object> getAllProducts(){
		return new ResponseEntity<Object>("Everyone should see products", HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> createProduct(){
		return new ResponseEntity<Object>("If you can see this, you are ADMIN", HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Object> updateProduct(){
		return new ResponseEntity<Object>("If you can see this, you are ADMIN", HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<Object> deleteProduct(){
		return new ResponseEntity<Object>("If you can see this, you are ADMIN", HttpStatus.OK);
	}
}
