package com.nextscience.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.repo.AccountDetailsRepository;
import com.nextscience.service.AccountDetailsService;
@Service
public class AccountDetailsImpl implements AccountDetailsService{
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<AccountDetails> pageOfaccountDetailsResponses = (Page<AccountDetails>) accountDetailsRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfaccountDetailsResponses.getContent());
		pageResponse.setFirst(pageOfaccountDetailsResponses.isFirst());
		pageResponse.setLast(pageOfaccountDetailsResponses.isLast());
		pageResponse.setPageNumber(pageOfaccountDetailsResponses.getNumber());
		pageResponse.setRecordCount(pageOfaccountDetailsResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfaccountDetailsResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfaccountDetailsResponses.getSize());
		pageResponse.setTotalPages(pageOfaccountDetailsResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfaccountDetailsResponses.getTotalElements());
		return pageResponse;
	}

	

}
