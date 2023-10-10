package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.CheckListResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.RxChecklist;

public interface RxChecklistService {
	

	//public List<RxChecklist> findAll();
	public List<CheckListResponse> getCheckList();

}
