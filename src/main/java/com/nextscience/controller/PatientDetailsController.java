package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.nextscience.dto.response.FaxRxWoundProductInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.PatientDetailsResponse;
import com.nextscience.service.PatientDetailsService;
import com.nextscience.utility.ResponseHelper;

public class PatientDetailsController {
	
	@Autowired
	PatientDetailsService patientDetailsService;
	@SuppressWarnings("unchecked")
	@GetMapping("/patient")
	public NSServiceResponse<List<PatientDetailsResponse>> executeCustomQuery()
	{
    		
			 PageResponseDTO response =patientDetailsService.fetchList();
			//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
			return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
					response, "Successfully ", "Error");
}

}
