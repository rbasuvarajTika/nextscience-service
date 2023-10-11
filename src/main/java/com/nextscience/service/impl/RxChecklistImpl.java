package com.nextscience.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.CheckListResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.entity.ProductDetails;
import com.nextscience.entity.RxChecklist;
import com.nextscience.repo.RxChecklistRepository;
import com.nextscience.service.RxChecklistService;

@Service
public class RxChecklistImpl implements RxChecklistService {
	
	@Autowired
	RxChecklistRepository rxChecklistRepository;

	@Override
	public List<CheckListResponse> getCheckList() {
		List<Object[]> checkListResponse=rxChecklistRepository.getCheckList();
		List<CheckListResponse> responses = checkListResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
		
	}
	private CheckListResponse mapToObjectsArray(Object[] row) {
		CheckListResponse response = new CheckListResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setRxChecklistId((Integer) row[3]);
		response.setRxChecklistDesc((String) row[4]);
		response.setChecklist_Flag((String) row[5]);
		response.setComments((String) row[6]);
		return response;
	}
	@Override
	public List<CheckListResponse> getCheckLisDetByTrnRxId(int trnRxId) {
		List<Object[]> checkListResponse=rxChecklistRepository.getCheckLisDetByTrnRxId(trnRxId);
		List<CheckListResponse> responses = checkListResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}
		
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<RxChecklist> findAll() { // TODO Auto-generated method
	 * stub return rxChecklistRepository.findAll(); }
	 */

}
