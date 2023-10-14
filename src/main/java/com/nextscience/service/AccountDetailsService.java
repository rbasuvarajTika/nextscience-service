package com.nextscience.service;

import java.util.List;
import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.response.OfficeAccResponse;

/**
 * Service interface for managing {@link AccountDetailsService}.
 * 
 * @author Raghu
 */

public interface AccountDetailsService {

	// List<AccountDetails> findAll();

	/** Retrieves a list of office account details.*/
	public List<OfficeAccResponse> getAccountList();

	/** Retrieves office account details by transaction ID.*/
	public List<OfficeAccResponse> getAccDetByTrnRxId(int trnRxId);

	/** Updates office information.*/
	public String updateOffInfoProc(UpdateOfficeInfoRequest req);

}
