package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.FaxRxWoundProductInfo;
import com.nextscience.entity.HcpDetails;
import com.nextscience.repo.HcpDetailsRepository;
import com.nextscience.service.HcpDetailsService;

@Service
public class HcpDetailsImpl implements HcpDetailsService {

	@Autowired
	HcpDetailsRepository hcpDetailsRepository;

	@Override
	public List<HcpInfoResponse> getHcpInfoList() {
		List<Object[]> hcpInfoResponse=hcpDetailsRepository.getHcpInfoList();
		List<HcpInfoResponse> responses = hcpInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}
	private HcpInfoResponse mapToObjectsArray(Object[] row) {
		HcpInfoResponse response = new HcpInfoResponse();
		
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setHcpId((Integer) row[3]);
		response.setHcp_first_Name((String) row[4]);
		response.setHcp_last_Name((String) row[5]);
		response.setProvider_Type((String) row[6]);
		response.setNpi((String) row[7]);
		response.setSignature_Flag((String) row[8]);
		response.setSignature_Date((Date) row[9]);
		return response;
	}
	@Override
	public List<HcpInfoResponse> getHcpDetByTrnRxId(int trnFaxId) {
		List<Object[]> hcpInfoResponse=hcpDetailsRepository.getHcpDetByTrnRxId(trnFaxId);
		List<HcpInfoResponse> responses = hcpInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
		
	}
	
	/*
	 * @Override public List<HcpDetails> findAllHcpDetails( String cellPhone, String
	 * email, String address1, String city, String state, String zip) {
	 * 
	 * return hcpDetailsRepository.findAllHcpDetails( cellPhone, email, address1,
	 * city, state, zip);
	 * 
	 * }
	 */
	 
	 

	
	
	  
	 

}
