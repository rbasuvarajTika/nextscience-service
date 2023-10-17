package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.dto.response.StateDetailsResponse;
import com.nextscience.repo.StateDetailsRepository;
import com.nextscience.service.StateDetailsService;

import org.springframework.stereotype.Service;

@Service
public class StateDetailsImpl implements StateDetailsService {
	
	@Autowired
	StateDetailsRepository stateDetailsRepository;

	@Override
	public List<StateDetailsResponse> getStatesDetails() {
		List<Object[]> stateDetailsResponse = stateDetailsRepository.getStatesDetails();
		List<StateDetailsResponse> responses = stateDetailsResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
		
	}

	private StateDetailsResponse mapToObjectsArray(Object[] row) {
		StateDetailsResponse response = new StateDetailsResponse();
		response.setStateId((Integer) row[0]);
		response.setStateName((String) row[1]);
		response.setShortName((String) row[2]);
		
		return response;
}
}
