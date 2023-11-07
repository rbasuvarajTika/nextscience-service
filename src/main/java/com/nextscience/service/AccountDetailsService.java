package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.DeleteOfficeInfoRequest;
import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.InsertOfficeInfoRequest;
import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.response.OfficeAccResponse;

/**
 * Service interface for managing {@link AccountDetailsService}.request
 * 
 * @author Raghu
 */

public interface AccountDetailsService {

	// List<AccountDetails> findAll();

	/** Retrieves a list of office account details. */
	public List<OfficeAccResponse> getAccountList();

	/** Retrieves office account details by transaction ID. */
	public List<OfficeAccResponse> getAccDetByTrnRxId(int trnRxId);

	/** Updates office information. */
	public String updateOffInfoProc(UpdateOfficeInfoRequest req);
	
	/** Delete office information. */
	public String DeleteOfficeInfoProc(DeleteOfficeInfoRequest req);
	
	/** Insert values in HcpInfo */
	public String InsertOfficeInfoProc(InsertOfficeInfoRequest req);
	
	
	

}
