package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.FaxPrescriptionsConstant;
import com.nextscience.Constants.FaxRxSplitHistConstant;
import com.nextscience.Constants.HcpDetailsConstant;
import com.nextscience.Constants.RxLookupConstant;
import com.nextscience.dto.request.DeleteFaxRxSplitHistRequest;
import com.nextscience.dto.request.DeleteHcpInfoRequest;
import com.nextscience.dto.request.InsertFaxRxSplitHistRequest;
import com.nextscience.dto.response.FaxPrscTrkWoundResponse;
import com.nextscience.dto.response.FaxRxSplitHistResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.RxLookupResponse;
import com.nextscience.entity.FaxRxSplitHist;
import com.nextscience.service.FaxRxSplitHistService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class FaxRxSplitHistController {
	
	@Autowired
	private FaxRxSplitHistService faxRxSplitHistService;
	
	@SuppressWarnings("unchecked")
	@PostMapping(FaxRxSplitHistConstant.FAXRXSPLITHISTS)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<InsertFaxRxSplitHistRequest> InsertFaxRxSplitHistDet(@RequestBody InsertFaxRxSplitHistRequest req) {
		String response = faxRxSplitHistService.InsertFaxRxSplitHistInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<InsertFaxRxSplitHistRequest>(), response, "Successfully ", "Error");
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxSplitHistConstant.FAXRXSPLITHIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxSplitHistResponse>> getAll()

	{
		List<FaxRxSplitHistResponse> resultList = faxRxSplitHistService.getAllFaxRxSPlitHistResponses();
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxSplitHistResponse>(), resultList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxSplitHistConstant.FAXRXSPLITHISTFAXID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxSplitHistResponse>> getFaxRxTrkWoundById(@PathVariable String faxId)

	{
		List<FaxRxSplitHistResponse> splitHistResponse = faxRxSplitHistService.getByFaxId(faxId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxSplitHistResponse>(), splitHistResponse,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping(FaxRxSplitHistConstant.FAXRXSPLITHIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<DeleteFaxRxSplitHistRequest> DeleteRxSplitHistInfoProc(@RequestBody DeleteFaxRxSplitHistRequest req) {
		String response = faxRxSplitHistService.DeleteFaxRxSplitHistInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<DeleteFaxRxSplitHistRequest>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	

}
