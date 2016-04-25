package com.event.entities.extra;

public class PaidProductSearch {

	private int event_id;
	private int num_page;
	private String pro_name;
	private int row;
	private int status;
	private String key;
	private int duration;
	private float price;
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getNum_page() {
		return num_page;
	}
	public void setNum_page(int num_page) {
		this.num_page = num_page;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	@Override
	public String toString() {
		return "PaidProductSearch [event_id=" + event_id + ", num_page="
				+ num_page + ", pro_name=" + pro_name + ", row=" + row
				+ ", status=" + status + ", key=" + key + ", duration="
				+ duration + ", price=" + price + "]";
	}

	
	
}
