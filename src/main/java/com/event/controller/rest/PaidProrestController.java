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


import com.event.entities.PaidProduct;
import com.event.entities.extra.PaidProductSearch;
import com.event.repository.PaidProRepository;

@RestController
@RequestMapping(value="api/product")
public class PaidProrestController {

	@Autowired
	PaidProRepository paidprorepo;
	
	@RequestMapping(value="/{event_id}/{page}/{row}/{status}")
	public ResponseEntity<Map<String,Object>> listExpense(@PathVariable("event_id") int event_id,@PathVariable("page") int page,@PathVariable("row") int row,
			@PathVariable("status") int status){
		List<PaidProduct> expense = paidprorepo.listallProduct(event_id, page, row, status);
		System.err.println(expense);
		Map<String, Object> map = new HashMap<String,Object>();
	
		if(expense == null || expense.isEmpty()){
			
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "EXPENSE NOT FOUND...");
			map.put("RESPONSE_DATA",expense);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}	
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "EXPENSE HAS BEEN FOUND");
		map.put("RESPONSE_DATA",expense);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	} 
	
	@RequestMapping(value="/detail/{paid_pro_id}",method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getProduct(@PathVariable("paid_pro_id") int paid_pro_id){
		PaidProduct expense=paidprorepo.getProduct(paid_pro_id);
		System.err.println(expense);
		Map<String, Object> map = new HashMap<String,Object>();
	
		if(expense == null){
			
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "EXPENSE NOT FOUND...");
			map.put("RESPONSE_DATA",expense);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}	
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "EXPENSE HAS BEEN FOUND");
		map.put("RESPONSE_DATA",expense);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	} 
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> getExpenseFromSearch(@RequestBody PaidProductSearch search){
		List<PaidProduct> products= paidprorepo.searchProduct(search);
		System.err.println(products);
		Map<String,Object> map= new HashMap<String,Object>();
		
		if(products == null || products.isEmpty()){
			map.put("STATUS", HttpStatus.OK.value());
			map.put("MESSAGE", "EXPENSE NOT FOUND...");
			map.put("RESPONSE_DATA",products);
			
			return new ResponseEntity<Map<String,Object>>
							(map,HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.OK.value());
		map.put("MESSAGE", "EXPENSE HAS BEEN FOUND");
		map.put("RESPONSE_DATA",products);
		
		return new ResponseEntity<Map<String,Object>>
									(map,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> insertExpense(@RequestBody PaidProduct product){
		
		System.err.println(product);
		int status = paidprorepo.insertPaidProduct(product);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","PRODUCT HAS BEEN CREATED.");
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
	
	@RequestMapping(value="/{paid_pro_id}",method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteExpense(@PathVariable("paid_pro_id") int paid_pro_id){
		System.err.println(paid_pro_id);
		int status = paidprorepo.deletePaidProduct(paid_pro_id);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","PRODUCT HAS BEEN DELETED.");
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
	
	@RequestMapping(value="/{paid_pro_id}",method = RequestMethod.PATCH)
	public ResponseEntity<Map<String,Object>> toggleStatus(@PathVariable("paid_pro_id") int paid_pro_id){
		System.err.println(paid_pro_id);
		int status = paidprorepo.togglePaidProduct(paid_pro_id);
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
	
	@RequestMapping(value="/pro_name",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateProductName(@RequestBody PaidProduct product){
		System.err.println(product);
		int status = paidprorepo.updatePaidProName(product);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","PRODUCT NAME HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATING PRODUCT FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/pro_price",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateProductPrice(@RequestBody PaidProduct product){
		System.err.println(product);
		int status = paidprorepo.updatePaidProPrice(product);
		System.err.println(status);
		Map<String,Object> map= new HashMap<String,Object>();
		if(status > 0){			
			map.put("MESSAGE","PRODUCT PRICE HAS BEEN UPDATED.");
			map.put("STATUS", HttpStatus.OK.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}else{
			map.put("MESSAGE","UPDATING PRODUCT FAILS.");
			map.put("STATUS", HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Map<String,Object>>
								(map, HttpStatus.OK);
		}
	}
	
	
	
}
