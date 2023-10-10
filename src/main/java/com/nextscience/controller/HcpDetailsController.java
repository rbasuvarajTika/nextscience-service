package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.FaxRxWoundProductInfoResponse;
import com.nextscience.dto.response.HcpDetailsResponse;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.FaxRxWoundProductInfo;
import com.nextscience.entity.HcpDetails;
import com.nextscience.service.HcpDetailsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class HcpDetailsController {
	
	@Autowired
	HcpDetailsService hcpDetailsService;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/hcpInfo")
	public NSServiceResponse<List<HcpInfoResponse>>gethcpDetail()
	  
	{ 
		List<HcpInfoResponse> hcpDetailInfo = hcpDetailsService.getHcpInfoList();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<HcpDetailsResponse>(), hcpDetailInfo, "Successfully ", "Error");
	  }
	
	@SuppressWarnings("unchecked")
	@GetMapping("/hcpInfo/{trnRxId}")
	public NSServiceResponse<List<HcpInfoResponse>> getRxHcptDetByTrnRxId(@PathVariable int trnRxId)
	{
		List<HcpInfoResponse> hcpDetailInfo = hcpDetailsService.getHcpDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), hcpDetailInfo, "Successfully ","Error");

		

	}
}
