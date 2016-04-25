package com.event.ClassMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.event.entities.Participation;

public class OldParticipationMapper implements RowMapper<Participation>{		
	public Participation mapRow(ResultSet rs, int row) throws SQLException {
		Participation participate = new Participation();
		
		participate.setParticipation_id(rs.getInt("participation_id"));
		participate.setParticipation_name(rs.getString("participation_name"));
		participate.setDescription(rs.getString("description"));
		
		
		return participate;
	}
}