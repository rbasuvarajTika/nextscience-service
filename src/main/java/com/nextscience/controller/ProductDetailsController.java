package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.PharmacyDetailsResponse;
import com.nextscience.dto.response.ProductDetailsResponse;
import com.nextscience.service.ProductDetailsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class ProductDetailsController {
	
	
	@Autowired
	ProductDetailsService productDetailsService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/product")
	public NSServiceResponse<List<ProductDetailsResponse>> executeCustomQuery()
	{
    		
			 PageResponseDTO response =productDetailsService.fetchList();
			//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
			return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
					response, "Successfully ", "Error");
}
	

}
