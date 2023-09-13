package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;

import com.nextscience.entity.FaxRxWoundProductInfo;

import com.nextscience.repo.FaxRxWoundProductInfoRepository;
import com.nextscience.service.FaxRxWoundProductInfoService;
@Service
public class FaxRxWoundProductInfoImpl implements FaxRxWoundProductInfoService {

	@Autowired
	FaxRxWoundProductInfoRepository faxRxWoundProductInfoRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<FaxRxWoundProductInfo> pageOfFaxRxWoundResponses = (Page<FaxRxWoundProductInfo>) faxRxWoundProductInfoRepository.findAll();
		
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
