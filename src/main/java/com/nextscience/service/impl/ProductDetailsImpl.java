package com.nextscience.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.PharmacyDetails;
import com.nextscience.entity.ProductDetails;
import com.nextscience.repo.ProductDetailsRepository;
import com.nextscience.service.ProductDetailsService;

@Service
public class ProductDetailsImpl implements ProductDetailsService {
	
	@Autowired
	ProductDetailsRepository productDetailsRepository;

	@Override
	public List<ProductKitsResponse> getProductDetailList() {
		List<Object[]> productKitsResponse=productDetailsRepository.getProductList();
		List<ProductKitsResponse> responses = productKitsResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
				
	}
	
	private ProductKitsResponse mapToObjectsArray(Object[] row) {
		ProductKitsResponse response = new ProductKitsResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setProductId((Integer) row[3]);
		response.setProductCode((String) row[4]);
		response.setProductDisplayName((String) row[5]);
		response.setQuantity((Integer) row[6]);
		response.setWnd1((Integer) row[7]);
		response.setWnd2((Integer) row[8]);
		response.setWnd3((Integer) row[9]);
		response.setWnd4((Integer) row[10]);
		response.setWndCode((String) row[11]);
		return response;
	}

	@Override
	public List<ProductKitsResponse> getProductDetByTrnRxId(int trnFaxId) {
		List<Object[]> productKitsResponse=productDetailsRepository.getProductDetByTrnRxId(trnFaxId);
		List<ProductKitsResponse> responses = productKitsResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
		
		
	}
}
		
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<ProductDetails> findAll() {
	 * 
	 * return productDetailsRepository.findAll(); }
	 */

