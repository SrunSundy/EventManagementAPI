package com.event.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.event.entities.Event;
import com.event.entities.extra.EventSearch;
import com.event.service.EventService;

@RestController
@RequestMapping(value="api/event")
public class EventRestController {

	@Autowired
	EventService eventservice;
	
	@RequestMapping(value="/{user_id}/{page}/{row}/{status}",method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listEvents(@PathVariable("user_id") int user_id,@PathVariable("page") int page,@PathVariable("row") int row,
			@PathVariable("status") int status){
		List<Event> event = eventservice.listAllEvent(user_id, page,row,status);
		System.err.println(event);
		Map<String, Object> map = new HashMap<String,Object>();
	
		if(event == null || event.isEmpty()){
			
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "EVENT NOT FOUND...");
			map.put("RESPONSE_DATA",event);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}	
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "EVENT HAS BEEN FOUND");
		map.put("RESPONSE_DATA",event);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	} 
	
	@RequestMapping(value="/detail/{event_id}",method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getEvent(@PathVariable("event_id") int event_id){
		Event event=eventservice.getEventdetail(event_id);
		System.err.println(event);
		Map<String, Object> map = new HashMap<String,Object>();
	
		if(event == null){
			
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "EVENT NOT FOUND...");
			map.put("RESPONSE_DATA",event);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}	
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "EVENT HAS BEEN FOUND");
		map.put("RESPONSE_DATA",event);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	} 
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> getEventFromSearch(@RequestBody EventSearch search){
		List<Event> event= eventservice.searchEvent(1, search.getNum_page(), search.getRow(),
				search.getEvent_status(), search.getKey(), search.getDuration());
		System.err.println(event);
		Map<String,Object> map= new HashMap<String,Object>();
		
		if(event == null || event.isEmpty()){
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "EVENT NOT FOUND...");
			map.put("RESPONSE_DATA",event);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "EVENT HAS BEEN FOUND");
		map.put("RESPONSE_DATA",event);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> createEvent(@RequestBody Event event){
		
		System.err.println(event);
		int status = eventservice.createEvent(event);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","EVENT HAS BEEN CREATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","INSERT FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/event_name",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateEventName(@RequestBody Event event){
		System.err.println(event);
		int status = eventservice.updateEventName(event);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","EVENT NAME HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATE FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/event_des",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateEventDes(@RequestBody Event event){
		System.err.println(event);
		int status = eventservice.updateDescriptionEvent(event);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","EVENT DESCRIPTION HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATE FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/{event_id}",method = RequestMethod.PATCH)
	public ResponseEntity<Map<String,Object>> toggleStatus(@PathVariable("event_id") int event_id){
		System.err.println(event_id);
		int status = eventservice.toggleEvent(event_id);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","STATUS HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATE FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/{event_id}",method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteEvent(@PathVariable("event_id") int event_id){
		System.err.println(event_id);
		int status = eventservice.deleteEvent(event_id);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","EVENT HAS BEEN DELETED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","DELETING FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	
	
	
}
