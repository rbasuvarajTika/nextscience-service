package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.HcpDetails;

public interface HcpDetailsService {
	
	
	
	 // public List<HcpDetails> getHcpList();
	public List<HcpInfoResponse> getHcpInfoList();
	public	List<HcpInfoResponse> getHcpDetByTrnRxId(int trnFaxId);
	
	 
}
