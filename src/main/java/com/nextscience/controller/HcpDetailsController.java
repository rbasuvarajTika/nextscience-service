package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.AccountDetailsConstant;
import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.HcpDetailsConstant;
import com.nextscience.Constants.ProductDetailsConstant;
import com.nextscience.dto.request.DeleteHcpInfoRequest;
import com.nextscience.dto.request.DeleteOfficeInfoRequest;
import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.InsertProductInfoRequest;
import com.nextscience.dto.request.UpdateHcpInfoRequest;
import com.nextscience.dto.response.HcpDetailsResponse;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.service.HcpDetailsService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link HcpDetailsController } controller.
 * 
 * @author Raghu
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class HcpDetailsController {

	@Autowired
	HcpDetailsService hcpDetailsService;

	/** Retrieves A list of HcpDetailInfo List */
	@SuppressWarnings("unchecked")
	@GetMapping(HcpDetailsConstant.HCPINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<HcpInfoResponse>> gethcpDetail()

	{
		List<HcpInfoResponse> hcpDetailInfo = hcpDetailsService.getHcpInfoList();
		return ResponseHelper.createResponse(new NSServiceResponse<HcpInfoResponse>(), hcpDetailInfo,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list of HcpDetails List By TrnRxId */
	@SuppressWarnings("unchecked")
	@GetMapping(HcpDetailsConstant.HCPINFOTRNRXID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<HcpInfoResponse>> getRxHcptDetByTrnRxId(@PathVariable int trnRxId) {
		List<HcpInfoResponse> hcpDetailInfo = hcpDetailsService.getHcpDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<HcpInfoResponse>(), hcpDetailInfo,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Updates values in HcpDetailsInfo */
	@SuppressWarnings("unchecked")
	@PutMapping(HcpDetailsConstant.HCPINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<UpdateHcpInfoRequest> updateHcpInfoDet(@RequestBody UpdateHcpInfoRequest req) {
		String response = hcpDetailsService.updateHcpProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<UpdateHcpInfoRequest>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(HcpDetailsConstant.HCPINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<InsertHcpInfoRequest> InsertHcpInfoDet(@RequestBody InsertHcpInfoRequest req) {
		String response = hcpDetailsService.InsertHcpInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<InsertHcpInfoRequest>(), response, "Successfully ", "Error");
	}
	
	
	

	/**Delete Values in HcpInfo Details*/
	@SuppressWarnings("unchecked")
	@DeleteMapping(HcpDetailsConstant.HCPINFODETAILS)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<DeleteHcpInfoRequest> DeleteHcpInfoProc(@RequestBody DeleteHcpInfoRequest req) {
		String response = hcpDetailsService.DeleteHcpInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<DeleteHcpInfoRequest>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	

}
