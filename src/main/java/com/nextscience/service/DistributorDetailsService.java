package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.DistributorDetailsResponse;
import com.nextscience.dto.response.StateDetailsResponse;

public interface DistributorDetailsService {
	
	List<DistributorDetailsResponse> getDistributorDetails();
	
	

}
