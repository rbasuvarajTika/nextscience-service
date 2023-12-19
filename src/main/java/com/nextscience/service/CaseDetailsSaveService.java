package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.DeleteHcpInfoRequest;
import com.nextscience.dto.request.DeleteProductInfoRequest;
import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.FaxRxAttachNotesToRaxRequest;
import com.nextscience.dto.request.FaxRxConfirmRequest;
import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.InsertProductInfoRequest;
import com.nextscience.dto.request.InsertTrnFaxRxPriscrRequest;
import com.nextscience.dto.request.InsertTrnFaxRxRequest;
import com.nextscience.dto.request.InsertWoundInfoRequest;
import com.nextscience.dto.request.NewFaxRxAdd;
import com.nextscience.dto.request.UpdateChecklistInfoRequest;
import com.nextscience.dto.request.UpdateHcpInfoRequest;
import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.request.UpdateProductInfoRequest;
import com.nextscience.dto.request.UpdateWoundInfoRequest;
import com.nextscience.dto.response.ShowPrevRxHcpsResponse;
import com.nextscience.dto.response.ShowPrevRxNameSearch;

public interface CaseDetailsSaveService {

	public String updatePatientDetAndFaxRxProc(UpdatePatientTrnFaxRxRequest req);

	public String updateWoundInfoProc(List<UpdateWoundInfoRequest> requests);

	public String UpdateProductInfoProc(List<UpdateProductInfoRequest> requests);

	public String updateHcpProc(List<UpdateHcpInfoRequest> requests);

	public String updateOffInfoProc(UpdateOfficeInfoRequest req);

	public String updateChecklistInfoProc(UpdateChecklistInfoRequest req);

	public String insertWoundInfoProc(List<InsertWoundInfoRequest> requests);

	public String InsertProductInfoProc(List<InsertProductInfoRequest> requests);

	public String InsertHcpInfoProc(List<InsertHcpInfoRequest> requests);

	public String DeleteWoundInfoProc(List<DeleteWoundInfoRequest> requests);

	public String DeleteProductInfoProc(List<DeleteProductInfoRequest> requests);

	/** Delete values Hcp information. */
	public String DeleteHcpInfoProc(List<DeleteHcpInfoRequest> req);

	public String addTrnFaxRxDetails(InsertTrnFaxRxRequest request);

	public String addTrnFaxRxPriscrDetails(InsertTrnFaxRxPriscrRequest request);

	public String updateFaxRxConfirm(FaxRxConfirmRequest request);

	public String updateFaxRxAttachNotes(FaxRxAttachNotesToRaxRequest request);

	public String addNewFaxRx(NewFaxRxAdd request);

	public List<ShowPrevRxHcpsResponse> showPrevRxNameSearch(String patientName, String hcpName);

	public List<ShowPrevRxHcpsResponse> showprevRxHcps(FaxRxConfirmRequest request);

}
