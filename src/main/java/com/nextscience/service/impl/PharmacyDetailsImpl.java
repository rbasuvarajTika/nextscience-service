package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.PatientDetails;
import com.nextscience.entity.PayerDetails;
import com.nextscience.entity.PharmacyDetails;
import com.nextscience.repo.PharmacyDetailsRepository;
import com.nextscience.service.PharmacyDetailsService;

/**
 * Service Class for managing {@link PharmacyDetailsImpl}.request
 * 
 * @author Raghu
 */

@Service
public class PharmacyDetailsImpl implements PharmacyDetailsService{

@Autowired	
PharmacyDetailsRepository pharmacyDetailsRepository;

@SuppressWarnings("unchecked")
public List<PharmacyDetails> findAll() {
	// TODO Auto-generated method stub
	return pharmacyDetailsRepository.findAll();
}
}
