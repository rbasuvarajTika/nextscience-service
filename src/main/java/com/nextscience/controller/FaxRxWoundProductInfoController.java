package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.FaxRxWoundProductInfoConstant;
import com.nextscience.dto.response.FaxRxWoundProductInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.entity.FaxRxWoundProductInfo;
import com.nextscience.service.FaxRxWoundProductInfoService;
import com.nextscience.utility.ResponseHelper;
/**
 * Processes an {@link FaxRxWoundProductInfoController } controller.
 * @author Raghu
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class FaxRxWoundProductInfoController {
	@Autowired
	FaxRxWoundProductInfoService faxRxWoundProductInfoService;
	
	/**Retrieves A list of WoundProductInfo Details*/
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxWoundProductInfoConstant.WOUNDPRODUCT)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxWoundProductInfoResponse>>getProductDetail()
	  
	{ 
		List<FaxRxWoundProductInfo> woundInfo = faxRxWoundProductInfoService.findAll();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<FaxRxWoundProductInfoResponse>(), woundInfo, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	  }
	

}
