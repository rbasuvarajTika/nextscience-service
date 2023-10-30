package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.request.DeleteHcpInfoRequest;
import com.nextscience.dto.request.DeleteOfficeInfoRequest;
import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.InsertProductInfoRequest;
import com.nextscience.dto.request.UpdateHcpInfoRequest;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.HcpDetails;

/**
 * Service interface for managing {@link HcpDetailsService}.request
 * 
 * @author Raghu
 */

public interface HcpDetailsService {

	// public List<HcpDetails> getHcpList();

	/** Retrieves a list of HcpInfoResponse. */
	public List<HcpInfoResponse> getHcpInfoList();

	/** Retrieves a list of HcpInfoResponseByTrnRxId. */
	public List<HcpInfoResponse> getHcpDetByTrnRxId(int trnRxId);

	/** Update values in HcpInfo */
	public String updateHcpProc(UpdateHcpInfoRequest req);
	
	/** Insert values in HcpInfo */
	public String InsertHcpInfoProc(InsertHcpInfoRequest req);
	
	
	/** Delete values Hcp information. */
	public String DeleteHcpInfoProc(DeleteHcpInfoRequest req);

}
