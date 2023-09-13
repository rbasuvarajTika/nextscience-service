package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.HcpDetails;
import com.nextscience.repo.HcpDetailsRepository;
import com.nextscience.service.HcpDetailsService;
@Service
public class HcpDetailsImpl implements HcpDetailsService{
	
    @Autowired
	HcpDetailsRepository hcpDetailsRepository;
    
    @SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<HcpDetails> pageOfHcpDetailsResponses = (Page<HcpDetails>) hcpDetailsRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfHcpDetailsResponses.getContent());
		pageResponse.setFirst(pageOfHcpDetailsResponses.isFirst());
		pageResponse.setLast(pageOfHcpDetailsResponses.isLast());
		pageResponse.setPageNumber(pageOfHcpDetailsResponses.getNumber());
		pageResponse.setRecordCount(pageOfHcpDetailsResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfHcpDetailsResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfHcpDetailsResponses.getSize());
		pageResponse.setTotalPages(pageOfHcpDetailsResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfHcpDetailsResponses.getTotalElements());
		return pageResponse;
	}
}
