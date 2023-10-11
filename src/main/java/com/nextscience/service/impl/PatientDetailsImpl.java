package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.nextscience.config.JwtAuthenticationFilter;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
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

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;

@Service
public class PatientDetailsImpl implements PatientDetailsService {

	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	 @PersistenceContext
	 private EntityManager entityManager;
	 
	 @Autowired
	 JwtAuthenticationFilter authentication;

	/*
	 * @Override public List<PatientDetails> findAll() { // TODO Auto-generated
	 * method stub return patientDetailsRepository.findAll(); }
	 */
	@Override
	public List<RxPatientDetailsResponse> getRxPatientList() {
		List<Object[]> rxPatientDetailsResponse = patientDetailsRepository.getRxPatientList();
		List<RxPatientDetailsResponse> responses = rxPatientDetailsResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;

	}

	@Override
	public List<RxPatientDetailsResponse> getRxPatientDetByTrnRxId(int trnRxId) {
		List<Object[]> rxPatientDetailsResponse = patientDetailsRepository.getRxPatientDetByTrnRxId(trnRxId);
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
		String getSsn = (String) row[15];
		String ssn = getSsn.substring(getSsn.length()-4);
		System.out.println(ssn);
		response.setSsn(ssn);
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

	@Override
	@Transactional
	public String updatePatientDetAndFaxRx(@Valid @RequestBody UpdatePatientTrnFaxRxRequest req) {

		String updatePatienDetails = "UPDATE DIM_PATIENT SET PATIENT_FULL_NAME = :PATIENT_NAME,"
				+ "	DATE_OF_BIRTH = :DATE_OF_BIRTH, CELL_PHONE = :CELL_PHONE,"
				+ "	SHIP_TO_ADDRESS = :SHIP_TO_ADDRESS, CITY = :CITY," 
				+ "	STATE = :STATE," + " ZIP = :ZIP, SSN = CONCAT( 'XXX-XXXX-', :SSN)," 
				+ "	UPDATED_USER = :USER, UPDATED_DATE = GETDATE() WHERE PATIENT_ID = :PATIENT_ID";
		
		String updateTrnFaxRxDet = "UPDATE TRN_FAX_RX SET PLACE_OF_SERVICE = :PLACE_OF_SERVICE,"
				+ "	ORDER_TYPE = :ORDER_TYPE, WOUND_ACTIVE = :WOUND_ACTIVE, REP_NAME = :REP_NAME,"
				+ "	REP_PHONE_NO = :REP_PHONE_NO, DISTRIBUTOR_ID = :DISTRIBUTOR_ID,"
				+ "	UPDATED_USER = :USER, UPDATED_DATE = GETDATE()"
				+ "	WHERE  TRN_FAX_ID = :TRN_FAX_ID AND"
				+ "	FAX_ID = :FAX_ID  AND"
				+ "	PATIENT_ID = :PATIENT_ID";
		
		 entityManager.createNativeQuery(updatePatienDetails)
         .setParameter("PATIENT_NAME", req.getPatientFullName())
         .setParameter("DATE_OF_BIRTH", req.getDateOfBirth())
         .setParameter("CELL_PHONE", req.getCellPhone())
         .setParameter("SHIP_TO_ADDRESS", req.getShipToAddress())
         .setParameter("CITY", req.getCity())
         .setParameter("STATE", req.getState())
         .setParameter("ZIP", req.getZip())
         .setParameter("SSN", req.getSsn())
         .setParameter("USER", authentication.getCurrentUserName())
         .setParameter("PATIENT_ID", req.getPatientId())
         .executeUpdate();
		 
		 entityManager.createNativeQuery(updateTrnFaxRxDet)
         .setParameter("PLACE_OF_SERVICE", req.getPlaceOfService())
         .setParameter("ORDER_TYPE", req.getOrderType())
         .setParameter("WOUND_ACTIVE", req.getWoundActive())
         .setParameter("REP_NAME", req.getRepName())
         .setParameter("REP_PHONE_NO", req.getRepPhoneNo())
         .setParameter("DISTRIBUTOR_ID", req.getDistributorId())
         .setParameter("USER", authentication.getCurrentUserName())
         .setParameter("TRN_FAX_ID", req.getTrnFaxId())
         .setParameter("FAX_ID", req.getFaxId())
         .setParameter("PATIENT_ID", req.getPatientId())
         .executeUpdate();
		 
		return "updated successfully";
	}

}
