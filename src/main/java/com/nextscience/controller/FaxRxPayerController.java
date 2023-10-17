package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.FaxRxPayerConstant;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.service.FaxRxPayerService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link FaxRxPayerController } controller.
 * @author Raghu
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class FaxRxPayerController {
	
	@Autowired
	private FaxRxPayerService faxRxPayerService;
	
	/**Retrieves A list of FaxPayer Details */
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxPayerConstant.PAYERLIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
    public NSServiceResponse<List<FaxRxPayerResponse>> executeCustomQuery(
    		@RequestParam(value = CommonConstants.PAGENO, required = false, defaultValue ="0") int pageNo,
    		@RequestParam(value = CommonConstants.PAGESIZE, required = false, defaultValue = "10") int pageSize,
    		@RequestParam(value = CommonConstants.SORTBY, defaultValue = CommonConstants.CREATEDDATE, required = false) String sortBy,            
    		@RequestParam(value = CommonConstants.ORDERBY,defaultValue = CommonConstants.DESC, required = false) String orderType ){ 
		 PageRequest page = null;       
		 if (CommonConstants.DESC.equals(orderType)) {    
			 page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());    
			 } else {               
				 page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending()); 
				 }
	{
    		
			 PageResponseDTO response =faxRxPayerService.fetchList(page);
			//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
			return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
					response, CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
}
	}
}


 /*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/faxPayer") public NSServiceResponse<List<FaxRxPayerResponse>>
	 * getUserDetail() { List<FaxRxPayer> faxPayer = faxRxPayerService.findAll();
	 * return ResponseHelper.createResponse(new
	 * NSServiceResponse<FaxRxPayerResponse>(), faxPayer, "Successfully ", "Error");
	 * }
	 */


