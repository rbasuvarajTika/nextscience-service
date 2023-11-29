package com.nextscience.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.nextscience.dto.request.DeleteFaxRxSplitHistRequest;
import com.nextscience.dto.request.InsertFaxRxSplitHistRequest;
import com.nextscience.dto.request.UpdateFaxRxSplitHistRequest;
import com.nextscience.dto.request.UpdateHcpInfoRequest;
import com.nextscience.dto.response.FaxRxSplitHistResponse;
import com.nextscience.entity.FaxRxSplitHist;

public interface FaxRxSplitHistService {

	public String InsertFaxRxSplitHistInfoProc(InsertFaxRxSplitHistRequest req);
	List<FaxRxSplitHistResponse> getAllFaxRxSPlitHistResponses();
	List<FaxRxSplitHistResponse> getByFaxId(String faxId);
	public String DeleteFaxRxSplitHistInfoProc(DeleteFaxRxSplitHistRequest req);
	
	public String updateFaxRxSplitHistInfoProc(UpdateFaxRxSplitHistRequest req);
	

	
	
}
