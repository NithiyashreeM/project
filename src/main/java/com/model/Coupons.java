package com.model;

import java.sql.Date;

import jakarta.persistence.Entity;
@Entity
public class Coupons {
	private int coupon_id;
	private String coupon_code;
	private float discount_amount;
	private Date expiry_date;
	public Coupons(int coupon_id, String coupon_code, float discount_amount, Date expiry_date) {
		super();
		this.coupon_id = coupon_id;
		this.coupon_code = coupon_code;
		this.discount_amount = discount_amount;
		this.expiry_date = expiry_date;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}
	public float getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(float discount_amount) {
		this.discount_amount = discount_amount;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	@Override
	public String toString() {
		return "coupons [coupon_id=" + coupon_id + ", coupon_code=" + coupon_code + ", discount_amount="
				+ discount_amount + ", expiry_date=" + expiry_date + "]";
	}
	
	
}
