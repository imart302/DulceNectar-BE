package com.dulcenectar.java.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String info;

	private Float gram;
	private String imgUrl;
	private Double price;
	private Long stock;
	private String typeGram;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;
/*
 * Quiza este no se necesie, como mencionaan en la clase, Oder no tiene relacion fundamental con las ordenes, mas que nada User es el que usa las orderPoducts
 * @OneToMany(mappedBy = "Product")
 * Private Set<OrderProducts> orderProduct;
 * 
 */

/*
 * Aqui,  EN el conolador de reviews ya hay un et rEviews, se necesiaia aqui?`
 * El frontEnd no usa ninguna paina que muestre los reviews de un producto, pero tiene una seccion con todas las reviews
 * En esa seccion se haía un filtro
 * @OneToMany(mappedBy = "Product")
 * Private Set<Review> = reviewsList;
 * 
 */


	


	public Product(Integer id, String name, String info, Float gram, String imgUrl, Double price,
			Long stock, String typeGram, LocalDateTime createdAt, LocalDateTime updatedAt, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.gram = gram;
		this.imgUrl = imgUrl;
		this.price = price;
		this.stock = stock;
		this.typeGram = typeGram;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
	}
	
	public Product(Integer id) {
		this.id = id;
	}
	
	public Product() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", info=" + info + ", gram=" + gram
				+ ", imgUrl=" + imgUrl + ", price=" + price + ", stock=" + stock + ", typeGram=" + typeGram
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
