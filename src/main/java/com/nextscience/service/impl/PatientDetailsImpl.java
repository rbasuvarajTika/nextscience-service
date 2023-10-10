package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.FaxRxTrackerResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.PatientDetails;
import com.nextscience.repo.FaxRxPayerRepository;
import com.nextscience.repo.PatientDetailsRepository;
import com.nextscience.repo.PayerDetailsRepository;
import com.nextscience.service.PatientDetailsService;
@Service
public class PatientDetailsImpl implements PatientDetailsService{
	
	@Autowired
	PatientDetailsRepository  patientDetailsRepository;

	/*
	 * @Override public List<PatientDetails> findAll() { // TODO Auto-generated
	 * method stub return patientDetailsRepository.findAll(); }
	 */
	@Override
	public List<RxPatientDetailsResponse> getRxPatientList() {
		List<Object[]> rxPatientDetailsResponse=patientDetailsRepository.getRxPatientList();
		List<RxPatientDetailsResponse> responses = rxPatientDetailsResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
		
	}
	
	@Override
	public List<RxPatientDetailsResponse> getRxPatientDetByTrnRxId(int trnFaxId) {
		List<Object[]> rxPatientDetailsResponse=patientDetailsRepository.getRxPatientDetByTrnRxId(trnFaxId);
		List<RxPatientDetailsResponse> responses = rxPatientDetailsResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}
	private RxPatientDetailsResponse mapToObjectsArray(Object[] row) {
		RxPatientDetailsResponse response = new RxPatientDetailsResponse();
		
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setCaseId((Integer) row[3]);
		response.setFaxDate((Date) row[4]);
		response.setFaxNumber((String) row[5]);
		response.setFaxUrl((String) row[6]);
		response.setPatientId((Integer) row[7]);
		response.setPatientName((String) row[8]);
		response.setDateOfBirth((Date) row[9]);
		response.setCellPhone((String) row[10]);
		response.setShipToAddress((String) row[11]);
		response.setCity((String) row[12]);
		response.setState((String) row[13]);
		response.setZip((String) row[14]);
		response.setSsn((String) row[15]);
		response.setWorkPhone((String) row[16]);
		response.setGender((String) row[17]);
		response.setZip4((String) row[18]);
		response.setMrn((String) row[19]);
		response.setPmsId((String) row[20]);
		response.setMaritalStatus((String) row[21]);
		response.setEmergencyContactName((String) row[22]);
		response.setEmergencyContactPhone((String) row[23]);
		response.setPlaceOfService((String) row[24]);
		response.setOrderType((String) row[25]);
		response.setWoundActive((Integer) row[26]);
		response.setRepName((String) row[27]);
		response.setRepPhoneNo((Integer) row[28]);
		response.setDistributorId((Integer) row[29]);
		response.setDistributorName((String) row[30]);
		return response;
	
}
/*
 * @Override public int updatePatientDetAndFaxRx(Object object) { // TODO
 * Auto-generated method stub return 0; }
 */

}
		
		
		
		
	
	
