package com.nextscience.service;

import java.util.List;
import com.nextscience.dto.response.FaxPrscTrkWoundResponse;
import com.nextscience.dto.response.FaxRxTrackerDetailsResponse;
import com.nextscience.dto.response.FaxRxTrackerResponse;

import com.nextscience.entity.FaxPrescriptions;

/**
 * Service interface for managing {@link FaxPrescriptionsService}.request
 * 
 * @author Raghu
 */
public interface FaxPrescriptionsService {

	/** Retrieves all fax prescriptions. */
	List<FaxPrescriptions> findAll();

	/** Retrieves a list of fax prescription tracker information. */
	List<FaxRxTrackerResponse> getFaxRxTrackerList();

	/** Retrieves a list of fax prescription tracker details. */
	List<FaxRxTrackerDetailsResponse> getFaxRxTrackerDetailsList();

	/** Retrieves a list of fax prescription tracker wound details. */
	List<FaxPrscTrkWoundResponse> getFaxRxTrkWoundDetailsList();

	/** Retrieves fax prescription tracker details by transaction ID. */
	List<FaxRxTrackerDetailsResponse> getFaxRxTrackerListById(int trnRxId);

	/** Retrieves wound details by transaction ID. */
	List<FaxPrscTrkWoundResponse> getWoundByIdResponse(int trnRxId);

	/** Retrieves a list of fax prescription tracker details by case ID. */
	List<FaxRxTrackerDetailsResponse> getFaxRxTrackerListByCaseId(int caseId);

	/** Retrieves a list of wound details by case ID. */
	List<FaxPrscTrkWoundResponse> getWoundByCaseId(int caseId);
	
	
	

}
