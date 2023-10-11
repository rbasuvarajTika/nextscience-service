package com.nextscience.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.OfficeAccResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.repo.AccountDetailsRepository;
import com.nextscience.service.AccountDetailsService;
@Service
public class AccountDetailsImpl implements AccountDetailsService{
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Override
	public List<OfficeAccResponse> getAccountList() {
		List<Object[]> officeAccResponse=accountDetailsRepository.getAccountList();
		List<OfficeAccResponse> responses = officeAccResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}
	private OfficeAccResponse mapToObjectsArray(Object[] row) {
		OfficeAccResponse response = new OfficeAccResponse();
		
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setAccountId((Integer) row[3]);
		response.setAccountName((String) row[4]);
		response.setPhone((String) row[5]);
		response.setEmail((String) row[6]);
		response.setAddress1((String) row[7]);
		response.setCity((String) row[8]);
		response.setState((String) row[9]);
		response.setZip((String) row[10]);
		return response;
	}
	@Override
	public List<OfficeAccResponse> getAccDetByTrnRxId(int trnRxId) {
		List<Object[]> officeAccResponse=accountDetailsRepository.getAccDetByTrnRxId(trnRxId);
		List<OfficeAccResponse> responses = officeAccResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
		
	}
}
		

	/*
	 * @Override public List<AccountDetails> findAll() { // TODO Auto-generated
	 * method stub return accountDetailsRepository.findAll(); }
	 */
	
	
	
	


