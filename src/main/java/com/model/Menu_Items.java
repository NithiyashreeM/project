package com.model;

import jakarta.persistence.Entity;

@Entity
public class Menu_Items {
	private int item_id;
	private String item_name;
	private String item_description;
	private float item_price;
	private int restaurant_id;
	public Menu_Items(int item_id, String item_name, String item_description, float item_price, int restaurant_id) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_price = item_price;
		this.restaurant_id = restaurant_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_descrption() {
		return item_description;
	}
	public void setItem_descrption(String item_descrption) {
		this.item_description = item_description;
	}
	public float getItem_price() {
		return item_price;
	}
	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	@Override
	public String toString() {
		return "Menu_Items [item_id=" + item_id + ", item_name=" + item_name + ", item_descrption=" + item_description
				+ ", item_price=" + item_price + ", restaurant_id=" + restaurant_id + "]";
	}
	
}
