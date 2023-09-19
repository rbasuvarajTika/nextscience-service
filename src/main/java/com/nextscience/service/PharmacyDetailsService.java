package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.PharmacyDetails;

public interface PharmacyDetailsService {
	
	public List<PharmacyDetails> findAll();
}
