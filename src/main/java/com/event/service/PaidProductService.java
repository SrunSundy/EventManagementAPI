package com.event.service;

import java.util.List;

import com.event.entities.PaidProduct;
import com.event.entities.extra.PaidProductSearch;

public interface PaidProductService {
	public List<PaidProduct> listallProduct(int event_id,int page,int row,int status);
	public PaidProduct getProduct(int paid_pro_id);
	public List<PaidProduct> searchProduct(PaidProductSearch search);
	public int insertPaidProduct(PaidProduct pro);
	public int deletePaidProduct(int paid_pro_id);
	public int togglePaidProduct(int paid_pro_id);
	public int updatePaidProName(PaidProduct pro);
	public int updatePaidProPrice(PaidProduct pro);
}
