package com.event.entities.extra;

import com.event.entities.User;

public class ParticipationSearch {

	
	private int num_page;
	private int event_id;
	private int status;
	private int row;
	private User user;
	private String participation_name;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public String getParticipation_name() {
		return participation_name;
	}
	public void setParticipation_name(String participation_name) {
		this.participation_name = participation_name;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ParticipationSearch [num_page=" + num_page + ", event_id="
				+ event_id + ", status=" + status + ", row=" + row + ", user="
				+ user + ", participation_name=" + participation_name + "]";
	}
	
	
}
