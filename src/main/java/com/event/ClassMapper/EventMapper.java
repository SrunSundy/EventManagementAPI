package com.event.ClassMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.event.entities.Event;

public class EventMapper implements RowMapper<Event>{		
	public Event mapRow(ResultSet rs, int row) throws SQLException {
		Event event = new Event();
		
		event.setEvent_id(rs.getInt("event_id"));
		event.setEvent_name(rs.getString("event_name"));
		event.setDescription(rs.getString("description"));
		event.setCreate_date(rs.getTimestamp("create_date"));
		event.setLast_modify_date(rs.getTimestamp("last_modify_date"));
		
		return event;
	}
}