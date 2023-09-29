package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.FaxPrescriptionsResponse;
import com.nextscience.dto.response.FaxPrscTrkWoundResponse;
import com.nextscience.dto.response.FaxRxTrackerResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.entity.FaxPrescriptions;
import com.nextscience.service.FaxPrescriptionsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class FaxPrescriptionsController {

	@Autowired
	FaxPrescriptionsService faxPrescriptionsService;

	@SuppressWarnings("unchecked")
	@GetMapping("/faxPrescriptions")
	public NSServiceResponse<List<FaxPrescriptionsResponse>> getPrescriptionDetail()

	{
		List<FaxPrescriptions> prescription = faxPrescriptionsService.findAll();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxPrescriptionsResponse>(), prescription,
				"Successfully ", "Error");
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/rxTrackerList")
	public NSServiceResponse<List<FaxRxTrackerResponse>> getFaxRxTrackerDetails()

	{
		List<FaxRxTrackerResponse> rxTracker = faxPrescriptionsService.getFaxRxTrackerList();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxTrackerResponse>(), rxTracker, "Successfully ",
				"Error");
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/rxTrackerWoundList")
	public NSServiceResponse<List<FaxPrscTrkWoundResponse>> getFaxRxTrkWoundDetails()

	{
		List<FaxPrscTrkWoundResponse> rxTracker = faxPrescriptionsService.getFaxRxTrkWoundDetailsList();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxPrscTrkWoundResponse>(), rxTracker,
				"Successfully ", "Error");
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/rxTrackerDetailList")
	public NSServiceResponse<List<FaxRxTrackerResponse>> getFaxRxTrackerDetailsList()

	{
		List<FaxRxTrackerResponse> rxTracker = faxPrescriptionsService.getFaxRxTrackerDetailsList();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxTrackerResponse>(), rxTracker, "Successfully ",
				"Error");
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/rxTrackerWoundList/{trnRxId}")
	public NSServiceResponse<List<FaxPrscTrkWoundResponse>> getFaxRxTrkWoundById(@PathVariable int trnRxId)

	{
		List<FaxPrscTrkWoundResponse> rxTracker = faxPrescriptionsService.getWoundByIdResponse(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxPrscTrkWoundResponse>(), rxTracker,
				"Successfully ", "Error");
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/rxTrackerWound/{caseId}")
	public NSServiceResponse<List<FaxPrscTrkWoundResponse>> getFaxRxTrkWoundByCaseId(@PathVariable int caseId)

	{
		List<FaxPrscTrkWoundResponse> rxTracker = faxPrescriptionsService.getWoundByCaseId(caseId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxPrscTrkWoundResponse>(), rxTracker,
				"Successfully ", "Error");
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/rxTrackerDetailList/{trnRxId}")
	public NSServiceResponse<List<FaxRxTrackerResponse>> getFaxRxTrackerListById(@PathVariable int trnRxId)

	{
		List<FaxRxTrackerResponse> rxTracker = faxPrescriptionsService.getFaxRxTrackerListById(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxTrackerResponse>(), rxTracker, "Successfully ",
				"Error");
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/rxTrackerDetail/{caseId}")
	public NSServiceResponse<List<FaxRxTrackerResponse>> getFaxRxTrackerListByCaseId(@PathVariable int caseId)

	{
		List<FaxRxTrackerResponse> rxTracker = faxPrescriptionsService.getFaxRxTrackerListByCaseId(caseId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxTrackerResponse>(), rxTracker, "Successfully ",
				"Error");
	}

}
