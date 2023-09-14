package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.ProductDetails;
import com.nextscience.entity.RxChecklist;
import com.nextscience.repo.RxChecklistRepository;
import com.nextscience.service.RxChecklistService;

@Service
public class RxChecklistImpl implements RxChecklistService {
	
	@Autowired
	RxChecklistRepository rxChecklistRepository;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<RxChecklist> pageOfRxChecklistResponses = (Page<RxChecklist>) rxChecklistRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfRxChecklistResponses.getContent());
		pageResponse.setFirst(pageOfRxChecklistResponses.isFirst());
		pageResponse.setLast(pageOfRxChecklistResponses.isLast());
		pageResponse.setPageNumber(pageOfRxChecklistResponses.getNumber());
		pageResponse.setRecordCount(pageOfRxChecklistResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfRxChecklistResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfRxChecklistResponses.getSize());
		pageResponse.setTotalPages(pageOfRxChecklistResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfRxChecklistResponses.getTotalElements());
		return pageResponse;
	}
	

}
