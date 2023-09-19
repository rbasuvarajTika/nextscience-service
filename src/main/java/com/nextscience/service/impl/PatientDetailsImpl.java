package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.PatientDetails;
import com.nextscience.repo.FaxRxPayerRepository;
import com.nextscience.repo.PatientDetailsRepository;
import com.nextscience.repo.PayerDetailsRepository;
import com.nextscience.service.PatientDetailsService;
@Service
public class PatientDetailsImpl implements PatientDetailsService{
	
	@Autowired
	PatientDetailsRepository  patientDetailsRepository;
	@Override
	public List<PatientDetails> findAll() {
		// TODO Auto-generated method stub
		return patientDetailsRepository.findAll();
	}
	
	
}
