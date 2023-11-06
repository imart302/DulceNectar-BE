package com.dulcenectar.java.dtos.product;

import java.util.List;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Product;

public class CreateProductRequestDto implements RequestDto <Product>{
	
	private String name;
	private String info;
	private Float gram;
	private String imgUrl;
	private Double price;
	private Long stock;
	private String typeGram;
	private String category;


	//Constructor
	public CreateProductRequestDto(String name, String info, Float gram, String imgUrl, Double price, Long stock,
			String typeGram, String category) {
		super();
		this.name = name;
		this.info = info;
		this.gram = gram;
		this.imgUrl = imgUrl;
		this.price = price;
		this.stock = stock;
		this.typeGram = typeGram;
	}
	
	//Void constructor
	public CreateProductRequestDto() {
		
	}

	//Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Float getGram() {
		return gram;
	}

	public void setGram(Float gram) {
		this.gram = gram;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getTypeGram() {
		return typeGram;
	}

	public void setTypeGram(String typeGram) {
		this.typeGram = typeGram;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public Product toEntity() {
		Product product = new Product();
		product.setName(this.name);
		product.setInfo(this.info);
		product.setGram(this.gram);
		product.setImgUrl(this.imgUrl);
		product.setPrice(this.price);
		product.setStock(this.stock);
		product.setTypeGram(this.typeGram);
		
		return product;
	}
	
}
