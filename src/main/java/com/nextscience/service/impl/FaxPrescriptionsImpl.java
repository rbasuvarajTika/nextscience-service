package com.nextscience.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.FaxPrscTrkWoundResponse;
import com.nextscience.dto.response.FaxRxTrackerDetailsResponse;
import com.nextscience.dto.response.FaxRxTrackerResponse;

import com.nextscience.entity.FaxPrescriptions;
import com.nextscience.repo.FaxPrescriptionsRepository;
import com.nextscience.service.FaxPrescriptionsService;

/**
 * Service Class for managing {@link FaxPrescriptionsImpl}.request
 * 
 * @author Raghu
 */

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
		List<Object[]> faxRxTrackerResponse = faxPrescriptionsRepository.getFaxRxTrackerList();
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
		response.setHcpName((String) row[9]);
		response.setHcpAddress2((String) row[10]);
		response.setHcpAddress2((String) row[11]);
		response.setHcpCity((String) row[12]);
		response.setHcpState((String) row[13]);
		response.setHcpZip((String) row[14]);
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
		response.setWndCode((String) row[38]);
		return response;
	}

	
	
	  private FaxRxTrackerDetailsResponse mapToObjectsArrays(Object[] row) {
	  FaxRxTrackerDetailsResponse response = new FaxRxTrackerDetailsResponse();
	  
	  response.setTrnRxId((Integer) row[0]); response.setTrnFaxId((Integer)
	  row[1]); response.setFaxId((String) row[2]); response.setCaseId((Integer)
	  row[3]); response.setFaxDate((Date) row[4]); response.setFaxNumber((String)
	  row[5]); response.setFaxUrl((String) row[6]);
	  response.setVerifiedFlag((String) row[7]); 
	  response.setHcpName((String) row[8]);
	  response.setHcpAddress1((String) row[9]); response.setHcpAddress2((String)
	  row[10]); response.setHcpCity((String) row[11]);
	  response.setHcpState((String) row[12]); response.setHcpZip((String) row[13]);
	  response.setAccountName((String) row[14]); response.setAccAddress1((String)
	  row[15]); response.setAccCity((String) row[16]);
	  response.setAccState((String) row[17]); response.setAccZip((String) row[18]);
	  response.setPatientName((String) row[19]); response.setDateOfBirth((Date)
	  row[20]); response.setGender((String) row[21]);
	  response.setCellPhone((String) row[22]); response.setWorkPhone((String)
	  row[23]); response.setShipToAddress((String) row[24]);
	  response.setPatientCity((String) row[25]); response.setPatientState((String)
	  row[26]); response.setPatientZip((String) row[27]);
	  response.setPatientZip4((String) row[28]); response.setSsn((String) row[29]);
	  response.setMrn((String) row[30]); response.setPmsId((String) row[31]);
	  response.setMaritialStatus((String) row[32]);
	  response.setEmergencyContactName((String) row[33]);
	  response.setEmergencyContactPhone((String) row[34]);
	  response.setProcessStatus((String) row[35]);
	  response.setRxFulfilmentStatus((String) row[36]);
	  response.setNetsuiteRxId((Integer) row[37]);
	  response.setPrimaryPayerName((String) row[38]);
	  response.setPrimaryPayerId((Integer) row[39]);
	  response.setPatientId((Integer)row[40]);	
	  response.setPayerType((String) row[41]);
	  
	  return response; }
	 
	@Override
	public List<FaxRxTrackerDetailsResponse> getFaxRxTrackerDetailsList() {
		List<Object[]> faxRxTrackerResponse = faxPrescriptionsRepository.getFaxRxTrackerDetailsList();
		List<FaxRxTrackerDetailsResponse> responses = faxRxTrackerResponse.stream().map(this::mapToObjectsArrays)
				.collect(Collectors.toList());

		return responses;
	}

	@Override
	public List<FaxPrscTrkWoundResponse> getFaxRxTrkWoundDetailsList() {
		List<Object[]> faxPrscTrkkWoundResponse = faxPrescriptionsRepository.getFaxRxTrkWoundDetailsList();
		List<FaxPrscTrkWoundResponse> responses = faxPrscTrkkWoundResponse.stream().map(this::mapToObjectsArrayFax)
				.collect(Collectors.toList());

		return responses;
	}

	private FaxPrscTrkWoundResponse mapToObjectsArrayFax(Object[] row) {
		FaxPrscTrkWoundResponse response = new FaxPrscTrkWoundResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setCaseId((Integer) row[3]);
		response.setFaxDate((Date) row[4]);
		response.setFaxNumber((String) row[5]);
		response.setFaxUrl((String) row[6]);
		response.setWoundNo((Integer) row[8]);
		response.setWoundLocation((String) row[9]);
		response.setWoundLength((BigDecimal) row[10]);
		response.setWoundWidth((BigDecimal) row[11]);
		response.setWoundDepth((BigDecimal) row[12]);
		response.setWoundThickness((String) row[13]);
		response.setDrainage((String) row[14]);
		response.setDebrided((Integer) row[15]);
		response.setDebridedDate((Date) row[16]);
		response.setIcdCode((String) row[17]);
		return response;
	}
	
	@Override
	public List<FaxRxTrackerDetailsResponse> getFaxRxTrackerListById(int trnRxId) {
		List<Object[]> faxRxTrackerResponse = faxPrescriptionsRepository.getFaxRxTrackerDetailsList(trnRxId);
		List<FaxRxTrackerDetailsResponse> responses = faxRxTrackerResponse.stream().map(this::mapToObjectsArrays)
				.collect(Collectors.toList());

		return responses;
	}
	
	
	@Override
	public List<FaxRxTrackerDetailsResponse> getFaxRxTrackerListByCaseId(int caseId) {
		List<Object[]> faxRxTrackerResponse = faxPrescriptionsRepository.getFaxRxTrackerCaseList(caseId);
		List<FaxRxTrackerDetailsResponse> responses = faxRxTrackerResponse.stream().map(this::mapToObjectsArrays)
				.collect(Collectors.toList());

		return responses;
	}

	@Override
	public List<FaxPrscTrkWoundResponse> getWoundByIdResponse(int trnRxId)
	{
		List<Object[]> faxPrscTrkkWoundResponse = faxPrescriptionsRepository.getFaxRxTrkWoundDetailsList(trnRxId);
		List<FaxPrscTrkWoundResponse> responses = faxPrscTrkkWoundResponse.stream().map(this::mapToObjectsArrayFax)
				.collect(Collectors.toList());

		return responses;
		
	}
	
	
	@Override
	public List<FaxPrscTrkWoundResponse> getWoundByCaseId(int caseId)
	{
		List<Object[]> faxPrscTrkkWoundResponse = faxPrescriptionsRepository.getFaxRxTrkWoundCaseList(caseId);
		List<FaxPrscTrkWoundResponse> responses = faxPrscTrkkWoundResponse.stream().map(this::mapToObjectsArrayFax)
				.collect(Collectors.toList());

		return responses;
		
	}

	
	
	
}
