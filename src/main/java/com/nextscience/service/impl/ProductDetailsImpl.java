package com.nextscience.service.impl;

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
	public PageResponseDTO fetchList() {
		Page<ProductDetails> pageOfProductDetailsResponses = (Page<ProductDetails>) productDetailsRepository.findAll();
		
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfProductDetailsResponses.getContent());
		pageResponse.setFirst(pageOfProductDetailsResponses.isFirst());
		pageResponse.setLast(pageOfProductDetailsResponses.isLast());
		pageResponse.setPageNumber(pageOfProductDetailsResponses.getNumber());
		pageResponse.setRecordCount(pageOfProductDetailsResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfProductDetailsResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfProductDetailsResponses.getSize());
		pageResponse.setTotalPages(pageOfProductDetailsResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfProductDetailsResponses.getTotalElements());
		return pageResponse;
	}
	

}
