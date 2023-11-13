package com.dulcenectar.java.dtos.product;

import org.hibernate.validator.constraints.URL;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Product;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class UpdateProductRequestDto implements RequestDto<Product> {

  @Size(min = 1, message = "name should not be blank")
  private String name;
  @Size(min = 1, message = "info should not be blank")
  private String info;
  @Positive(message = "gram should be positive")
  private Float gram;
  @URL(message = "imgUrl should be a valid url")
  private String imgUrl;
  @Positive(message = "price should be positive")
  private Double price;
  @PositiveOrZero(message = "stock should be 0 or more")
  private Long stock;
  @Pattern(regexp = "l|g", message = "typeGram can only be l or g")
  private String typeGram;
  @Size(min = 1, message = "category should not be blank")
  private String category;

  // Constructor
  public UpdateProductRequestDto(String name, String info, Float gram, String imgUrl, Double price, Long stock,
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

  // Void constructor
  public UpdateProductRequestDto() {

	}

  // Getters and setters
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
