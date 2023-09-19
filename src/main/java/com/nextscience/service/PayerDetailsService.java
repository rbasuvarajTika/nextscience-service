package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.PayerDetails;

public interface PayerDetailsService {
	
	
	public List<PayerDetails> findAll();

}
