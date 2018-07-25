package com.chrisdyertech.catalog.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain <code>class</code> represents a {@link Product}.
 */
public class Product {
	
	private int productId;
	private int itemNumber;
	private String modelNumber;
	private int vendorNumber;
	private String brand;
	private String name;
	private String description;
	
	private List<Review> reviews;
	
	public Product() {
		reviews = new ArrayList<>();
	}
	
	public Product(int productId, int itemNumber, String modelNumber, int vendorNumber, 
			String brand, String name, String description) {
		super();
		this.productId = productId;
		this.itemNumber = itemNumber;
		this.modelNumber = modelNumber;
		this.vendorNumber = vendorNumber;
		this.brand = brand;
		this.name = name;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getItemNumber() {
		return itemNumber;
	}
	
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public String getModelNumber() {
		return modelNumber;
	}
	
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	
	public int getVendorNumber() {
		return vendorNumber;
	}
	
	public void setVendorNumber(int vendorNumber) {
		this.vendorNumber = vendorNumber;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
