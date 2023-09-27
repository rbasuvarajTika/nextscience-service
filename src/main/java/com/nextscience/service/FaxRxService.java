package com.nextscience.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRx;

public interface FaxRxService {


	public PageResponseDTO fetchList(PageRequest page);
	
	public FaxRx fetchListById(String faxId);
	

	public List<DupeRxResponse> getDuplicateResponse();
	
	public List<DupeRxResponse> getDuplicateByIdResponse(String faxId);

	

	FaxRx updatefax(String dupeTrnFaxId, String mainTrnFaxId);

	public String keepDuplicate(String trnFaxId);

	

	

}
