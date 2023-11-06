package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.RxLookupConstant;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.RxLookupResponse;
import com.nextscience.entity.RxLookup;
import com.nextscience.service.RxLookupService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class RxLookupController {

	@Autowired
	RxLookupService rxLookupService;

	/** Retrieves A list of RxLookup Details */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookupResponse>> getAll()

	{
		List<RxLookupResponse> resultList = rxLookupService.getALL();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookupResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By Frequency */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPFREQUENCYINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookupResponse>> getRxLookupByFrequency() {
		List<RxLookupResponse> resultList = rxLookupService.getRxLookupByFrequency();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookupResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By Thickness */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPTHICKNESSINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookupResponse>> getRxLookupByThickness() {
		List<RxLookupResponse> resultList = rxLookupService.getRxLookupByThickness();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookupResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By Drainage */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPDRAINAGEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookupResponse>> getRxLookupByDrainage() {
		List<RxLookupResponse> resultList = rxLookupService.getRxLookupByDrainage();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookupResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By Woundstage */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPWOUNDSTAGEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookupResponse>> getRxLookupByWoundstage() {
		List<RxLookupResponse> resultList = rxLookupService.getRxLookupByWoundstage();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookupResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By DebridementType */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPDEBRIDEMENT_TYPEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookupResponse>> getRxLookupByDebridementType() {
		List<RxLookupResponse> resultList = rxLookupService.getRxLookupByDebridementType();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookupResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	
	
	/** Retrieves A list of RxLookup By PlaceOfService */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPPLACEOFSERVICEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookupResponse>> getRxLookupByPlaceOfService() {
		List<RxLookupResponse> resultList = rxLookupService.getRxLookupByPlaceOfService();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookupResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	
	
	
	/** Retrieves A list of RxLookup By OrderInformation */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPORDERINFORMATIONINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookupResponse>> getRxLookupByOrderInformation() {
		List<RxLookupResponse> resultList = rxLookupService.getRxLookupByOrderInformation();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookupResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	
	
	
	

}
