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
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.User;
import com.nextscience.repo.FaxRxPayerRepository;
import com.nextscience.service.FaxRxPayerService;


/**
 * Service Class for managing {@link FaxRxPayerImpl}.request
 * 
 * @author Raghu
 */


@Service
public class FaxRxPayerImpl implements FaxRxPayerService {
	
	@Autowired
	FaxRxPayerRepository faxRxPayerRepository;
	
	
	@Override
	public PageResponseDTO fetchList( PageRequest page) {
		Page<FaxRxPayer> listDetails = faxRxPayerRepository.findAll(page);
		
		
	  
	  PageResponseDTO pageResponse = new PageResponseDTO();
	  pageResponse.setData(listDetails.getContent());
	  pageResponse.setFirst(listDetails.isFirst());
	  pageResponse.setLast(listDetails.isLast());
	  pageResponse.setPageNumber(listDetails.getNumber());
	  pageResponse.setRecordCount(listDetails.getNumberOfElements());
	  pageResponse.setRecordOffset(listDetails.getPageable().getOffset(
	  )); pageResponse.setRequestedCount(listDetails.getSize());
	  pageResponse.setTotalPages(listDetails.getTotalPages());
	  pageResponse.setTotalRecords(listDetails.getTotalElements());
	  return pageResponse; }
	 
	/*
	@Override
	public List<FaxRxPayer> findAll() {
		return faxRxPayerRepository.findAll();*/
	}

