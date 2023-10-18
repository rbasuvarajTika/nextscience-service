package com.nextscience.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.DistributorDetailsResponse;
import com.nextscience.dto.response.StateDetailsResponse;
import com.nextscience.repo.DistributorDetailsRepository;
import com.nextscience.service.DistributorDetailsService;

@Service
public class DistributorDetailsImpl implements DistributorDetailsService {
	@Autowired
	DistributorDetailsRepository distributorDetailsRepository;

	@Override
	public List<DistributorDetailsResponse> getDistributorDetails() {
		List<Object[]> distributorResponse = distributorDetailsRepository.getDistributorDetails();
		List<DistributorDetailsResponse> responses = distributorResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;

	}

	private DistributorDetailsResponse mapToObjectsArray(Object[] row) {
		DistributorDetailsResponse response = new DistributorDetailsResponse();
		response.setDistributorId((Integer) row[0]);
		response.setDistributorName((String) row[1]);
		return response;
	}

}
