package com.model;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "orders")
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private Date order_date;
	private int customer_id;
	private int restaurant_id;
	private int delivery_driver_id;
	private String order_status;
	public Orders(int order_id, Date order_date, int customer_id, int restaurant_id, int delivery_driver_id,
			String order_status) {
		this.order_id = order_id;
		this.order_date = order_date;
		this.customer_id = customer_id;
		this.restaurant_id = restaurant_id;
		this.delivery_driver_id = delivery_driver_id;
		this.order_status = order_status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public int getDelivery_driver_id() {
		return delivery_driver_id;
	}
	public void setDelivery_driver_id(int delivery_driver_id) {
		this.delivery_driver_id = delivery_driver_id;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_date=" + order_date + ", customer_id=" + customer_id
				+ ", restaurant_id=" + restaurant_id + ", delivery_driver_id=" + delivery_driver_id + ", order_status="
				+ order_status + "]";
	}
	
}
