package com.event.entities;

import java.sql.Timestamp;

public class PaidProduct {

	private int paid_pro_id;
	private String product_name;
	private float price;
	private Timestamp create_date;
	private Timestamp last_modify_date;
	private int status;
	
	private Event event;
	private User user;
	
	public int getPaid_pro_id() {
		return paid_pro_id;
	}
	public void setPaid_pro_id(int paid_pro_id) {
		this.paid_pro_id = paid_pro_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getLast_modify_date() {
		return last_modify_date;
	}
	public void setLast_modify_date(Timestamp last_modify_date) {
		this.last_modify_date = last_modify_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PaidProduct [paid_pro_id=" + paid_pro_id + ", product_name="
				+ product_name + ", price=" + price + ", create_date="
				+ create_date + ", last_modify_date=" + last_modify_date
				+ ", status=" + status + ", event=" + event + ", user=" + user
				+ "]";
	}
	
	
}
