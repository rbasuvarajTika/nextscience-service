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
	public NSServiceResponse<List<RxLookup>> getAll()

	{
		List<RxLookup> resultList = rxLookupService.getALL();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookup>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By Frequency */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPFREQUENCYINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookup>> getRxLookupByFrequency() {
		List<RxLookup> resultList = rxLookupService.getRxLookupByFrequency();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookup>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By Thickness */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPTHICKNESSINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookup>> getRxLookupByThickness() {
		List<RxLookup> resultList = rxLookupService.getRxLookupByThickness();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookup>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By Drainage */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPDRAINAGEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookup>> getRxLookupByDrainage() {
		List<RxLookup> resultList = rxLookupService.getRxLookupByDrainage();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookup>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By Woundstage */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPWOUNDSTAGEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookup>> getRxLookupByWoundstage() {
		List<RxLookup> resultList = rxLookupService.getRxLookupByWoundstage();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookup>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of RxLookup By DebridementType */
	@SuppressWarnings("unchecked")
	@GetMapping(RxLookupConstant.LOOKUPDEBRIDEMENT_TYPEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxLookup>> getRxLookupByDebridementType() {
		List<RxLookup> resultList = rxLookupService.getRxLookupByDebridementType();
		return ResponseHelper.createResponse(new NSServiceResponse<RxLookup>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

}
