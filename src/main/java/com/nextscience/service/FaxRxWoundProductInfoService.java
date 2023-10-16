package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxWoundProductInfo;

/**
 * Service interface for managing {@link FaxRxWoundProductInfoService}.request
 * 
 * @author Raghu
 */

public interface FaxRxWoundProductInfoService {

	/** Retrieves a list of FaxRxWoundProductInfo. */
	List<FaxRxWoundProductInfo> findAll();

}
