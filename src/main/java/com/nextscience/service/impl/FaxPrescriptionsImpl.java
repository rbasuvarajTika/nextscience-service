package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.DupeRxResponse;

import com.nextscience.dto.response.FaxRxTrackerResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxPrescriptions;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.repo.FaxPrescriptionsRepository;
import com.nextscience.service.FaxPrescriptionsService;

@Service
public class FaxPrescriptionsImpl implements FaxPrescriptionsService {
	
	@Autowired
	FaxPrescriptionsRepository faxPrescriptionsRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FaxPrescriptions> findAll() {
		// TODO Auto-generated method stub
		return faxPrescriptionsRepository.findAll();
	}

	@Override
	public List<FaxRxTrackerResponse> getFaxRxTrackerList() {
		List<Object[]> faxRxTrackerResponse= faxPrescriptionsRepository.getFaxRxTrackerList();
		List<FaxRxTrackerResponse> responses = faxRxTrackerResponse.stream().map(this::mapToObjectsArray)
		        .collect(Collectors.toList());
		      	
		return responses;
	}
	
	private FaxRxTrackerResponse mapToObjectsArray(Object[] row) {
		FaxRxTrackerResponse response = new FaxRxTrackerResponse();
		
		response.setTrnRxId((Integer) row[0]);	
	    response.setTrnFaxId((Integer) row[1]);
	    response.setFaxId((String) row[2]);
	    response.setCaseId((Integer) row[3]);
	    response.setFaxDate((Date) row[4]);
	    response.setFaxNumber((String) row[5]);
	    response.setFaxUrl((String) row[6]);
	    response.setVerifiedFlag((String) row[7]);
	    response.setProviderType((String) row[8]);
	    response.setHcpName((String)row[9] );
	    response.setHcpAddress2((String)row[10]);
	    response.setHcpAddress2((String)row[11]);
	    response.setHcpCity((String)row[12]);
	    response.setHcpState((String)row[13]);
	    response.setHcpZip((String)row[14]);
	    response.setAccountName((String) row[15]);
	    response.setAccAddress1((String) row[16]);
	    response.setAccCity((String) row[17]);
	    response.setAccState((String) row[18]);
	    response.setAccZip((String) row[19]);
	    response.setPatientName((String) row[20]);
	    response.setDateOfBirth((Date) row[21]);
	    response.setGender((String) row[22]);
	    response.setCellPhone((String) row[23]);
	    response.setWorkPhone((String) row[24]);
	    response.setShipToAddress((String) row[25]);
	    response.setPatientCity((String) row[26]);
	    response.setPatientState((String) row[27]);
	    response.setPatientZip((String) row[28]);
	    response.setPatientZip4((String) row[29]);
	    response.setSsn((String) row[30]);
	    response.setMrn((String) row[31]);
	    response.setPmsId((String) row[32]);
	    response.setMaritialStatus((String) row[33]);
	    response.setEmergencyContactName((String) row[34]);
	    response.setEmergencyContactPhone((String) row[35]);
	    response.setProductCode((String) row[36]);
	    response.setProductDisplayName((String) row[37]);
	    response.setWorkPhone((String) row[38]);
	    return response;
	}
}
