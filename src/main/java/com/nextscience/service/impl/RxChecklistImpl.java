package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.ProductDetails;
import com.nextscience.entity.RxChecklist;
import com.nextscience.repo.RxChecklistRepository;
import com.nextscience.service.RxChecklistService;

@Service
public class RxChecklistImpl implements RxChecklistService {
	
	@Autowired
	RxChecklistRepository rxChecklistRepository;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RxChecklist> findAll() {
		// TODO Auto-generated method stub
		return rxChecklistRepository.findAll();
	}

}
