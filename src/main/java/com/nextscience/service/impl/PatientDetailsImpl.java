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
import com.nextscience.dto.request.InsertPatientInfoRequest;
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
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.validation.Valid;

/**
 * Service Class for managing {@link PatientDetailsImpl}.request
 * 
 * @author Raghu
 */

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
		response.setPatientFirstName((String) row[9]);
		response.setPatientMiddleName((String) row[10]);
		response.setPatientLastName((String) row[11]);

		response.setDateOfBirth((Date) row[12]);
		response.setCellPhone((String) row[13]);
		response.setShipToAddress((String) row[14]);
		response.setCity((String) row[15]);
		response.setState((String) row[16]);
		response.setZip((String) row[17]);
		String getSsn = (String) row[18];
		if (getSsn != null) {
			String ssn = getSsn.substring(getSsn.length() - 4);
			System.out.println(ssn);
			response.setSsn(ssn);
		}
		response.setWorkPhone((String) row[19]);
		response.setGender((String) row[20]);
		response.setZip4((String) row[21]);
		response.setMrn((String) row[22]);
		response.setPmsId((String) row[23]);
		response.setMaritalStatus((String) row[24]);
		response.setEmergencyContactName((String) row[25]);
		response.setEmergencyContactPhone((String) row[26]);
		response.setPlaceOfService((String) row[27]);
		response.setOrderType((String) row[28]);
		if ((Integer) row[29] != null) {
			if ((Integer) row[29] == 1) {
				response.setWoundActive("Yes");
			} else {
				response.setWoundActive("No");
			}
		} else {
			response.setWoundActive(null);
		}
		response.setRepName((String) row[30]);
		response.setRepPhoneNo((String) row[31]);
		response.setDistributorId((Integer) row[32]);
		response.setDistributorName((String) row[33]);
		return response;

	}

	@Override
	@Transactional
	public String updatePatientDetAndFaxRx(@Valid @RequestBody UpdatePatientTrnFaxRxRequest req) {

		String updatePatienDetails = "UPDATE DIM_PATIENT SET PATIENT_FULL_NAME = :PATIENT_NAME,"
				+ "	DATE_OF_BIRTH = :DATE_OF_BIRTH, CELL_PHONE = :CELL_PHONE,"
				+ "	SHIP_TO_ADDRESS = :SHIP_TO_ADDRESS, CITY = :CITY," + "	STATE = :STATE,"
				+ " ZIP = :ZIP, SSN = CONCAT( 'XXX-XXXX-', :SSN),"
				+ "	UPDATED_USER = :USER, UPDATED_DATE = GETDATE() WHERE PATIENT_ID = :PATIENT_ID";

		String updateTrnFaxRxDet = "UPDATE TRN_FAX_RX SET PLACE_OF_SERVICE = :PLACE_OF_SERVICE,"
				+ "	ORDER_TYPE = :ORDER_TYPE, WOUND_ACTIVE = :WOUND_ACTIVE, REP_NAME = :REP_NAME,"
				+ "	REP_PHONE_NO = :REP_PHONE_NO, DISTRIBUTOR_ID = :DISTRIBUTOR_ID,"
				+ "	UPDATED_USER = :USER, UPDATED_DATE = GETDATE()" + "	WHERE  TRN_FAX_ID = :TRN_FAX_ID AND"
				+ "	FAX_ID = :FAX_ID  AND" + "	PATIENT_ID = :PATIENT_ID";

		entityManager.createNativeQuery(updatePatienDetails).setParameter("PATIENT_NAME", req.getPatientFullName())
				.setParameter("DATE_OF_BIRTH", req.getDateOfBirth()).setParameter("CELL_PHONE", req.getCellPhone())
				.setParameter("SHIP_TO_ADDRESS", req.getShipToAddress()).setParameter("CITY", req.getCity())
				.setParameter("STATE", req.getState()).setParameter("ZIP", req.getZip())
				.setParameter("SSN", req.getSsn()).setParameter("USER", authentication.getCurrentUserName())
				.setParameter("PATIENT_ID", req.getPatientId()).executeUpdate();

		entityManager.createNativeQuery(updateTrnFaxRxDet).setParameter("PLACE_OF_SERVICE", req.getPlaceOfService())
				.setParameter("ORDER_TYPE", req.getOrderType()).setParameter("WOUND_ACTIVE", req.getWoundActive())
				.setParameter("REP_NAME", req.getRepName()).setParameter("REP_PHONE_NO", req.getRepPhoneNo())
				.setParameter("DISTRIBUTOR_ID", req.getDistributorId())
				.setParameter("USER", authentication.getCurrentUserName()).setParameter("TRN_FAX_ID", req.getTrnFaxId())
				.setParameter("FAX_ID", req.getFaxId()).setParameter("PATIENT_ID", req.getPatientId()).executeUpdate();

		return "updated successfully";
	}

	@Override
	public String updatePatientDetAndFaxRxProc(UpdatePatientTrnFaxRxRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_PatientDetails_Edit");
		Integer woundActiveVal = 0;

		// Set the parameters for the stored procedure
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PATIENT_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PATIENT_FIRST_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PATIENT_LAST_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PATIENT_MIDDLE_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("DATE_OF_BIRTH", Date.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CELL_PHONE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SHIP_TO_ADDRESS", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CITY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("STATE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ZIP", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SSN", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PLACE_OF_SERVICE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ORDER_TYPE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_ACTIVE", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("REP_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("REP_PHONE_NO", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("DISTRIBUTOR_NAME", String.class, ParameterMode.IN);

		if (req.getWoundActive() != null) {
			if (req.getWoundActive().equalsIgnoreCase("Yes")) {
				woundActiveVal = 1;
			}
		} else {
			woundActiveVal = null;
		}

		// Set parameter values
		query.setParameter("USER", req.getUpdatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());
		query.setParameter("FAX_ID", req.getFaxId());
		query.setParameter("PATIENT_ID", req.getPatientId());
		query.setParameter("PATIENT_FIRST_NAME", req.getPatientFirstName());
		query.setParameter("PATIENT_LAST_NAME", req.getPatientLastName());
		query.setParameter("PATIENT_MIDDLE_NAME", req.getPatientMiddleName());

		query.setParameter("DATE_OF_BIRTH", req.getDateOfBirth());
		query.setParameter("CELL_PHONE", req.getCellPhone());
		query.setParameter("SHIP_TO_ADDRESS", req.getShipToAddress());
		query.setParameter("CITY", req.getCity());
		query.setParameter("STATE", req.getState());
		query.setParameter("ZIP", req.getZip());
		query.setParameter("SSN", req.getSsn());
		query.setParameter("PLACE_OF_SERVICE", req.getPlaceOfService());
		query.setParameter("ORDER_TYPE", req.getOrderType());
		query.setParameter("WOUND_ACTIVE", woundActiveVal);
		query.setParameter("REP_NAME", req.getRepName());
		query.setParameter("REP_PHONE_NO", req.getRepPhoneNo());
		query.setParameter("DISTRIBUTOR_NAME", req.getDistributorName());

		// Execute the stored procedure
		query.execute();
		return "updated successfully";
	}

	@Override
	public String InsertPatientInfoProc(InsertPatientInfoRequest req) {

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_PatientDetails_Add");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PATIENT_FIRST_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PATIENT_LAST_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PATIENT_MIDDLE_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("DATE_OF_BIRTH", Date.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CELL_PHONE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("EMAIL", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SHIP_TO_ADDRESS", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CITY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("STATE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ZIP", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SSN", String.class, ParameterMode.IN);

		query.setParameter("USER", req.getCreatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());
		query.setParameter("FAX_ID", req.getFaxId());
		query.setParameter("PATIENT_FIRST_NAME", req.getPatientFirstName());
		query.setParameter("PATIENT_LAST_NAME", req.getPatientLastName());
		query.setParameter("PATIENT_MIDDLE_NAME", req.getPatientMiddleName());
		query.setParameter("DATE_OF_BIRTH", req.getDateOfBirth());
		query.setParameter("CELL_PHONE", req.getCellPhone());
		query.setParameter("EMAIL", req.getEmail());
		query.setParameter("SHIP_TO_ADDRESS", req.getShipToAddress());
		query.setParameter("CITY", req.getCity());
		query.setParameter("STATE", req.getState());
		query.setParameter("ZIP", req.getZip());
		query.setParameter("SSN", req.getSsn());

		query.execute();

		return "created successfully";
	}

}
