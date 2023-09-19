package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductDetailsResponse;
import com.nextscience.dto.response.RxChecklistResponse;
import com.nextscience.entity.ProductDetails;
import com.nextscience.entity.RxChecklist;
import com.nextscience.service.RxChecklistService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class RxChecklistController {

	@Autowired
	RxChecklistService rxChecklistService;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/rxChecklist")
	public NSServiceResponse<List<RxChecklistResponse>>getchecklistDetail()
	  
	{ 
		List<RxChecklist> checkList = rxChecklistService.findAll();
	  return ResponseHelper.createResponse(new
	  NSServiceResponse<RxChecklistResponse>(), checkList, "Successfully ", "Error");
	  }
}
	

