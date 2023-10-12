package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertWoundInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.request.UpdateWoundInfoRequest;
import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.FaxRxProviderResponse;
import com.nextscience.dto.response.FaxRxWoundInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxWoundInfo;
import com.nextscience.service.FaxRxProviderService;
import com.nextscience.service.FaxRxWoundInfoService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class FaxRxWoundInfoController {

	@Autowired
	FaxRxWoundInfoService faxRxWoundInfoService;
	
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/woundList") public
	 * NSServiceResponse<List<WoundInfoResponse>>getWoundDetail()
	 * 
	 * { List<WoundInfoResponse> woundInfo =
	 * faxRxWoundInfoService.getRxWoundInfoList(); return
	 * ResponseHelper.createResponse(new
	 * NSServiceResponse<FaxRxWoundInfoResponse>(), woundInfo, "Successfully ",
	 * "Error"); }
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/woundInfo")
	public NSServiceResponse <List<WoundInfoResponse>>getWoundInfoList()
	{
		List<WoundInfoResponse> woundInfo = faxRxWoundInfoService.getRxWoundInfoList();
		return ResponseHelper.createResponse(new NSServiceResponse<WoundInfoResponse>(), woundInfo, "Successfully ","Error");
		

	}
	@SuppressWarnings("unchecked")
	@GetMapping("/woundInfo/{trnRxId}")
	public NSServiceResponse<List<WoundInfoResponse>> getRxPatientDetByTrnRxId(@PathVariable int trnRxId)
	{
		List<WoundInfoResponse> woundInfo = faxRxWoundInfoService.getRxWoundDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), woundInfo, "Successfully ","Error");

		

	}
	@SuppressWarnings("unchecked")
	@PostMapping("/woundInfo")
	public NSServiceResponse<InsertWoundInfoRequest> insertWoundDetail(@RequestBody InsertWoundInfoRequest req)
	{
		String response = faxRxWoundInfoService.insertWoundInfoProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<String>(), 
    			response, "Successfully ", "Error");
	}

	@SuppressWarnings("unchecked")
	@PutMapping("/woundInfo")
	public NSServiceResponse<UpdateWoundInfoRequest> updateWoundDetails(@RequestBody UpdateWoundInfoRequest req)
	{
		String response = faxRxWoundInfoService.updateWoundInfoProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<String>(), 
    			response, "Successfully ", "Error");
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/woundInfoDetails")
	public NSServiceResponse<DeleteWoundInfoRequest> deleteWoundDetails(@RequestBody DeleteWoundInfoRequest req)
	{
		String response = faxRxWoundInfoService.DeleteWoundInfoProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<String>(), 
    			response, "Successfully ", "Error");
	}
	
	
}
