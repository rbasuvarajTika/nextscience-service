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

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.FaxRxWoundInfoConstant;
import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertWoundInfoRequest;
import com.nextscience.dto.request.UpdateWoundInfoRequest;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.service.FaxRxWoundInfoService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link FaxRxWoundInfoController } controller.
 * 
 * @author Raghu
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class FaxRxWoundInfoController {

	@Autowired
	FaxRxWoundInfoService faxRxWoundInfoService;

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/woundList") public
	 * NSServiceResponse<List<WoundInfoResponse>>getWoundDetail()
	 * 
	 * { List<WoundInfoResponse> woundInfo =
	 * faxRxWoundInfoService.getRxWoundInfoList(); return
	 * ResponseHelper.createResponse(new
	 * NSServiceResponse<FaxRxWoundInfoResponse>(), woundInfo, "Successfully ",
	 * "Error"); }
	 */

	/** Retrieves A list of WoundInfo Details */
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxWoundInfoConstant.WOUNDINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<WoundInfoResponse>> getWoundInfoList() {
		List<WoundInfoResponse> woundInfo = faxRxWoundInfoService.getRxWoundInfoList();
		return ResponseHelper.createResponse(new NSServiceResponse<WoundInfoResponse>(), woundInfo,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);

	}

	/** Retrieves A list of WoundInfo Details By TrnRxId */
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxWoundInfoConstant.WOUNDINFOTRNRXID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<WoundInfoResponse>> getRxPatientDetByTrnRxId(@PathVariable int trnRxId) {
		List<WoundInfoResponse> woundInfo = faxRxWoundInfoService.getRxWoundDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), woundInfo,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);

	}

	/**Insert Values in WoundInfo Details*/
	@SuppressWarnings("unchecked")
	@PostMapping(FaxRxWoundInfoConstant.WOUNDINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<InsertWoundInfoRequest> insertWoundDetail(@RequestBody InsertWoundInfoRequest req) {
		String response = faxRxWoundInfoService.insertWoundInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<String>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}

	/**Update Values in WoundInfo Details*/
	@SuppressWarnings("unchecked")
	@PutMapping(FaxRxWoundInfoConstant.WOUNDINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<UpdateWoundInfoRequest> updateWoundDetails(@RequestBody UpdateWoundInfoRequest req) {
		String response = faxRxWoundInfoService.updateWoundInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<String>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	/**Delete Values in WoundInfo Details*/
	@SuppressWarnings("unchecked")
	@DeleteMapping(FaxRxWoundInfoConstant.WOUNDINFODETAILS)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<DeleteWoundInfoRequest> deleteWoundDetails(@RequestBody DeleteWoundInfoRequest req) {
		String response = faxRxWoundInfoService.DeleteWoundInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<String>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}

}
