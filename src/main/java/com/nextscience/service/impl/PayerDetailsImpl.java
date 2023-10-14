package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.PatientDetails;
import com.nextscience.entity.PayerDetails;
import com.nextscience.repo.PayerDetailsRepository;
import com.nextscience.service.PayerDetailsService;

/**
 * Service Class for managing {@link PayerDetailsImpl}.request
 * 
 * @author Raghu
 */

@Service
public class PayerDetailsImpl implements PayerDetailsService {
	
	@Autowired
	PayerDetailsRepository payerDetailsRepository;
	
	
	public List<PayerDetails> findAll() {
		// TODO Auto-generated method stub
		return payerDetailsRepository.findAll();
	}
	

}
