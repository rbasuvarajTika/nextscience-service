package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.InsertPatientInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.PatientDetails;

/**
 * Service interface for managing {@link PatientDetailsService}.request
 * 
 * @author Raghu
 */

public interface PatientDetailsService {

	// List<PatientDetails> findAll();

	/** Retrieves a List of RxPatientDetails. */
	public List<RxPatientDetailsResponse> getRxPatientList();

	/** Retrieves a List of RxPatientDetailsByTrnRxId. */
	public List<RxPatientDetailsResponse> getRxPatientDetByTrnRxId(int trnRxId);

	/** Updates values in RxPatientInfo */
	public String updatePatientDetAndFaxRx(UpdatePatientTrnFaxRxRequest req);

	/** Updates values in RxWoundInfo Using Proc */
	public String updatePatientDetAndFaxRxProc(UpdatePatientTrnFaxRxRequest req);
	
	/** Insert values in PatientInfo */
	public String InsertPatientInfoProc(InsertPatientInfoRequest req);
	
	
	
	
}
