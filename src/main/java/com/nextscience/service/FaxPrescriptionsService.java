package com.nextscience.service;

import java.util.List;


import com.nextscience.dto.response.FaxRxTrackerResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxPrescriptions;
import com.nextscience.entity.FaxRxProvider;

public interface FaxPrescriptionsService {

	List<FaxPrescriptions> findAll();
	
	

	List<FaxRxTrackerResponse> getFaxRxTrackerList();
	

	

}
