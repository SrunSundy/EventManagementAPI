package com.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.entities.PaidProduct;
import com.event.entities.extra.PaidProductSearch;
import com.event.repository.PaidProRepository;
import com.event.service.PaidProductService;

@Service
public class PaidProServiceImpl implements PaidProductService{

	@Autowired
	PaidProRepository paidrepo;
	
	@Override
	public List<PaidProduct> listallProduct(int event_id, int page, int row,
			int status) {
		// TODO Auto-generated method stub
		return paidrepo.listallProduct(event_id, page, row, status);
	}

	@Override
	public PaidProduct getProduct(int paid_pro_id) {
		// TODO Auto-generated method stub
		return paidrepo.getProduct(paid_pro_id);
	}

	@Override
	public List<PaidProduct> searchProduct(PaidProductSearch search) {
		// TODO Auto-generated method stub
		return paidrepo.searchProduct(search);
	}

	@Override
	public int insertPaidProduct(PaidProduct pro) {
		// TODO Auto-generated method stub
		return paidrepo.insertPaidProduct(pro);
	}

	@Override
	public int deletePaidProduct(int paid_pro_id) {
		// TODO Auto-generated method stub
		return paidrepo.deletePaidProduct(paid_pro_id);
	}

	@Override
	public int togglePaidProduct(int paid_pro_id) {
		// TODO Auto-generated method stub
		return paidrepo.togglePaidProduct(paid_pro_id);
	}

	@Override
	public int updatePaidProName(PaidProduct pro) {
		// TODO Auto-generated method stub
		return paidrepo.updatePaidProName(pro);
	}

	@Override
	public int updatePaidProPrice(PaidProduct pro) {
		// TODO Auto-generated method stub
		return paidrepo.updatePaidProPrice(pro);
	}

}
