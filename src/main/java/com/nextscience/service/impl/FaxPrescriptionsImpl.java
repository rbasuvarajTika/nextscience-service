package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
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
	public List<FaxPrescriptions> findAll() {
		// TODO Auto-generated method stub
		return faxPrescriptionsRepository.findAll();
	}
	
}
