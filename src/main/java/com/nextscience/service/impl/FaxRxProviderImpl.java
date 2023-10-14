package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.FaxRxProvider;
import com.nextscience.repo.FaxRxProviderRepository;
import com.nextscience.repo.FaxRxRepository;
import com.nextscience.service.FaxRxProviderService;

/**
 * Service Class for managing {@link FaxRxProviderImpl}.request
 * 
 * @author Raghu
 */

@Service
public class FaxRxProviderImpl implements FaxRxProviderService {

	@Autowired
	FaxRxProviderRepository faxRxProviderRepository;

	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<FaxRxProvider> findAll() {
		// TODO Auto-generated method stub
		return faxRxProviderRepository.findAll();
	}

}
