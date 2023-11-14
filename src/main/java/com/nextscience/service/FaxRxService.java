package com.nextscience.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nextscience.dto.request.FaxRxDupeRequest;
import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.response.DupeRxResponse;

import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRx;

/**
 * Service interface for managing {@link FaxRxService}.request
 * 
 * @author Raghu
 */
public interface FaxRxService {

	/** Fetches a paginated list of faxRx */
	public PageResponseDTO fetchList(PageRequest page);

	/** Retrieves faxRx by ID. */
	public FaxRx fetchListById(String faxId);

	/** Retrieves a list of duplicate faxRx. */
	public List<DupeRxResponse> getDuplicateResponse();

	/** Retrieves a list of duplicate faxRx by ID. */
	public List<DupeRxResponse> getDuplicateByIdResponse(String faxId);

	/** Updates faxRx information. */
	public String updatefax(String dupeTrnFaxId, String mainTrnFaxId);

	/** Keeps a duplicate faxRx. */
	public String keepDuplicate(String trnFaxId);
	
	
	public String faxRxValidateProc(FaxRxDupeRequest req);
	
	public FaxRx faxRxSendMail(String faxId);

	public void updatePdfInDatabase(String trnFaxId, byte[] rotatedPdfBytes);

	
	
	

}
