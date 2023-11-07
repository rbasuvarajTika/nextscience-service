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
import com.nextscience.Constants.FaxRxWoundInfoConstant;
import com.nextscience.Constants.HcpDetailsConstant;
import com.nextscience.dto.request.DeleteOfficeInfoRequest;
import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.InsertOfficeInfoRequest;
import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.OfficeAccResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.service.AccountDetailsService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link AccountDetailsController } controller.
 * @author Raghu
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class AccountDetailsController {

	@Autowired
	private AccountDetailsService accountDetailsService;
	
	/**Retrieves A list of AccountDetailsList*/
	@SuppressWarnings("unchecked")
	@GetMapping(AccountDetailsConstant.OFFICEINFOURL)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<OfficeAccResponse>>getAccountDetail()
	  
	{ 
		List<OfficeAccResponse> accountInfo = accountDetailsService.getAccountList();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<OfficeAccResponse>(), accountInfo, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	  }
	
	/**Retrieves A list of AccountDetailsList by Using TrnRxID*/
	@SuppressWarnings("unchecked")
	@GetMapping(AccountDetailsConstant.OFFICEINFOURLID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<OfficeAccResponse>> getAcctDetByTrnRxId(@PathVariable int trnRxId)
	{
		List<OfficeAccResponse> accountInfo = accountDetailsService.getAccDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<OfficeAccResponse>(), accountInfo, CommonConstants.SUCCESSFULLY,CommonConstants.ERRROR);

	}	
	
	/**Update Values in OfficeInfo.*/
	@SuppressWarnings("unchecked")
	@PutMapping(AccountDetailsConstant.OFFICEINFOURL)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<UpdateOfficeInfoRequest> updateOffDetails(@RequestBody UpdateOfficeInfoRequest req)
	{
		String response = accountDetailsService.updateOffInfoProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<UpdateOfficeInfoRequest>(), 
    			response, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
	
	/**Delete Values in OfficeInfo Details*/
	@SuppressWarnings("unchecked")
	@DeleteMapping(AccountDetailsConstant.OFFICEINFODELETE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<DeleteOfficeInfoRequest> DeleteOfficeInfoProc(@RequestBody DeleteOfficeInfoRequest req) {
		String response = accountDetailsService.DeleteOfficeInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<DeleteOfficeInfoRequest>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	/**Insert Values in OfficeInfo Details*/
	@SuppressWarnings("unchecked")
	@PostMapping(AccountDetailsConstant.OFFICEINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<InsertOfficeInfoRequest> InsertOfficeInfoProc(@RequestBody InsertOfficeInfoRequest req) {
		String response = accountDetailsService.InsertOfficeInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<InsertOfficeInfoRequest>(), response, "Successfully ", "Error");
	}
	
	
	
	
}
	

