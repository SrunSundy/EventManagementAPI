package com.event.entities;

import java.sql.Timestamp;
import java.util.Date;

public class User {

	private int user_id;
	private String user_name;
	private String email;
	private String gender;
	private Date birth_date;
	private String current_address;
	private Timestamp create_date;
	private Timestamp last_modify_date;
	private int status;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getCurrent_address() {
		return current_address;
	}
	public void setCurrent_address(String current_address) {
		this.current_address = current_address;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getLast_modify_date() {
		return last_modify_date;
	}
	public void setLast_modify_date(Timestamp last_modify_date) {
		this.last_modify_date = last_modify_date;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name
				+ ", email=" + email + ", gender=" + gender + ", birth_date="
				+ birth_date + ", current_address=" + current_address
				+ ", create_date=" + create_date + ", last_modify_date="
				+ last_modify_date + ", status=" + status + "]";
	}

	
	
	
}
