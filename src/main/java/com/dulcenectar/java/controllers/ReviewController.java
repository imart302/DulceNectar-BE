package com.dulcenectar.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulcenectar.java.models.Review;
import com.dulcenectar.java.services.ReviewServiceImpl;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {
	
	@Autowired ReviewServiceImpl reviewService;
	
	@GetMapping
	public ResponseEntity<Object> getReviews(){
		return new ResponseEntity<Object>( reviewService.getReviews() , HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Object> postReview(@RequestBody Review review){
	reviewService.saveReview(review);
	
	return new ResponseEntity<Object>("Review agregada con exito", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> removeReview(@PathVariable Integer id){
		reviewService.deleteReview(id);
		return new ResponseEntity<Object>("La reseña se elimino correctamente", HttpStatus.OK);
	}
}
