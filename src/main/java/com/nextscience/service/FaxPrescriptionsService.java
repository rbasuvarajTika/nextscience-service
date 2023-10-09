package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.FaxPrscTrkWoundResponse;
import com.nextscience.dto.response.FaxRxTrackerDetailsResponse;
import com.nextscience.dto.response.FaxRxTrackerResponse;
import com.nextscience.entity.FaxPrescriptions;

public interface FaxPrescriptionsService {

	List<FaxPrescriptions> findAll();

	List<FaxRxTrackerResponse> getFaxRxTrackerList();
	
	List<FaxRxTrackerDetailsResponse> getFaxRxTrackerDetailsList();
	
	List<FaxPrscTrkWoundResponse> getFaxRxTrkWoundDetailsList();
	
	List<FaxRxTrackerDetailsResponse> getFaxRxTrackerListById(int trnRxId);

	List<FaxPrscTrkWoundResponse> getWoundByIdResponse(int trnRxId);

	List<FaxRxTrackerDetailsResponse> getFaxRxTrackerListByCaseId(int caseId);

	List<FaxPrscTrkWoundResponse> getWoundByCaseId(int caseId);

	

	
}
