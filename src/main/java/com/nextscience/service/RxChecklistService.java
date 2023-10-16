package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.UpdateChecklistInfoRequest;
import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.response.CheckListResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.entity.RxChecklist;

/**
 * Service interface for managing {@link RxChecklistService}.request
 * 
 * @author Raghu
 */
public interface RxChecklistService {

	// public List<RxChecklist> findAll();

	/** Retrieves all List Of RxCheckListt */
	public List<CheckListResponse> getCheckList();

	/** Retrieves List Of RxCheckListt */
	public List<CheckListResponse> getCheckLisDetByTrnRxId(int trnRxId);

	/** Update a values in RxCheckListt */
	public String updateChecklistInfoProc(UpdateChecklistInfoRequest req);

}
