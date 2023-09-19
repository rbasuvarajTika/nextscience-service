package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.ProductDetails;

public interface ProductDetailsService {
	
	public List<ProductDetails> findAll();

}
