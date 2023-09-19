package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.RxChecklist;

public interface RxChecklistService {
	

	public List<RxChecklist> findAll();

}
