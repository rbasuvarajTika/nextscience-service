package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.PharmacyDetailsConstant;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PharmacyDetailsResponse;
import com.nextscience.entity.PharmacyDetails;
import com.nextscience.service.PharmacyDetailsService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link PharmacyDetailsController } controller.
 * 
 * @author Raghu
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)

public class PharmacyDetailsController {

	@Autowired
	PharmacyDetailsService pharmacyDetailsService;

	/** Retrieves A list of PharmacyDetails Listt */
	@SuppressWarnings("unchecked")
	@GetMapping(PharmacyDetailsConstant.PHARMACY)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<PharmacyDetailsResponse>> getPharmacyDetail()

	{
		List<PharmacyDetails> pharmacy = pharmacyDetailsService.findAll();
		return ResponseHelper.createResponse(new NSServiceResponse<PharmacyDetailsResponse>(), pharmacy,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}
}
