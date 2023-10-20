package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.dto.request.CaseDetailsSaveRequest;
import com.nextscience.dto.request.DeleteProductInfoRequest;
import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.InsertProductInfoRequest;
import com.nextscience.dto.request.InsertWoundInfoRequest;
import com.nextscience.dto.request.UpdateChecklistInfoRequest;
import com.nextscience.dto.request.UpdateHcpInfoRequest;
import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.request.UpdateProductInfoRequest;
import com.nextscience.dto.request.UpdateWoundInfoRequest;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.service.CaseDetailsSaveService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class CaseDetailsSaveController {

	@Autowired
	private CaseDetailsSaveService caseDetailsSaveService;

	@SuppressWarnings("unchecked")
	@PostMapping("/savePatientDetails")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<CaseDetailsSaveRequest> savePatientDetails(@RequestBody CaseDetailsSaveRequest request) {

		UpdatePatientTrnFaxRxRequest updatePatientRequest = request.getUpdatePatient();
		List<UpdateWoundInfoRequest> updateWoundRequest = request.getUpdateWound();
		List<UpdateProductInfoRequest> updateProductRequest = request.getUpdateProduct();
		List<UpdateHcpInfoRequest> updateHcpRequest = request.getUpdateHcp();
		UpdateOfficeInfoRequest updateOfficeRequest = request.getUpdateOffice();
		UpdateChecklistInfoRequest updateChecklistRequest = request.getUpdateChecklist();

		List<InsertWoundInfoRequest> insertWoundRequest = request.getInsertWound();
		List<InsertProductInfoRequest> insertProductRequest = request.getInsertProduct();
		List<InsertHcpInfoRequest> insertHcpRequest = request.getInsertHcp();
		
		List<DeleteWoundInfoRequest> deleteWoundRequest = request.getDeleteWound();
		List<DeleteProductInfoRequest> deleteProductRequest = request.getDeleteProduct();
		
		
		if(updatePatientRequest !=null || updatePatientRequest.getPatientId() !=null ||updatePatientRequest.getFaxId()!=null )
		   caseDetailsSaveService.updatePatientDetAndFaxRxProc(updatePatientRequest);
		if(updateWoundRequest !=null ||updateWoundRequest.get(0).getTrnFaxId()!=0 || updateWoundRequest.get(0).getWoundNo()!=null)
		   caseDetailsSaveService.updateWoundInfoProc(updateWoundRequest);
		if(updateProductRequest !=null ||updateProductRequest.get(0).getTrnFaxId()!=0 || updateProductRequest.get(0).getProductCode()!=null )
		   caseDetailsSaveService.UpdateProductInfoProc(updateProductRequest);
		if(updateHcpRequest !=null || updateHcpRequest.get(0).getTrnFaxId()!=0 || updateHcpRequest.get(0).getProfId()!=0)
		   caseDetailsSaveService.updateHcpProc(updateHcpRequest);
		if(updateOfficeRequest !=null || updateOfficeRequest.getAccountId()!=null )
		   caseDetailsSaveService.updateOffInfoProc(updateOfficeRequest);
		if(updateChecklistRequest !=null ||updateChecklistRequest.getTrnFaxId()!=null||updateChecklistRequest.getTrnFaxId()!=null || updateChecklistRequest.getChecklist_Flag()!=null )
		   caseDetailsSaveService.updateChecklistInfoProc(updateChecklistRequest);
		
		if(insertWoundRequest !=null)
		   caseDetailsSaveService.insertWoundInfoProc(insertWoundRequest);
		if(insertProductRequest !=null)
		   caseDetailsSaveService.InsertProductInfoProc(insertProductRequest);
		if(insertHcpRequest !=null)
		   caseDetailsSaveService.InsertHcpInfoProc(insertHcpRequest);
		if(deleteWoundRequest !=null)
			   caseDetailsSaveService.DeleteWoundInfoProc(deleteWoundRequest);
		if(deleteProductRequest !=null)
			   caseDetailsSaveService.DeleteProductInfoProc(deleteProductRequest);
		

		return ResponseHelper.createResponse(new
				  NSServiceResponse<>(), "Succfully Added/Updated", CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);

	}

}
