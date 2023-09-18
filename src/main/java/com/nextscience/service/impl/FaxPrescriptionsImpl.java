package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxPrescriptions;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.repo.FaxPrescriptionsRepository;
import com.nextscience.service.FaxPrescriptionsService;

@Service
public class FaxPrescriptionsImpl implements FaxPrescriptionsService {
	
	@Autowired
	FaxPrescriptionsRepository faxPrescriptionsRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<FaxPrescriptions> pageOfFaxPrescriptionsResponses = (Page<FaxPrescriptions>) faxPrescriptionsRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfFaxPrescriptionsResponses.getContent());
		pageResponse.setFirst(pageOfFaxPrescriptionsResponses.isFirst());
		pageResponse.setLast(pageOfFaxPrescriptionsResponses.isLast());
		pageResponse.setPageNumber(pageOfFaxPrescriptionsResponses.getNumber());
		pageResponse.setRecordCount(pageOfFaxPrescriptionsResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfFaxPrescriptionsResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfFaxPrescriptionsResponses.getSize());
		pageResponse.setTotalPages(pageOfFaxPrescriptionsResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfFaxPrescriptionsResponses.getTotalElements());
		return pageResponse;
	}

}
