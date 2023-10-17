package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.AccountDetailsConstant;
import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.StateDetailsConstant;
import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.OfficeAccResponse;
import com.nextscience.dto.response.StateDetailsResponse;
import com.nextscience.service.AccountDetailsService;
import com.nextscience.service.StateDetailsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class StateDetailsController {
	
	@Autowired
	private StateDetailsService stateDetailsService;
	
	@SuppressWarnings("unchecked")
	@GetMapping(StateDetailsConstant.STATEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<StateDetailsResponse>>getStateDetail()
	  
	{ 
	  List<StateDetailsResponse> stateInfo = stateDetailsService.getStatesDetails();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<AccountDetailsResponse>(), stateInfo, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	  }
	
	

}
