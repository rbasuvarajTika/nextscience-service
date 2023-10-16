package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxProvider;

/**
 * Service interface for managing {@link FaxRxService}.request
 * 
 * @author Raghu
 */
public interface FaxRxProviderService {

	/** Retrieves a list of FaxRxProvider List */
	List<FaxRxProvider> findAll();

}
