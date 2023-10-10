package com.nextscience.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.FaxPrscTrkWoundResponse;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.FaxRxWoundProductInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.PatientDetailsResponse;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.PatientDetails;
import com.nextscience.service.PatientDetailsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class PatientDetailsController {
	
	@Autowired
	PatientDetailsService patientDetailsService;
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/patient")
	 * 
	 * public NSServiceResponse<List<PatientDetailsResponse>>getPatientDetail()
	 * 
	 * { List<PatientDetails> patient = patientDetailsService.findAll(); return
	 * ResponseHelper.createResponse(new
	 * NSServiceResponse<PatientDetailsResponse>(), patient, "Successfully ",
	 * "Error"); }
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/rxpatient")
	public NSServiceResponse<List<RxPatientDetailsResponse>>getPatientDetailList()
	{
		List<RxPatientDetailsResponse> patientDetail = patientDetailsService.getRxPatientList();
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), patientDetail, "Successfully ","Error");

		

	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/rxpatient/{trnRxId}")
	public NSServiceResponse<List<RxPatientDetailsResponse>> getRxPatientDetByTrnRxId(@PathVariable int trnRxId)
	{
		List<RxPatientDetailsResponse> patientDetail = patientDetailsService.getRxPatientDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), patientDetail, "Successfully ","Error");

		

	}
	
}
