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

import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.service.FaxRxPayerService;
import com.nextscience.service.FaxRxService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class FaxContoller {

	@Autowired
	private FaxRxService faxRxService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/faxList")
    public NSServiceResponse<List<FaxRxResponse>> executeCustomQuery(
    		@RequestParam(value = "pageNo", required = false, defaultValue ="0") int pageNo,
    		@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
    		@RequestParam(value = "sortBy", defaultValue = "created_date", required = false) String sortBy,            
    		@RequestParam(value = "orderBy",defaultValue = "desc", required = false) String orderType ){ 
		 PageRequest page = null;       
		 if ("desc".equals(orderType)) {    
			 page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());    
			 } else {               
				 page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending()); 
				 }
		 PageResponseDTO response =faxRxService.fetchList(page);
		//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
				response, "Successfully ", "Error");
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping("/faxDupe")
	public NSServiceResponse<List<DupeRxResponse>> executeCustomQuery(){
    
		List<DupeRxResponse> response =faxRxService.getDuplicateResponse();
		//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
				response, "Successfully ", "Error");
    }
	
	
}

