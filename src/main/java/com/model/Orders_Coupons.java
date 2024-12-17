package com.model;

import jakarta.persistence.Entity;

@Entity
public class Orders_Coupons {
private int order_id;
private int coupoun_id;
public Orders_Coupons(int order_id, int coupoun_id) {
	super();
	this.order_id = order_id;
	this.coupoun_id = coupoun_id;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public int getCoupoun_id() {
	return coupoun_id;
}
public void setCoupoun_id(int coupoun_id) {
	this.coupoun_id = coupoun_id;
}
@Override
public String toString() {
	return "Orders_Coupons [order_id=" + order_id + ", coupoun_id=" + coupoun_id + "]";
}

}
