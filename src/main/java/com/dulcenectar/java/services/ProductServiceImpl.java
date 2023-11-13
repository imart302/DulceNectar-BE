package com.dulcenectar.java.services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dulcenectar.java.dtos.product.CreateProductRequestDto;
import com.dulcenectar.java.dtos.product.CreateProductResponseDto;
import com.dulcenectar.java.exceptions.CategoryNotFoundException;
import com.dulcenectar.java.exceptions.ProductNotFoundException;
import com.dulcenectar.java.models.Category;
import com.dulcenectar.java.models.Product;
import com.dulcenectar.java.repositories.ProductRepository;
import com.dulcenectar.java.services.interfaces.ProductService;
import com.dulcenectar.java.repositories.CategoryRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository ) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	

	@Override
	public CreateProductResponseDto createProduct(CreateProductRequestDto product) {
		
		Optional<Category> category = this.categoryRepository.findByName(product.getCategory());
		category.orElseThrow(() -> new CategoryNotFoundException());
		Product newProduct = product.toEntity();
		newProduct.setCategory(category.get());
		newProduct = this.productRepository.save(newProduct);
		CreateProductResponseDto productResponse = new CreateProductResponseDto();
		productResponse.fromEntity(newProduct);
		return productResponse;
	}

	@Override
	public ArrayList<CreateProductResponseDto> getProductsList() {
		ArrayList<Product> productList = (ArrayList<Product>) productRepository.findAll();
		ArrayList<CreateProductResponseDto> productListResponse = (ArrayList<CreateProductResponseDto>) productList.stream()
				.map(product -> new CreateProductResponseDto().fromEntity(product))
				.collect(Collectors.toList());  	
		return productListResponse;
	}

	@Override
	public CreateProductResponseDto updateProduct(Integer id, CreateProductRequestDto productModifyRequest) {
		Optional <Product> productFromDB = productRepository.findById(id);
		productFromDB.orElseThrow(() -> new ProductNotFoundException());
		
		Product productInfo = productFromDB.get();
		
		if(productModifyRequest.getCategory() !=  null) {
			Optional<Category> category = this.categoryRepository.findByName(productModifyRequest.getCategory());
			category.orElseThrow(() -> new CategoryNotFoundException());
			productInfo.setCategory(category.get());
		}
		
		if(productModifyRequest.getName() != null) productInfo.setName(productModifyRequest.getName());
		if(productModifyRequest.getInfo() != null) productInfo.setInfo(productModifyRequest.getInfo());
		if(productModifyRequest.getGram() != null) productInfo.setGram(productModifyRequest.getGram());
		if(productModifyRequest.getImgUrl() != null) productInfo.setImgUrl(productModifyRequest.getImgUrl());
		if(productModifyRequest.getPrice() != null) productInfo.setPrice(productModifyRequest.getPrice());
		if(productModifyRequest.getStock() != null) productInfo.setStock(productModifyRequest.getStock());
		if(productModifyRequest.getTypeGram() != null) productInfo.setTypeGram(productModifyRequest.getTypeGram());
		
		productRepository.save(productInfo);  
		
		CreateProductResponseDto updatedProduct = new CreateProductResponseDto().fromEntity(productInfo);
		
		return updatedProduct;
	}

	@Override
	public void deleteProduct(Integer id) {
		Optional <Product> productFromDB = productRepository.findById(id);
		productFromDB.orElseThrow(() -> new ProductNotFoundException());
		
		productRepository.deleteById(id);
		;
	}
	
}


