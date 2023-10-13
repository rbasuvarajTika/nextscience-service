package com.nextscience.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRx;

public interface FaxRxService {

	// Fetches a paginated list of fax prescriptions
	public PageResponseDTO fetchList(PageRequest page);

	// Retrieves fax prescription by ID.
	public FaxRx fetchListById(String faxId);

	// Retrieves a list of duplicate fax prescriptions.
	public List<DupeRxResponse> getDuplicateResponse();

	// Retrieves a list of duplicate fax prescriptions by ID.
	public List<DupeRxResponse> getDuplicateByIdResponse(String faxId);

	// Updates fax prescription information.
	public String updatefax(String dupeTrnFaxId, String mainTrnFaxId);

	// Keeps a duplicate fax prescription.
	public String keepDuplicate(String trnFaxId);

}
