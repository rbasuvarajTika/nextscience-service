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
import com.nextscience.Constants.RxCheckListConstant;
import com.nextscience.dto.request.UpdateChecklistInfoRequest;
import com.nextscience.dto.response.CheckListResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.RxChecklistResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.service.RxChecklistService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link RxChecklistController } request.
 * @author Raghu
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class RxChecklistController {

	@Autowired
	RxChecklistService rxChecklistService;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(RxCheckListConstant.CHECKLIST)
	public NSServiceResponse<List<CheckListResponse>>getchecklistDetail()
	  
	{ 
		List<CheckListResponse> checkList = rxChecklistService.getCheckList();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<RxChecklistResponse>(), checkList, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	  }
	
	@SuppressWarnings("unchecked")
	@GetMapping(RxCheckListConstant.CHECKLISTTRNRXID)
	public NSServiceResponse<List<CheckListResponse>> getRxPatientDetByTrnRxId(@PathVariable int trnRxId)
	{
		List<CheckListResponse> checkList = rxChecklistService.getCheckLisDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), checkList, CommonConstants.SUCCESSFULLY,CommonConstants.ERRROR);		
}
	
	@SuppressWarnings("unchecked")
	@PutMapping(RxCheckListConstant.CHECKLIST)
	public NSServiceResponse<UpdateChecklistInfoRequest> updateOffDetails(@RequestBody UpdateChecklistInfoRequest req)
	{
		String response = rxChecklistService.updateChecklistInfoProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<String>(), 
    			response, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
}	

