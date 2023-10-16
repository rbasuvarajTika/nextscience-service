package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertWoundInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.request.UpdateWoundInfoRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.entity.FaxRxWoundInfo;

/**
 * Service interface for managing {@link FaxRxWoundInfoService}.request
 * 
 * @author Raghu
 */
public interface FaxRxWoundInfoService {

	// public List<FaxRxWoundInfo> findAll();

	/** Retrieves a List of RxWoundInfo. */
	public List<WoundInfoResponse> getRxWoundInfoList();

	/** Retrieves a List of RxWoundInfoByTrnRxId. */
	public List<WoundInfoResponse> getRxWoundDetByTrnRxId(int trnRxId);

	/** Insert values in RxWoundInfo */
	public String insertWoundInfoProc(InsertWoundInfoRequest req);

	/** Updates values in RxWoundInfo */
	public String updateWoundInfoProc(UpdateWoundInfoRequest req);

	/** Delete values in RxWoundInfo */
	public String DeleteWoundInfoProc(DeleteWoundInfoRequest req);

}
