package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.entity.FaxRxProvider;
import com.nextscience.service.FaxRxProviderService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link FaxRxProviderController } request.
 * @author Raghu
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class FaxRxProviderController {
	
	@Autowired
	FaxRxProviderService faxRxProviderService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/ProviderList")
	public NSServiceResponse<List<FaxRxPayerResponse>>getProviderDetail()
	  
	{ 
		List<FaxRxProvider> account = faxRxProviderService.findAll();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<FaxRxPayerResponse>(), account, "Successfully ", "Error");
	  }
}
	
