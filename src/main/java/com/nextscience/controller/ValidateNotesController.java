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
import com.nextscience.dto.request.FaxRxConfirmRequest;
import com.nextscience.dto.request.RemoveRxNotesRequest;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.ShowPrevRxHcpsResponse;
import com.nextscience.service.ValidateNotesService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class ValidateNotesController {
	
	@Autowired
	ValidateNotesService validateNotesService;
	
	@SuppressWarnings("unchecked")
	@PutMapping("/removeRxNotes")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<String> removeRxNotes(@RequestBody RemoveRxNotesRequest request) {

		String response = validateNotesService.removeRxNotes(request);

		return ResponseHelper.createResponse(new NSServiceResponse<>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);

	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/showNotesPrevRxHcp/{userName}/{trnFaxId}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<ShowPrevRxHcpsResponse>> showPrevRxHcp(@PathVariable String userName,
			@PathVariable Integer trnFaxId) {
		FaxRxConfirmRequest request = new FaxRxConfirmRequest(userName, trnFaxId);

		List<ShowPrevRxHcpsResponse> response = validateNotesService.showNotesPrevRxHcps(request);

		return ResponseHelper.createResponse(new NSServiceResponse<>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);

	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/showNotesPrevRxNameSearch/{patientName}/{hcpName}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<ShowPrevRxHcpsResponse>> showPrevRxNameSearch(@PathVariable String patientName,
			@PathVariable String hcpName) {

		List<ShowPrevRxHcpsResponse> response = validateNotesService.showNotesPrevRxNameSearch(patientName, hcpName);

		return ResponseHelper.createResponse(new NSServiceResponse<>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);

	}

}
