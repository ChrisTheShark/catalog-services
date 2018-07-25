package com.chrisdyertech.catalog.domain;

/**
 * Domain <code>class</code> represents a {@link Review}.
 */
public class Review {
	
	private int id;
	private int userId;
    private int productId;
	private double rating;
	private String comment;
	
	public Review() {}

	public Review(int userId, int productId, double rating, String comment) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
