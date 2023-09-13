package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;

import com.nextscience.entity.FaxRxWoundInfo;

import com.nextscience.repo.FaxRxWoundInfoRepository;
import com.nextscience.service.FaxRxWoundInfoService;

@Service
public class FaxRxWoundInfoImpl implements FaxRxWoundInfoService {
	
	
	@Autowired
	FaxRxWoundInfoRepository faxRxWoundInfoRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<FaxRxWoundInfo> pageOfFaxRxWoundResponses = (Page<FaxRxWoundInfo>)faxRxWoundInfoRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfFaxRxWoundResponses.getContent());
		pageResponse.setFirst(pageOfFaxRxWoundResponses.isFirst());
		pageResponse.setLast(pageOfFaxRxWoundResponses.isLast());
		pageResponse.setPageNumber(pageOfFaxRxWoundResponses.getNumber());
		pageResponse.setRecordCount(pageOfFaxRxWoundResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfFaxRxWoundResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfFaxRxWoundResponses.getSize());
		pageResponse.setTotalPages(pageOfFaxRxWoundResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfFaxRxWoundResponses.getTotalElements());
		return pageResponse;
	}


}
