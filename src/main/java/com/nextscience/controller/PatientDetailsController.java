package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.HcpDetailsConstant;
import com.nextscience.Constants.PatientDetailsConstant;
import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.InsertPatientInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.service.PatientDetailsService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link PatientDetailsController } controller.
 * 
 * @author Raghu
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class PatientDetailsController {

	@Autowired
	PatientDetailsService patientDetailsService;
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/patient")
	 * 
	 * public NSServiceResponse<List<PatientDetailsResponse>>getPatientDetail()
	 * 
	 * { List<PatientDetails> patient = patientDetailsService.findAll(); return
	 * ResponseHelper.createResponse(new
	 * NSServiceResponse<PatientDetailsResponse>(), patient, "Successfully ",
	 * "Error"); }
	 */

	/** Retrieves A list of PatientDetails List */
	@SuppressWarnings("unchecked")
	@GetMapping(PatientDetailsConstant.RXPATIENT)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxPatientDetailsResponse>> getPatientDetailList() {
		List<RxPatientDetailsResponse> patientDetail = patientDetailsService.getRxPatientList();
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), patientDetail,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);

	}

	/** Retrieves A list of PatientDetailsList By TrnRxId */
	@SuppressWarnings("unchecked")
	@GetMapping(PatientDetailsConstant.RXPATIENTTRNRXID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<RxPatientDetailsResponse>> getRxPatientDetByTrnRxId(@PathVariable int trnRxId) {
		List<RxPatientDetailsResponse> patientDetail = patientDetailsService.getRxPatientDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), patientDetail,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);

	}

	/** Updates Values in PatientDetails List */
	@SuppressWarnings("unchecked")
	@PutMapping(PatientDetailsConstant.RXPATIENT)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<UpdatePatientTrnFaxRxRequest> updatePatientFaxRxDet(
			@RequestBody UpdatePatientTrnFaxRxRequest req) {
		String response = patientDetailsService.updatePatientDetAndFaxRxProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<String>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(PatientDetailsConstant.PATIENTDETAILSINFO)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<InsertPatientInfoRequest> InsertPatientInfoProc(@RequestBody InsertPatientInfoRequest req) {
		String response = patientDetailsService.InsertPatientInfoProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<InsertPatientInfoRequest>(), response, "Successfully ", "Error");

}
}
