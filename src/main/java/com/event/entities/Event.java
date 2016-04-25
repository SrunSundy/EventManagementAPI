package com.event.entities;

import java.sql.Timestamp;

public class Event {

	private int event_id;
	private String event_name;
	private String description;
	private Timestamp create_date;
	private Timestamp last_modify_date;
	private int status;
	
	private User user;

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public Timestamp getLast_modify_date() {
		return last_modify_date;
	}

	public void setLast_modify_date(Timestamp last_modify_date) {
		this.last_modify_date = last_modify_date;
	}

	@Override
	public String toString() {
		return "Event [event_id=" + event_id + ", event_name=" + event_name
				+ ", description=" + description + ", create_date="
				+ create_date + ", last_modify_date=" + last_modify_date
				+ ", status=" + status + ", user=" + user + "]";
	}

	
	
}
