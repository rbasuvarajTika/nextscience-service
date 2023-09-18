package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.service.AccountDetailsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class AccountDetailsController {

	@Autowired
	private AccountDetailsService accountDetailsService;
	@SuppressWarnings("unchecked")
	@GetMapping("/account")
    
	public NSServiceResponse<List<AccountDetailsResponse>> account()
			{
	
			
		    
				List<AccountDetailsResponse> response =accountDetailsService.getResponse();
				//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
				return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
						response, "Successfully ", "Error");
		    }

	}	
	

