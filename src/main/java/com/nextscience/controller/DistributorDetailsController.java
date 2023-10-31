package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.StateDetailsConstant;
import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.DistributorDetailsResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.StateDetailsResponse;
import com.nextscience.service.DistributorDetailsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class DistributorDetailsController {
	@Autowired
	private DistributorDetailsService distributorDetailsService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/distributorDetails")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<DistributorDetailsResponse>>getdistributorDetail()
	  
	{ 
	  List<DistributorDetailsResponse> distributorDetailsInfo = distributorDetailsService.getDistributorDetails();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<DistributorDetailsResponse>(), distributorDetailsInfo, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	  }

}
