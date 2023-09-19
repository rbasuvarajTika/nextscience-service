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
	public List<AccountDetails> findAll() {
		// TODO Auto-generated method stub
		return accountDetailsRepository.findAll();
	}
	
	
	
	

}
