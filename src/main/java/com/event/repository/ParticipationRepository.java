package com.event.repository;

import java.util.ArrayList;
import java.util.List;

import com.event.entities.Participation;
import com.event.entities.extra.ParticipationSearch;

public interface ParticipationRepository {

	public List<Participation> listAndSearchParticipationByUser(ParticipationSearch part);//
	public List<Participation> listAndSearchOlderPaticipation(ParticipationSearch part);//
	/*public List<Participation> listAndSearchOlderPaticipationWithMoreDetail(ParticipationSearch part);*///
	
	public int insertParticipation(Participation part);//
	public int[] insertBatchParticipation(ArrayList<Participation> list);
	public int toggleParticipation(int participation_id);//
	
	public int toggleDetail_Participation(int part_detail_id);//	
	public int updateKhmerMoneyDetail(Participation part);//
	public int updateDollarMoneyDetail(Participation part);//
	public int updateIsGift(int part_detail_id);//
	public int updateGiftDescription(Participation part);//
	
	public int updateParticipationName(Participation part);//
	public int updateParticipationDes(Participation part);//
}
