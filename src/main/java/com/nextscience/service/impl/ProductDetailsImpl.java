package com.nextscience.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.PharmacyDetails;
import com.nextscience.entity.ProductDetails;
import com.nextscience.repo.ProductDetailsRepository;
import com.nextscience.service.ProductDetailsService;

@Service
public class ProductDetailsImpl implements ProductDetailsService {
	
	@Autowired
	ProductDetailsRepository productDetailsRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> findAll() {
		// TODO Auto-generated method stub
		return productDetailsRepository.findAll();
	}
}
