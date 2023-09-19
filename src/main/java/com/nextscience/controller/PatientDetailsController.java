package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.FaxRxWoundProductInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.PatientDetailsResponse;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.PatientDetails;
import com.nextscience.service.PatientDetailsService;
import com.nextscience.utility.ResponseHelper;

public class PatientDetailsController {
	
	@Autowired
	PatientDetailsService patientDetailsService;
	@SuppressWarnings("unchecked")
	@GetMapping("/patient")

	public NSServiceResponse<List<PatientDetailsResponse>>getPatientDetail()
	  
	{ 
		List<PatientDetails> patient = patientDetailsService.findAll();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<PatientDetailsResponse>(), patient, "Successfully ", "Error");
	  }

}
