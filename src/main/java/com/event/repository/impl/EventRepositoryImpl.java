package com.event.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.event.ClassMapper.EventMapper;
import com.event.entities.Event;
import com.event.repository.EventRepository;

@Repository
public class EventRepositoryImpl implements EventRepository{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Event> listAllEvent(int user_id,int page,int row,int status) {
		
		if(page<=0) page=1;
		if(row<=0) row=10;
		int offset= (page*row)-row;
		
		String sql="SELECT event_id,event_name,description,create_date,last_modify_date FROM tbl_user_event WHERE user_id=? and status=?"
				+ " ORDER BY event_id LIMIT ? OFFSET ? ";
		return jdbcTemplate.query(sql,new Object[]{user_id,status,row,offset},new EventMapper());
	}

	@Override
	public Event getEventdetail(int event_id) {
		
		String sql="SELECT event_id,event_name,description,create_date,last_modify_date FROM tbl_user_event "
				+ "WHERE event_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{event_id},new EventMapper());
	}

	@Override
	public List<Event> searchEvent(int user_id, int page, int row, int status,
			String key,int duration) {
		
		if(duration <= 0) duration =1000000;
		if(page<=0) page=1;
		if(row<=0) row=10;
		int offset= (page*row)-row;
		
		String sql="SELECT event_id,event_name,description,create_date,last_modify_date FROM tbl_user_event WHERE user_id=? and status=? "
				+ " and (event_name LIKE ? or create_date >= CURRENT_DATE - ( ? || ' days')::interval )ORDER BY event_id "
				+ " LIMIT ? OFFSET ? ";
		return jdbcTemplate.query(sql, new Object[]{user_id,status,"%"+key+"%",duration,row,offset},new EventMapper());
	}
	
	@Override
	public int createEvent(Event event) {
		
		String sql="INSERT INTO tbl_user_event(user_id,event_name,description) "
				+ "VALUES(?,?,?)";
		return jdbcTemplate.update(sql,event.getUser().getUser_id(),event.getEvent_name(),event.getDescription());
	}

	@Override
	public int updateEventName(Event event) {
		
		String sql="UPDATE tbl_user_event SET event_name = ?,last_modify_date=now() WHERE event_id=?";
		return jdbcTemplate.update(sql,event.getEvent_name(),event.getEvent_id());
	}


	@Override
	public int updateDescriptionEvent(Event event) {
		
		String sql="UPDATE tbl_user_event SET description = ?,last_modify_date=now() WHERE event_id=? ";
		return jdbcTemplate.update(sql,event.getDescription(),event.getEvent_id());
	}
	

	@Override
	public int toggleEvent(int event_id) {
		
		String sql="UPDATE tbl_user_event SET status = "
				+ "(SELECT CASE WHEN status=1 THEN 0 ELSE 1 END FROM tbl_user_event WHERE event_id=?),last_modify_date=now() "
				+ "WHERE event_id=?";
		return jdbcTemplate.update(sql,event_id,event_id);
	}

	@Override
	public int deleteEvent(int event_id) {
		
		String sql="DELETE FROM tbl_user_event WHERE event_id = ? ";
		return jdbcTemplate.update(sql,event_id);
	}

	



	


}
