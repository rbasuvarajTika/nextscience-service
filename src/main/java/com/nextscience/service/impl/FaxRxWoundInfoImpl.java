package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxWoundInfo;

import com.nextscience.repo.FaxRxWoundInfoRepository;
import com.nextscience.service.FaxRxWoundInfoService;

@Service
public class FaxRxWoundInfoImpl implements FaxRxWoundInfoService {
	
	
	@Autowired
	FaxRxWoundInfoRepository faxRxWoundInfoRepository;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<FaxRxWoundInfo> findAll() {
		// TODO Auto-generated method stub
		return faxRxWoundInfoRepository.findAll();
	}

}
