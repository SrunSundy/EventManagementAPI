package com.event.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.event.entities.Participation;
import com.event.entities.extra.ParticipationSearch;
import com.event.service.ParticipationService;

@Controller
@RequestMapping(value="api/participate")
public class ParticipationRestController {

	
	@Autowired
	ParticipationService partservice;
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> insertParticipation(@RequestBody Participation part){
		
		System.err.println(part);
		int status = partservice.insertParticipation(part);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","INVITED");
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
	@RequestMapping(value="/participation",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> getParticipationFromSearch(@RequestBody ParticipationSearch search){
		List<Participation> participate= partservice.listAndSearchParticipationByUser(search);
		System.err.println(participate);
		Map<String,Object> map= new HashMap<String,Object>();
		
		if(participate == null || participate.isEmpty()){
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "PARTICIPATION NOT FOUND...");
			map.put("RESPONSE_DATA",participate);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "PARTICIPATION HAS BEEN FOUND");
		map.put("RESPONSE_DATA",participate);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/oldpart",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> getOldParticipationFromSearch(@RequestBody ParticipationSearch search){
		List<Participation> participate= partservice.listAndSearchOlderPaticipation(search);
		System.err.println(participate);
		Map<String,Object> map= new HashMap<String,Object>();
		
		if(participate == null || participate.isEmpty()){
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "PARTICIPATION NOT FOUND...");
			map.put("RESPONSE_DATA",participate);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "PARTICIPATION HAS BEEN FOUND");
		map.put("RESPONSE_DATA",participate);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	}
	/*@RequestMapping(value="/oldpartdetail",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> getOldParticipationDetailFromSearch(@RequestBody ParticipationSearch search){
		List<Participation> participate= partservice.listAndSearchOlderPaticipationWithMoreDetail(search);
		System.err.println(participate);
		Map<String,Object> map= new HashMap<String,Object>();
		
		if(participate == null || participate.isEmpty()){
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "PARTICIPATION NOT FOUND...");
			map.put("RESPONSE_DATA",participate);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "PARTICIPATION HAS BEEN FOUND");
		map.put("RESPONSE_DATA",participate);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	}*/
	
	@RequestMapping(value="/participation/{participation_id}",method = RequestMethod.PATCH)
	public ResponseEntity<Map<String,Object>> toggleStatusParticipation(@PathVariable("participation_id") int participation_id){
		System.err.println(participation_id);
		int status = partservice.toggleParticipation(participation_id);
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
	@RequestMapping(value="/participation_detail/{part_detail_id}",method = RequestMethod.PATCH)
	public ResponseEntity<Map<String,Object>> toggleStatusParticipationDetail(@PathVariable("part_detail_id") int part_detail_id){
		System.err.println(part_detail_id);
		int status = partservice.toggleDetail_Participation(part_detail_id);
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
	
	@RequestMapping(value="/khmermoney",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateKhmerMoney(@RequestBody Participation part){
		System.err.println(part);
		int status = partservice.updateKhmerMoneyDetail(part);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","Khmer Money HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATING MONEY FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/dollarmoney",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateDollarMoney(@RequestBody Participation part){
		System.err.println(part);
		int status = partservice.updateDollarMoneyDetail(part);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","Khmer Money HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATING MONEY FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/giftdes",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateGiftDescription(@RequestBody Participation part){
		System.err.println(part);
		int status = partservice.updateGiftDescription(part);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","Khmer Money HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATING MONEY FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/participation_name",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateParticipationName(@RequestBody Participation part){
		System.err.println(part);
		int status = partservice.updateParticipationName(part);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","Khmer Money HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATING MONEY FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/participation_des",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateParticipationDes(@RequestBody Participation part){
		System.err.println(part);
		int status = partservice.updateParticipationDes(part);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","Khmer Money HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATING MONEY FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	
	
	
	
	
}
