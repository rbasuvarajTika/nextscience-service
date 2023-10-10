package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
