package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxWoundInfo;
import com.nextscience.entity.FaxRxWoundProductInfo;

import com.nextscience.repo.FaxRxWoundProductInfoRepository;
import com.nextscience.service.FaxRxWoundProductInfoService;

/**
 * Service Class for managing {@link FaxRxWoundProductInfoImpl}.request
 * 
 * @author Raghu
 */

@Service
public class FaxRxWoundProductInfoImpl implements FaxRxWoundProductInfoService {

	@Autowired
	FaxRxWoundProductInfoRepository faxRxWoundProductInfoRepository;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<FaxRxWoundProductInfo> findAll() {
		// TODO Auto-generated method stub
		return faxRxWoundProductInfoRepository.findAll();
	}
}
