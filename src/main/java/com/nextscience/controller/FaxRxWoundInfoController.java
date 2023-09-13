package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.FaxRxProviderResponse;
import com.nextscience.dto.response.FaxRxWoundInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.service.FaxRxProviderService;
import com.nextscience.service.FaxRxWoundInfoService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class FaxRxWoundInfoController {

	@Autowired
	FaxRxWoundInfoService faxRxWoundInfoService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/woundList")
	public NSServiceResponse<List<FaxRxWoundInfoResponse>> executeCustomQuery()
	{
    		
			 PageResponseDTO response =faxRxWoundInfoService.fetchList();
			//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
			return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
					response, "Successfully ", "Error");
}
	

}
