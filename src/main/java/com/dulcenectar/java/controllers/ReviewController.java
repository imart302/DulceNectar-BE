package com.dulcenectar.java.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulcenectar.java.dtos.review.CreateReviewDto;
import com.dulcenectar.java.dtos.review.ResponseReviewDto;
import com.dulcenectar.java.dtos.review.UpdateReviewDto;
import com.dulcenectar.java.repositories.ProductRepository;
import com.dulcenectar.java.services.ReviewServiceImpl;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {
	
	@Autowired ReviewServiceImpl reviewService;
	@Autowired ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<ArrayList<ResponseReviewDto>> getReviews(){
		return new ResponseEntity<ArrayList<ResponseReviewDto>>( reviewService.getReviews() ,HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<ResponseReviewDto> postReview(@RequestBody CreateReviewDto review){
		ResponseReviewDto responseDto = reviewService.saveReview(review);
	
	return new ResponseEntity<ResponseReviewDto>(responseDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseReviewDto> removeReview(@PathVariable Integer id){
		ResponseReviewDto responseDto =  reviewService.deleteReview(id);
		
		return new ResponseEntity<ResponseReviewDto>(responseDto, HttpStatus.OK);
	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ResponseReviewDto> putReview(@PathVariable Integer id, @RequestBody UpdateReviewDto review){
		ResponseReviewDto responseDto = reviewService.updateReview(id, review);
		
		return new ResponseEntity<ResponseReviewDto>(responseDto, HttpStatus.OK);
	}
}
