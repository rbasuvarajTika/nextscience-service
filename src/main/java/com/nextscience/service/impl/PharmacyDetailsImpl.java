package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.PatientDetails;
import com.nextscience.entity.PharmacyDetails;
import com.nextscience.repo.PharmacyDetailsRepository;
import com.nextscience.service.PharmacyDetailsService;
@Service
public class PharmacyDetailsImpl implements PharmacyDetailsService{

@Autowired	
PharmacyDetailsRepository pharmacyDetailsRepository;

@SuppressWarnings("unchecked")
@Override
public PageResponseDTO fetchList() {
	Page<PharmacyDetails> pageOfPharmacyDetailsResponses = (Page<PharmacyDetails>) pharmacyDetailsRepository.findAll();
	
	PageResponseDTO pageResponse = new PageResponseDTO();
	pageResponse.setData(pageOfPharmacyDetailsResponses.getContent());
	pageResponse.setFirst(pageOfPharmacyDetailsResponses.isFirst());
	pageResponse.setLast(pageOfPharmacyDetailsResponses.isLast());
	pageResponse.setPageNumber(pageOfPharmacyDetailsResponses.getNumber());
	pageResponse.setRecordCount(pageOfPharmacyDetailsResponses.getNumberOfElements());
	pageResponse.setRecordOffset(pageOfPharmacyDetailsResponses.getPageable().getOffset());
	pageResponse.setRequestedCount(pageOfPharmacyDetailsResponses.getSize());
	pageResponse.setTotalPages(pageOfPharmacyDetailsResponses.getTotalPages());
	pageResponse.setTotalRecords(pageOfPharmacyDetailsResponses.getTotalElements());
	return pageResponse;
}
}
