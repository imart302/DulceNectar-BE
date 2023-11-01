package com.dulcenectar.java.dtos.product;

import com.dulcenectar.java.dtos.ResponseDto;
import com.dulcenectar.java.models.Product;

public class CreateProductResponseDto implements ResponseDto<Product> {

	private long id;
	private String name;
	private String info;
	private Float gram;
	private String imgUrl;
	private Double price;
	private Long stock;
	private String typeGram;
	//Necesitaremos devolver las fechas de creacion/modificacion?
	
	//Constructor
	public CreateProductResponseDto(long id, String name, String info, Float gram, String imgUrl, Double price,
			Long stock, String typeGram) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.gram = gram;
		this.imgUrl = imgUrl;
		this.price = price;
		this.stock = stock;
		this.typeGram = typeGram;
	}
	
	//Void Constructor
	public CreateProductResponseDto() {
		
	}
	
	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
	
	@Override
	public CreateProductResponseDto fromEntity(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.info = entity.getInfo();
		this.gram = entity.getGram();
		this.imgUrl = entity.getImgUrl();
		this.price = entity.getPrice();
		this.stock = entity.getStock();
		this.typeGram = entity.getTypeGram();
		
		return this;
	}
	
	
	
	
	
	
	
}
