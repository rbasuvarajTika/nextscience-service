package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.entity.FaxRxWoundInfo;

public interface FaxRxWoundInfoService {
	
	
	

	//public List<FaxRxWoundInfo> findAll();
	public	List<WoundInfoResponse> getRxWoundInfoList();
	

}
