package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.OfficeAccResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.AccountDetails;
import com.nextscience.service.AccountDetailsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class AccountDetailsController {

	@Autowired
	private AccountDetailsService accountDetailsService;
	@SuppressWarnings("unchecked")
	@GetMapping("/officeInfo")
    
	public NSServiceResponse<List<OfficeAccResponse>>getAccountDetail()
	  
	{ 
		List<OfficeAccResponse> accountInfo = accountDetailsService.getAccountList();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<AccountDetailsResponse>(), accountInfo, "Successfully ", "Error");
	  }
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/officeInfo/{trnRxId}")
	public NSServiceResponse<List<OfficeAccResponse>> getAcctDetByTrnRxId(@PathVariable int trnRxId)
	{
		List<OfficeAccResponse> accountInfo = accountDetailsService.getAccDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), accountInfo, "Successfully ","Error");

	}	
}
	

