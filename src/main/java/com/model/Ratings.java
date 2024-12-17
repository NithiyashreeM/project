package com.model;

import jakarta.persistence.Entity;

@Entity
public class Ratings {
	private int rating_id;
	private int order_id;
	private int restaurant_id;
	private int rating;
	private String review;
	public Ratings(int rating_id, int order_id, int restaurant_id, int rating, String review) {
		super();
		this.rating_id = rating_id;
		this.order_id = order_id;
		this.restaurant_id = restaurant_id;
		this.rating = rating;
		this.review = review;
	}
	@Override
	public String toString() {
		return "Ratings [rating_id=" + rating_id + ", order_id=" + order_id + ", restaurant_id=" + restaurant_id
				+ ", rating=" + rating + ", review=" + review + "]";
	}
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
}
