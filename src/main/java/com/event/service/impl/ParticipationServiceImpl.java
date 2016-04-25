package com.event.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.entities.Participation;
import com.event.entities.extra.ParticipationSearch;
import com.event.repository.ParticipationRepository;
import com.event.service.ParticipationService;

@Service
public class ParticipationServiceImpl implements ParticipationService{

	@Autowired
	ParticipationRepository partrepo;
	@Override
	public List<Participation> listAndSearchParticipationByUser(
			ParticipationSearch part) {
		// TODO Auto-generated method stub
		return partrepo.listAndSearchParticipationByUser(part);
	}

	@Override
	public List<Participation> listAndSearchOlderPaticipation(ParticipationSearch part) {
		// TODO Auto-generated method stub
		return partrepo.listAndSearchOlderPaticipation(part);
	}

	/*@Override
	public List<Participation> listAndSearchOlderPaticipationWithMoreDetail(
			ParticipationSearch part) {
		// TODO Auto-generated method stub
		return partrepo.listAndSearchOlderPaticipationWithMoreDetail(part);
	}*/

	@Override
	public int insertParticipation(Participation part) {
		// TODO Auto-generated method stub
		return partrepo.insertParticipation(part);
	}

	@Override
	public int[] insertBatchParticipation(ArrayList<Participation> list) {
		// TODO Auto-generated method stub
		return partrepo.insertBatchParticipation(list);
	}

	@Override
	public int toggleParticipation(int participation_id) {
		// TODO Auto-generated method stub
		return partrepo.toggleParticipation(participation_id);
	}

	@Override
	public int toggleDetail_Participation(int part_detail_id) {
		// TODO Auto-generated method stub
		return partrepo.toggleDetail_Participation(part_detail_id);
	}

	@Override
	public int updateKhmerMoneyDetail(Participation part) {
		// TODO Auto-generated method stub
		return partrepo.updateKhmerMoneyDetail(part);
	}

	@Override
	public int updateDollarMoneyDetail(Participation part) {
		// TODO Auto-generated method stub
		return partrepo.updateDollarMoneyDetail(part);
	}

	@Override
	public int updateIsGift(int part_detail_id) {
		// TODO Auto-generated method stub
		return partrepo.updateIsGift(part_detail_id);
	}

	@Override
	public int updateGiftDescription(Participation part) {
		// TODO Auto-generated method stub
		return partrepo.updateGiftDescription(part);
	}

	@Override
	public int updateParticipationName(Participation part) {
		// TODO Auto-generated method stub
		return partrepo.updateParticipationName(part);
	}

	@Override
	public int updateParticipationDes(Participation part) {
		// TODO Auto-generated method stub
		return partrepo.updateParticipationDes(part);
	}

}
