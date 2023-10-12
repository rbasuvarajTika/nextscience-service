package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertWoundInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.request.UpdateWoundInfoRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.entity.FaxRxWoundInfo;

public interface FaxRxWoundInfoService {
	
	
	

	//public List<FaxRxWoundInfo> findAll();
	public	List<WoundInfoResponse> getRxWoundInfoList();
	public List<WoundInfoResponse> getRxWoundDetByTrnRxId(int trnRxId);
	public String insertWoundInfoProc(InsertWoundInfoRequest req);
	public String updateWoundInfoProc(UpdateWoundInfoRequest req);
	public String DeleteWoundInfoProc(DeleteWoundInfoRequest req);
	
}
