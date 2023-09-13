package com.nextscience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.PayerDetails;
import com.nextscience.repo.PayerDetailsRepository;
import com.nextscience.service.PayerDetailsService;

@Service
public class PayerDetailsImpl implements PayerDetailsService {
	
	@Autowired
	PayerDetailsRepository payerDetailsRepository;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<PayerDetails> pageOfPayerDetailsResponses = (Page<PayerDetails>) payerDetailsRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfPayerDetailsResponses.getContent());
		pageResponse.setFirst(pageOfPayerDetailsResponses.isFirst());
		pageResponse.setLast(pageOfPayerDetailsResponses.isLast());
		pageResponse.setPageNumber(pageOfPayerDetailsResponses.getNumber());
		pageResponse.setRecordCount(pageOfPayerDetailsResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfPayerDetailsResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfPayerDetailsResponses.getSize());
		pageResponse.setTotalPages(pageOfPayerDetailsResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfPayerDetailsResponses.getTotalElements());
		return pageResponse;
	}

}
