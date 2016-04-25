package com.event.ClassMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.event.entities.Participation;

public class ParticipationMapper implements RowMapper<Participation>{		
	public Participation mapRow(ResultSet rs, int row) throws SQLException {
		Participation participate = new Participation();
		
		participate.setRank(rs.getInt("num"));
		participate.setParticipation_id(rs.getInt("participation_id"));
		participate.setParticipation_name(rs.getString("participation_name"));
		participate.setPart_detail_id(rs.getInt("part_detail_id"));
		participate.setDescription(rs.getString("description"));
		participate.setKhmermoney(rs.getFloat("khmermoney"));
		participate.setDollarmoney(rs.getFloat("dollarmoney"));
		participate.setIshavegift(rs.getBoolean("havegift"));
		participate.setGift_des(rs.getString("gift_description"));
		participate.setCreate_date(rs.getTimestamp("create_date"));
		participate.setLast_modify_date(rs.getTimestamp("last_modify_date"));
		
		return participate;
	}
}
