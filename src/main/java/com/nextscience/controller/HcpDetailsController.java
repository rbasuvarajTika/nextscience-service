package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.HcpDetailsConstant;
import com.nextscience.dto.request.UpdateHcpInfoRequest;
import com.nextscience.dto.response.HcpDetailsResponse;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.service.HcpDetailsService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link HcpDetailsController } request.
 * @author Raghu
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class HcpDetailsController {
	
	@Autowired
	HcpDetailsService hcpDetailsService;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(HcpDetailsConstant.HCPINFO)
	public NSServiceResponse<List<HcpInfoResponse>>gethcpDetail()
	  
	{ 
		List<HcpInfoResponse> hcpDetailInfo = hcpDetailsService.getHcpInfoList();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<HcpDetailsResponse>(), hcpDetailInfo, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	  }
	
	@SuppressWarnings("unchecked")
	@GetMapping(HcpDetailsConstant.HCPINFOTRNRXID)
	public NSServiceResponse<List<HcpInfoResponse>> getRxHcptDetByTrnRxId(@PathVariable int trnRxId)
	{
		List<HcpInfoResponse> hcpDetailInfo = hcpDetailsService.getHcpDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), hcpDetailInfo, CommonConstants.SUCCESSFULLY,CommonConstants.ERRROR);
		}
	
	@SuppressWarnings("unchecked")
	@PutMapping(HcpDetailsConstant.HCPINFO)
	public NSServiceResponse<UpdateHcpInfoRequest> updateHcpInfoDet(@RequestBody UpdateHcpInfoRequest req)
	{
		String response = hcpDetailsService.updateHcpProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<String>(), 
    			response, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	
	
	
}
