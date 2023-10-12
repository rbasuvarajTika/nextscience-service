package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.UpdateChecklistInfoRequest;
import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.response.CheckListResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.entity.RxChecklist;

public interface RxChecklistService {
	

	//public List<RxChecklist> findAll();
	public List<CheckListResponse> getCheckList();
	public List<CheckListResponse> getCheckLisDetByTrnRxId(int trnRxId);
	public String updateChecklistInfoProc(UpdateChecklistInfoRequest req);


}
