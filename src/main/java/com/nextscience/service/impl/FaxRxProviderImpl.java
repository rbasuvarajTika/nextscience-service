package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.FaxRxProvider;
import com.nextscience.repo.FaxRxProviderRepository;
import com.nextscience.repo.FaxRxRepository;
import com.nextscience.service.FaxRxProviderService;


@Service
public class FaxRxProviderImpl implements FaxRxProviderService {

	@Autowired
	FaxRxProviderRepository faxRxProviderRepository;

	
	@SuppressWarnings("unchecked")
	@Override

	public PageResponseDTO fetchList() {
		Page<FaxRxProvider> pageOfFaxProviderResponses = (Page<FaxRxProvider>) faxRxProviderRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfFaxProviderResponses.getContent());
		pageResponse.setFirst(pageOfFaxProviderResponses.isFirst());
		pageResponse.setLast(pageOfFaxProviderResponses.isLast());
		pageResponse.setPageNumber(pageOfFaxProviderResponses.getNumber());
		pageResponse.setRecordCount(pageOfFaxProviderResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfFaxProviderResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfFaxProviderResponses.getSize());
		pageResponse.setTotalPages(pageOfFaxProviderResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfFaxProviderResponses.getTotalElements());
		return pageResponse;
	}
	
	

}
