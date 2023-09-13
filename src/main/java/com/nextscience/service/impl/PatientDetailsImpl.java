package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<PatientDetails> pageOfPatientDetailsResponses = (Page<PatientDetails>) patientDetailsRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfPatientDetailsResponses.getContent());
		pageResponse.setFirst(pageOfPatientDetailsResponses.isFirst());
		pageResponse.setLast(pageOfPatientDetailsResponses.isLast());
		pageResponse.setPageNumber(pageOfPatientDetailsResponses.getNumber());
		pageResponse.setRecordCount(pageOfPatientDetailsResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfPatientDetailsResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfPatientDetailsResponses.getSize());
		pageResponse.setTotalPages(pageOfPatientDetailsResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfPatientDetailsResponses.getTotalElements());
		return pageResponse;
	}

}
