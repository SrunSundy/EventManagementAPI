package com.event.entities;

import java.sql.Timestamp;

public class Participation {

	private int participation_id;
	private String participation_name;
	private String description;
	private int participation_status;
	
	private int rank;
	private int part_detail_id;
	private User user;
	private Event event;
	private Float khmermoney;
	private Float dollarmoney;
	private boolean ishavegift;
	private String gift_des;
	private Timestamp create_date;
	private Timestamp last_modify_date;
	private int part_status;
	
	
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getParticipation_id() {
		return participation_id;
	}
	public void setParticipation_id(int participation_id) {
		this.participation_id = participation_id;
	}
	public String getParticipation_name() {
		return participation_name;
	}
	public void setParticipation_name(String participation_name) {
		this.participation_name = participation_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParticipation_status() {
		return participation_status;
	}
	public void setParticipation_status(int participation_status) {
		this.participation_status = participation_status;
	}
	public int getPart_detail_id() {
		return part_detail_id;
	}
	public void setPart_detail_id(int part_detail_id) {
		this.part_detail_id = part_detail_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Float getKhmermoney() {
		return khmermoney;
	}
	public void setKhmermoney(Float khmermoney) {
		this.khmermoney = khmermoney;
	}
	public Float getDollarmoney() {
		return dollarmoney;
	}
	public void setDollarmoney(Float dollarmoney) {
		this.dollarmoney = dollarmoney;
	}
	public boolean isIshavegift() {
		return ishavegift;
	}
	public void setIshavegift(boolean ishavegift) {
		this.ishavegift = ishavegift;
	}
	public String getGift_des() {
		return gift_des;
	}
	public void setGift_des(String gift_des) {
		this.gift_des = gift_des;
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
	public int getPart_status() {
		return part_status;
	}
	public void setPart_status(int part_status) {
		this.part_status = part_status;
	}
	@Override
	public String toString() {
		return "Participation [participation_id=" + participation_id
				+ ", participation_name=" + participation_name
				+ ", description=" + description + ", participation_status="
				+ participation_status + ", rank=" + rank + ", part_detail_id="
				+ part_detail_id + ", user=" + user + ", event=" + event
				+ ", khmermoney=" + khmermoney + ", dollarmoney=" + dollarmoney
				+ ", ishavegift=" + ishavegift + ", gift_des=" + gift_des
				+ ", create_date=" + create_date + ", last_modify_date="
				+ last_modify_date + ", part_status=" + part_status + "]";
	}
	
	
}
