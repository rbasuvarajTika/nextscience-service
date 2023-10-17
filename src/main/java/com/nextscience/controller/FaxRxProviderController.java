package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.FaxRxProviderConstant;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.entity.FaxRxProvider;
import com.nextscience.service.FaxRxProviderService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link FaxRxProviderController } controller.
 * @author Raghu
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class FaxRxProviderController {
	
	@Autowired
	FaxRxProviderService faxRxProviderService;
	
	/**Retrieves A list of FaxRxProvider Details*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxProviderConstant.PROVIDERLIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxPayerResponse>>getProviderDetail()
	  
	{ 
		List<FaxRxProvider> account = faxRxProviderService.findAll();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<FaxRxPayerResponse>(), account, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	  }
}
	
