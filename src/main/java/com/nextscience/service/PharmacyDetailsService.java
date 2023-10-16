package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.PharmacyDetails;

/**
 * Service interface for managing {@link PharmacyDetailsService}.request
 * 
 * @author Raghu
 */
public interface PharmacyDetailsService {

	/** Retrieves A List Of PharmacyDetails */
	public List<PharmacyDetails> findAll();
}
