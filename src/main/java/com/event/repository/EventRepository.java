package com.event.repository;

import java.util.List;
import com.event.entities.Event;


public interface EventRepository {
	
	public List<Event> listAllEvent(int user_id,int page,int row,int status);//
	public Event getEventdetail(int event_id);//
	public List<Event> searchEvent(int user_id,int page,int row,int status,String key,int duration);//
	public int createEvent(Event event);//
	public int updateEventName(Event event);//
	public int updateDescriptionEvent(Event event);//
	public int toggleEvent(int event_id);//
	public int deleteEvent(int event_id);
}
