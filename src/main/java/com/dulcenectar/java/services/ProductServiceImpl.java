package com.dulcenectar.java.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dulcenectar.java.dtos.product.CreateProductRequestDto;
import com.dulcenectar.java.dtos.product.CreateProductResponseDto;
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
	
	//Validar que el url de la imagen sea valido 
	

	@Override
	public CreateProductResponseDto createProduct(CreateProductRequestDto product) {
		
		Optional<Category> category = this.categoryRepository.findByName(product.getCategory());
		category.orElseThrow(() -> new NoSuchElementException("Esta Categoría no se encuentra"));
		//if (category.isEmpty()) throw 
		//new CategoryNotFoundException();
		//Validar que la categoria exista y si no, lanzar una excepcion (Crear Excepcion CategoryNotFoundExeption)
		Product newProduct = product.toEntity();
		newProduct.setCategory(category.get());
		newProduct = this.productRepository.save(newProduct);
		CreateProductResponseDto productResponse = new CreateProductResponseDto();
		productResponse.fromEntity(newProduct);
		return productResponse;
	}
}
