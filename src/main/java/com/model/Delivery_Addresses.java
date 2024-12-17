package com.model;

import jakarta.persistence.Entity;

@Entity
public class Delivery_Addresses {
private int address_id;
private int customer_id;
private String address_line1;
private String address_line2;
private String city;
private String state;
private String postal_code;
public Delivery_Addresses(int address_id, int customer_id, String address_line1, String address_line2, String city,
		String state, String postal_code) {
	super();
	this.address_id = address_id;
	this.customer_id = customer_id;
	this.address_line1 = address_line1;
	this.address_line2 = address_line2;
	this.city = city;
	this.state = state;
	this.postal_code = postal_code;
}
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getAddress_line1() {
	return address_line1;
}
public void setAddress_line1(String address_line1) {
	this.address_line1 = address_line1;
}
public String getAddress_line2() {
	return address_line2;
}
public void setAddress_line2(String address_line2) {
	this.address_line2 = address_line2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPostal_code() {
	return postal_code;
}
public void setPostal_code(String postal_code) {
	this.postal_code = postal_code;
}
@Override
public String toString() {
	return "Delivery_Addresses [address_id=" + address_id + ", customer_id=" + customer_id + ", address_line1="
			+ address_line1 + ", address_line2=" + address_line2 + ", city=" + city + ", state=" + state
			+ ", postal_code=" + postal_code + "]";
}


}
