package com.model;

import jakarta.persistence.Entity;

@Entity
public class Delivery_Drivers {
	private int driver_id;
	private String driver_name;
	private String driver_phone;
	private String driver_vehicle;
	public Delivery_Drivers(int driver_id, String driver_name, String driver_phone, String driver_vehicle) {
		super();
		this.driver_id = driver_id;
		this.driver_name = driver_name;
		this.driver_phone = driver_phone;
		this.driver_vehicle = driver_vehicle;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public String getDriver_phone() {
		return driver_phone;
	}
	public void setDriver_phone(String driver_phone) {
		this.driver_phone = driver_phone;
	}
	public String getDriver_vehicle() {
		return driver_vehicle;
	}
	public void setDriver_vehicle(String driver_vehicle) {
		this.driver_vehicle = driver_vehicle;
	}
	@Override
	public String toString() {
		return "deliverydrivers [driver_id=" + driver_id + ", driver_name=" + driver_name + ", driver_phone="
				+ driver_phone + ", driver_vehicle=" + driver_vehicle + "]";
	}
	
}
