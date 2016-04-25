package com.event.ClassMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.event.entities.PaidProduct;

public class PaidProMapper implements RowMapper<PaidProduct>{		
	public PaidProduct mapRow(ResultSet rs, int row) throws SQLException {
		PaidProduct product = new PaidProduct();
		
		product.setPaid_pro_id(rs.getInt("paid_pro_id"));
		product.setProduct_name(rs.getString("product_name"));
		product.setPrice(rs.getFloat("price"));
		product.setCreate_date(rs.getTimestamp("create_date"));
		product.setLast_modify_date(rs.getTimestamp("last_modify_date"));
		
		return product;
	}
}
