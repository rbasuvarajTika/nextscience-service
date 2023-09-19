package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.FaxPrescriptionsResponse;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxChecklistResponse;
import com.nextscience.entity.FaxPrescriptions;
import com.nextscience.entity.FaxRxProvider;
import com.nextscience.service.FaxPrescriptionsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class FaxPrescriptionsController {
	
	@Autowired
	FaxPrescriptionsService faxPrescriptionsService;
	

	@SuppressWarnings("unchecked")
	@GetMapping("/faxPrescriptions")
	public NSServiceResponse<List<FaxPrescriptionsResponse>>getPrescriptionDetail()
	  
	{ 
		List<FaxPrescriptions> prescription = faxPrescriptionsService.findAll();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<FaxPrescriptionsResponse>(), prescription, "Successfully ", "Error");
	  }
	
	

}
