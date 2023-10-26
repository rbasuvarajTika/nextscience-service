package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.FaxPrescriptionsConstant;
import com.nextscience.dto.response.FaxPrescriptionsResponse;
import com.nextscience.dto.response.FaxPrscTrkWoundResponse;
import com.nextscience.dto.response.FaxRxTrackerDetailsResponse;
import com.nextscience.dto.response.FaxRxTrackerResponse;
import com.nextscience.dto.response.NSServiceResponse;

import com.nextscience.entity.FaxPrescriptions;
import com.nextscience.service.FaxPrescriptionsService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link FaxPrescriptionsController } controller.
 * @author Raghu
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class FaxPrescriptionsController {

	@Autowired
	FaxPrescriptionsService faxPrescriptionsService;

	/** Retrieves a List of FaxPrescriptions Details.*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxPrescriptionsConstant.FAXPRESCRIPTIONS)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxPrescriptionsResponse>> getPrescriptionDetail()

	{
		List<FaxPrescriptions> prescription = faxPrescriptionsService.findAll();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxPrescriptionsResponse>(), prescription,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	
	/** Retrieves a List From RxTrackerList.*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxPrescriptionsConstant.RXTRACKERLIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxTrackerResponse>> getFaxRxTrackerDetails()

	{
		List<FaxRxTrackerResponse> rxTracker = faxPrescriptionsService.getFaxRxTrackerList();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxTrackerResponse>(), rxTracker, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	/** Retrieves a List From RxTrackerWoundList.*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxPrescriptionsConstant.RXTRACKERWOUNDLIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxPrscTrkWoundResponse>> getFaxRxTrkWoundDetails()

	{
		List<FaxPrscTrkWoundResponse> rxTracker = faxPrescriptionsService.getFaxRxTrkWoundDetailsList();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxPrscTrkWoundResponse>(), rxTracker,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	/** Retrieves a List From RxTrackerDetaiLList.*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxPrescriptionsConstant.RXTRACKERDETAILLIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxTrackerDetailsResponse>> getFaxRxTrackerDetailsList()

	{
		List<FaxRxTrackerDetailsResponse> rxTracker = faxPrescriptionsService.getFaxRxTrackerDetailsList();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxTrackerDetailsResponse>(), rxTracker, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	/** Retrieves a List From RxTrackerWoundListByTrnRxId.*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxPrescriptionsConstant.RXTRACKERWOUNDLISTTRNRXID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxPrscTrkWoundResponse>> getFaxRxTrkWoundById(@PathVariable int trnRxId)

	{
		List<FaxPrscTrkWoundResponse> rxTracker = faxPrescriptionsService.getWoundByIdResponse(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxPrscTrkWoundResponse>(), rxTracker,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
     
	/** Retrieves a List From RxTrackerWoundCaseId.*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxPrescriptionsConstant.RXTRACKERWOUNDCASEID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxPrscTrkWoundResponse>> getFaxRxTrkWoundByCaseId(@PathVariable int caseId)

	{
		List<FaxPrscTrkWoundResponse> rxTracker = faxPrescriptionsService.getWoundByCaseId(caseId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxPrscTrkWoundResponse>(), rxTracker,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves a List From RxTrackerDetailListByTrnRxId.*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxPrescriptionsConstant.RXTRACKERDETAILLISTTRNRXID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxTrackerResponse>> getFaxRxTrackerListById(@PathVariable int trnRxId)

	{
		List<FaxRxTrackerDetailsResponse> rxTracker = faxPrescriptionsService.getFaxRxTrackerListById(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxTrackerResponse>(), rxTracker, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	/** Retrieves a List From RxTrackerDetailCaseId.*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxPrescriptionsConstant.RXTRACKERDETAILCASEID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxTrackerResponse>> getFaxRxTrackerListByCaseId(@PathVariable int caseId)

	{
		List<FaxRxTrackerDetailsResponse> rxTracker = faxPrescriptionsService.getFaxRxTrackerListByCaseId(caseId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxTrackerResponse>(), rxTracker, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	
	
	
	

}
