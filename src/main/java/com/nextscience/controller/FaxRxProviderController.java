package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.FaxRxProviderResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.service.FaxRxProviderService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class FaxRxProviderController {
	
	@Autowired
	FaxRxProviderService faxRxProviderService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/ProviderList")
	public NSServiceResponse<List<FaxRxProviderResponse>> executeCustomQuery()
	{
    		
			 PageResponseDTO response =faxRxProviderService.fetchList();
			//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
			return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
					response, "Successfully ", "Error");
}
	

}
