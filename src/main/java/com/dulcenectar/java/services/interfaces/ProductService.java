package com.dulcenectar.java.services.interfaces;

import java.util.ArrayList;

import com.dulcenectar.java.dtos.product.*;

 public interface ProductService {
	public CreateProductResponseDto createProduct(CreateProductRequestDto product);
	public ArrayList <CreateProductResponseDto> getProductsList();
	public CreateProductResponseDto updateProduct(Integer id, CreateProductRequestDto productModifyRequest);
	public void deleteProduct(Integer id);
	
	

}
