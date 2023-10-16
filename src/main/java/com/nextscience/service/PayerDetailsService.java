package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.PayerDetails;

/**
 * Service interface for managing {@link PayerDetailsService}.request
 * 
 * @author Raghu
 */

public interface PayerDetailsService {

	/** Retrieves A List Of PayerDetails */
	public List<PayerDetails> findAll();

}
