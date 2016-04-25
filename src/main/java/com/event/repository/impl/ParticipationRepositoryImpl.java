package com.event.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.event.ClassMapper.OldParticipationMapper;
import com.event.ClassMapper.ParticipationMapper;
import com.event.entities.Participation;
import com.event.entities.extra.ParticipationSearch;
import com.event.repository.ParticipationRepository;

@Repository
public class ParticipationRepositoryImpl implements ParticipationRepository{

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Participation> listAndSearchParticipationByUser(
			ParticipationSearch part) {
		// TODO Auto-generated method stub
		int page= part.getNum_page();
		int row=part.getRow();
		if(page<=0)page=1;
		if(row<=0)row=10;
		int limit= (row*page)-row;
		
		String sql="SELECT row_number() OVER (ORDER BY tpd.part_detail_id) as num,tp.participation_id"
				+ ",tp.participation_name"
				+ ",tpd.part_detail_id,tp.description,tpd.khmermoney,tpd.dollarmoney,"
				+ "tpd.havegift,tpd.gift_description,tpd.create_date,tpd.last_modify_date "
				+ "FROM tbl_participation tp "
				+ "INNER JOIN tbl_part_detail tpd "
				+ "ON tp.participation_id=tpd.participation_id "
				+ "WHERE tpd.event_id=? AND tp.participation_name LIKE ? AND tpd.status=? "
				+ "ORDER BY tpd.part_detail_id "
				+ "LIMIT ? OFFSET ? ";
		
		return jdbcTemplate.query(sql, new Object[]{part.getEvent_id(),"%"+part.getParticipation_name()+"%",
				part.getStatus(),row,limit},new ParticipationMapper());
	}

	@Override
	public List<Participation> listAndSearchOlderPaticipation(ParticipationSearch part) {
		// TODO Auto-generated method stub
		int page=part.getNum_page();
		int row= part.getRow();
		if(page<=0)page=1;
		if(row<=0)row=10;
		int offset =(page*row)-row;
		
		String sql="SELECT participation_id,participation_name,description "
				+ "FROM tbl_participation "
				+ "WHERE status=? AND user_id=? AND participation_name LIKE ? "
				+ "ORDER BY participation_id "
				+ "LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, new Object[]{part.getStatus(),part.getUser().getUser_id()
				,"%"+part.getParticipation_name()+"%",row,offset}
		,new OldParticipationMapper());
	}

	/*@Override
	public List<Participation> listAndSearchOlderPaticipationWithMoreDetail(
			ParticipationSearch part) {
		// TODO Auto-generated method stub
		int page= part.getNum_page();
		int row=part.getRow();
		if(page<=0)page=1;
		if(row<=0)row=10;
		int limit= (row*page)-row;
		
		String sql="SELECT * "
				+ "FROM ( "
				+ "SELECT  row_number() OVER (ORDER BY tp.participation_id) AS num,"
				+ "tp.participation_id, "
				+ "tp.participation_name, "
				+ "tp.description,"
				+ "tpd.part_detail_id, "
				+ "tpd.create_date,"
				+ "tpd.last_modify_date,"
				+ "row_number() OVER (PARTITION BY tp.participation_id ORDER BY tp.participation_id DESC) as rn "
				+ "FROM tbl_participation tp INNER JOIN tbl_part_detail tpd "
				+ "ON tp.participation_id=tpd.participation_id "
				+ "WHERE tp.user_id=? and tp.status=? AND tp.participation_name LIKE ? "
				+ "ORDER BY participation_id "
				+ "LIMIT ? OFFSET ?"
				+ ") a WHERE rn = 1";
		
		return jdbcTemplate.query(sql, new Object[]{part.getUser().getUser_id(),part.getStatus()
				,"%"+part.getParticipation_name()+"%",
				row,limit},new ParticipationMapper());
	}*/
	public boolean checkDataByUser(String part_name,int user_id){
		String sql="SELECT COUNT(*) FROM tbl_participation WHERE participation_name=? AND user_id=?";
		int status = jdbcTemplate.queryForObject(sql,new Object[]{ part_name,user_id},Integer.class);
		if(status >=1 ) return true;
		return false;
	}

	@Override
	public int insertParticipation(Participation part) {
		// TODO Auto-generated method stub
		String part_name=part.getParticipation_name();
		int user_id=part.getUser().getUser_id();
		int event_id=part.getEvent().getEvent_id();
		String sql="";
		if(checkDataByUser(part_name,user_id)){
			sql="INSERT INTO tbl_part_detail(participation_id,event_id,khmermoney,dollarmoney"
					+ ",havegift,gift_description) "
					+ "SELECT (SELECT participation_id FROM tbl_participation "
					+ "WHERE participation_name=? and user_id=?),?,?,?,?,?"
					+ "WHERE not exists (SELECT * FROM tbl_part_detail "
					+ "WHERE participation_id =( SELECT participation_id FROM tbl_participation "
					+ "WHERE participation_name=? and user_id=?) and event_id = ?)";
			return jdbcTemplate.update(sql,part_name,user_id,event_id
					,part.getKhmermoney(),part.getDollarmoney(),part.isIshavegift(),
					part.getGift_des(),part_name,user_id,event_id);
			
		}else{
			sql="INSERT INTO tbl_participation(participation_name,description,user_id) VALUES(?,?,?); "
					+ "INSERT INTO tbl_part_detail(participation_id,event_id,khmermoney,dollarmoney"
					+ ",havegift,gift_description) "
					+ "VALUES((SELECT participation_id FROM tbl_participation"
					+ " WHERE participation_name=? and user_id=?),?,?,?,?,?); ";
			return jdbcTemplate.update(sql,part_name,part.getDescription(),user_id,part_name,user_id,
					event_id,part.getKhmermoney(),part.getDollarmoney(),part.isIshavegift(),
					part.getGift_des());
		}
	}

	@Override
	public int[] insertBatchParticipation(ArrayList<Participation> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int toggleParticipation(int participation_id) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_participation SET status ="
				+ "(SELECT CASE WHEN status=1 THEN 0 ELSE 1 END FROM tbl_participation WHERE participation_id=?) "
				+ "WHERE participation_id=?";
		return jdbcTemplate.update(sql,participation_id,participation_id);
	}

	@Override
	public int toggleDetail_Participation(int part_detail_id) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_part_detail SET status ="
				+ "(SELECT CASE WHEN status=1 THEN 0 ELSE 1 END FROM tbl_part_detail WHERE part_detail_id=?) "
				+ "WHERE part_detail_id=?";
		return jdbcTemplate.update(sql,part_detail_id,part_detail_id);
	}

	@Override
	public int updateKhmerMoneyDetail(Participation part) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_part_detail "
				+ "SET khmermoney = ? "
				+ "WHERE part_detail_id=?";
		return jdbcTemplate.update(sql,part.getKhmermoney(),part.getPart_detail_id());
	}

	@Override
	public int updateDollarMoneyDetail(Participation part) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_part_detail "
				+ "SET dollarmoney = ? "
				+ "WHERE part_detail_id=?";
		return jdbcTemplate.update(sql,part.getDollarmoney(),part.getPart_detail_id());
	}

	@Override
	public int updateIsGift(int part_detail_id) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_part_detail SET havegift ="
				+ "(SELECT CASE WHEN havegift=true THEN false ELSE true END FROM tbl_part_detail WHERE part_detail_id=?) "
				+ "WHERE part_detail_id=?";
		return jdbcTemplate.update(sql,part_detail_id,part_detail_id);
	}

	@Override
	public int updateGiftDescription(Participation part) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_part_detail "
				+ "SET gift_description = ? "
				+ "WHERE part_detail_id=?";
		return jdbcTemplate.update(sql,part.getGift_des(),part.getPart_detail_id());
	}

	@Override
	public int updateParticipationName(Participation part) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_participation "
				+ "SET participation_name = ? "
				+ "WHERE participation_id=?";
		return jdbcTemplate.update(sql,part.getParticipation_name(),part.getParticipation_id());
	}

	@Override
	public int updateParticipationDes(Participation part) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_participation "
				+ "SET description = ? "
				+ "WHERE participation_id=?";
		return jdbcTemplate.update(sql,part.getDescription(),part.getParticipation_id());
	}

	
}
