package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.FaxRxWoundProductInfo;
import com.nextscience.entity.HcpDetails;
import com.nextscience.repo.HcpDetailsRepository;
import com.nextscience.service.HcpDetailsService;
@Service
public class HcpDetailsImpl implements HcpDetailsService{
	
    @Autowired
	HcpDetailsRepository hcpDetailsRepository;
    
    @SuppressWarnings("unchecked")
	
	@Override
	public List<HcpDetails> findAll() {
		// TODO Auto-generated method stub
		return hcpDetailsRepository.findAll();
	}
}
