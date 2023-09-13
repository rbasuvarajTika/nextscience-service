package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.repo.FaxRxPayerRepository;
import com.nextscience.service.FaxRxPayerService;

@Service
public class FaxRxPayerImpl implements FaxRxPayerService {
	
	@Autowired
	FaxRxPayerRepository faxRxPayerRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResponseDTO fetchList() {
		Page<FaxRxPayer> pageOfFaxPayerResponses = (Page<FaxRxPayer>) faxRxPayerRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfFaxPayerResponses.getContent());
		pageResponse.setFirst(pageOfFaxPayerResponses.isFirst());
		pageResponse.setLast(pageOfFaxPayerResponses.isLast());
		pageResponse.setPageNumber(pageOfFaxPayerResponses.getNumber());
		pageResponse.setRecordCount(pageOfFaxPayerResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfFaxPayerResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfFaxPayerResponses.getSize());
		pageResponse.setTotalPages(pageOfFaxPayerResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfFaxPayerResponses.getTotalElements());
		return pageResponse;
	}

}
