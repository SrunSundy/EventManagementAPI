package com.event.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.event.ClassMapper.PaidProMapper;
import com.event.entities.PaidProduct;
import com.event.entities.extra.PaidProductSearch;
import com.event.repository.PaidProRepository;

@Repository
public class PaidProRepositoryImpl implements PaidProRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PaidProduct> listallProduct(int event_id, int page, int row,
			int status) {
		if(page<=0) page=1;
		if(row<=0) row=10;
		int offset= (page*row)-row;
		// TODO Auto-generated method stub
		String sql="SELECT paid_pro_id,product_name,price,create_date,last_modify_date "
				+ "FROM tbl_paid_product WHERE status=? and event_id=? "
				+ "ORDER BY paid_pro_id LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, new Object[]{status,event_id,row,offset},new PaidProMapper());
	}

	@Override
	public PaidProduct getProduct(int paid_pro_id) {
		// TODO Auto-generated method stub
		String sql="SELECT paid_pro_id,product_name,price,create_date,last_modify_date "
				+ "FROM tbl_paid_product WHERE paid_pro_id=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{paid_pro_id},new PaidProMapper());
	}

	@Override
	public List<PaidProduct> searchProduct(PaidProductSearch search) {
		// TODO Auto-generated method stub
		int page = search.getNum_page();
		int row = search.getRow();
		if(page<=0) page=1;
		if(row<=0) row=10;
		int offset= (page*row)-row;
		String sql="SELECT paid_pro_id,product_name,price,create_date,last_modify_date "
				+ "FROM tbl_paid_product WHERE status=? and event_id=? and (product_name LIKE ? or price <= ?) "
				+ "ORDER BY paid_pro_id LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, new Object[]{search.getStatus(),search.getEvent_id()
				,search.getPro_name(),search.getPrice(),row,offset},new PaidProMapper());
	}

	@Override
	public int insertPaidProduct(PaidProduct pro) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tbl_paid_product(user_id,event_id,product_name,price) "
				+ "VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql,pro.getUser().getUser_id(),pro.getEvent().getEvent_id()
				,pro.getProduct_name(),pro.getPrice());
	}

	@Override
	public int deletePaidProduct(int paid_pro_id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tbl_paid_product WHERE paid_pro_id=?";
		return jdbcTemplate.update(sql,paid_pro_id);
	}

	@Override
	public int togglePaidProduct(int paid_pro_id) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_paid_product SET status = "
				+ "(SELECT CASE WHEN status=1 THEN 0 ELSE 1 END FROM tbl_paid_product WHERE paid_pro_id=?),last_modify_date=now() "
				+ "WHERE paid_pro_id=?";
		return jdbcTemplate.update(sql,paid_pro_id,paid_pro_id);
	}

	@Override
	public int updatePaidProName(PaidProduct pro) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_paid_product SET product_name= ? , last_modify_date = now() WHERE paid_pro_id=?";
		return jdbcTemplate.update(sql,pro.getProduct_name(),pro.getPaid_pro_id());
	}

	@Override
	public int updatePaidProPrice(PaidProduct pro) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_paid_product SET price= ? , last_modify_date = now() WHERE paid_pro_id=?";
		return jdbcTemplate.update(sql,pro.getPrice(),pro.getPaid_pro_id());
	}

}
