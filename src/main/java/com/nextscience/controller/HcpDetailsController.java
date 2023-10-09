package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.FaxRxWoundProductInfoResponse;
import com.nextscience.dto.response.HcpDetailsResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxWoundProductInfo;
import com.nextscience.entity.HcpDetails;
import com.nextscience.service.HcpDetailsService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class HcpDetailsController {
	
	@Autowired
	HcpDetailsService hcpDetailsService;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/hcp")
	public NSServiceResponse<List<HcpDetailsResponse>>gethcpDetail()
	  
	{ 
		List<HcpDetails> hcpInfo = hcpDetailsService.getHcpList();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<HcpDetailsResponse>(), hcpInfo, "Successfully ", "Error");
	  }
	
	/*public NSServiceResponse<List<HcpDetailsResponse>>gethcpDetail( @RequestParam(name = "cellPhone", required = false) String cellPhone,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "address1", required = false) String address1,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "state", required = false) String state,
            @RequestParam(name = "zip", required = false) String zip) {
        return (NSServiceResponse<List<HcpDetailsResponse>>) hcpDetailsService.findAllHcpDetails(cellPhone, email, address1, city, state, zip);
			
}*/
}
