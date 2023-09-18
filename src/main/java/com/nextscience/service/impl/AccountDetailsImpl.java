package com.nextscience.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.repo.AccountDetailsRepository;
import com.nextscience.service.AccountDetailsService;
@Service
public class AccountDetailsImpl implements AccountDetailsService{
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	
	@Override
	public PageResponseDTO fetchList( PageRequest page) {
		Page<AccountDetails> listDetails = accountDetailsRepository.findAll(page);
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(listDetails.getContent());
		pageResponse.setFirst(listDetails.isFirst());
		pageResponse.setLast(listDetails.isLast());
		pageResponse.setPageNumber(listDetails.getNumber());
		pageResponse.setRecordCount(listDetails.getNumberOfElements());
		pageResponse.setRecordOffset(listDetails.getPageable().getOffset());
		pageResponse.setRequestedCount(listDetails.getSize());
		pageResponse.setTotalPages(listDetails.getTotalPages());
		pageResponse.setTotalRecords(listDetails.getTotalElements());
		return pageResponse;
	}


	@Override
	public List<AccountDetailsResponse> getResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
