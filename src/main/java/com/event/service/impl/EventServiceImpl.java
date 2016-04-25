package com.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.entities.Event;
import com.event.repository.EventRepository;
import com.event.service.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	EventRepository eventrepo;
	
	@Override
	public List<Event> listAllEvent(int user_id, int page, int row, int status) {
		// TODO Auto-generated method stub
		return eventrepo.listAllEvent(user_id, page, row, status);
	}
	
	@Override
	public Event getEventdetail(int event_id) {
		// TODO Auto-generated method stub
		return eventrepo.getEventdetail(event_id);
	}

	@Override
	public List<Event> searchEvent(int user_id, int page, int row, int status,
			String key,int duration) {
		// TODO Auto-generated method stub
		return eventrepo.searchEvent(user_id, page, row, status, key , duration);
	}
	
	@Override
	public int createEvent(Event event) {
		// TODO Auto-generated method stub
		return eventrepo.createEvent(event);
	}

	@Override
	public int updateEventName(Event event) {
		// TODO Auto-generated method stub
		return eventrepo.updateEventName(event);
	}
	
	@Override
	public int updateDescriptionEvent(Event event) {
		// TODO Auto-generated method stub
		return eventrepo.updateDescriptionEvent(event);
	}

	@Override
	public int toggleEvent(int event_id) {
		// TODO Auto-generated method stub
		return eventrepo.toggleEvent(event_id);
	}

	@Override
	public int deleteEvent(int event_id) {
		// TODO Auto-generated method stub
		return eventrepo.deleteEvent(event_id);
	}

	



	

}
