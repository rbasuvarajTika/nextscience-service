package com.nextscience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.dto.request.InsertFaxRxSplitHistRequest;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.service.FaxRxSplitHistService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class FaxRxSplitHistController {
	
	@Autowired
	private FaxRxSplitHistService faxRxSplitHistService;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/FaxRxSplitHist")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<InsertFaxRxSplitHistRequest> InsertFaxRxSplitHistDet(@RequestBody InsertFaxRxSplitHistRequest req) {
		String response = faxRxSplitHistService.InsertFaxRxSplitHistInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<InsertFaxRxSplitHistRequest>(), response, "Successfully ", "Error");
	}
	

}
