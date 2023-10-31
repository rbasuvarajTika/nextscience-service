package com.nextscience.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.dto.request.DeleteHcpInfoRequest;
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
import com.nextscience.service.CaseDetailsSaveService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class CaseDetailsServiceImpl implements CaseDetailsSaveService{
	
	 @PersistenceContext
	 private EntityManager entityManager;

	@Override
	public String updatePatientDetAndFaxRxProc(UpdatePatientTrnFaxRxRequest req) {
		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_PatientDetails_Edit");

	        // Set the parameters for the stored procedure
	        query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("FAX_ID", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("PATIENT_ID", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("PATIENT_FIRST_NAME", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("PATIENT_LAST_NAME", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("PATIENT_MIDDLE_NAME", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("DATE_OF_BIRTH", Date.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("CELL_PHONE", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("SHIP_TO_ADDRESS", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("CITY", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("STATE", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("ZIP", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("SSN", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("PLACE_OF_SERVICE", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("ORDER_TYPE", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("WOUND_ACTIVE", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("REP_NAME", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("REP_PHONE_NO", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("DISTRIBUTOR_NAME", String.class, ParameterMode.IN);

	        // Set parameter values
	        query.setParameter("USER", req.getUpdatedUser());
	        query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
	        query.setParameter("TRN_RX_ID", req.getTrnRxId());
	        query.setParameter("FAX_ID", req.getFaxId());
	        query.setParameter("PATIENT_ID", req.getPatientId());
	        query.setParameter("PATIENT_FIRST_NAME", req.getPatientFirstName());
	        query.setParameter("PATIENT_LAST_NAME", req.getPatientLastName());
	        query.setParameter("PATIENT_MIDDLE_NAME", req.getPatientMiddleName());
	        
	        query.setParameter("DATE_OF_BIRTH", req.getDateOfBirth());
	        query.setParameter("CELL_PHONE", req.getCellPhone());
	        query.setParameter("SHIP_TO_ADDRESS", req.getShipToAddress());
	        query.setParameter("CITY", req.getCity());
	        query.setParameter("STATE", req.getState());
	        query.setParameter("ZIP", req.getZip());
	        query.setParameter("SSN", req.getSsn());
	        query.setParameter("PLACE_OF_SERVICE", req.getPlaceOfService());
	        query.setParameter("ORDER_TYPE", req.getOrderType());
	        query.setParameter("WOUND_ACTIVE", req.getWoundActive());
	        query.setParameter("REP_NAME", req.getRepName());
	        query.setParameter("REP_PHONE_NO", req.getRepPhoneNo());
	        query.setParameter("DISTRIBUTOR_NAME", req.getDistributorName());

	        // Execute the stored procedure
	        query.execute();
	        return "updated successfully";
	}


	@Override
	public String updateWoundInfoProc(List<UpdateWoundInfoRequest> requests) {
		
		StoredProcedureQuery query = null; 
		
		 for(UpdateWoundInfoRequest req : requests) {
			 
			 if(req.getStatus().equalsIgnoreCase("update")) {
				 
				 query= entityManager.createStoredProcedureQuery("usp_Fax_Rx_WoundInfo_Edit");
				 query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WOUND_NO", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WOUND_LOCATION", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WOUND_LENGTH", Double.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WOUND_WIDTH", Double.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WOUND_DEPTH", Double.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WOUND_THICKNESS", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WOUND_TYPE", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("DRAINEGE", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("DEBRIDED", Integer.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("DEBRIDED_DATE", Date.class, ParameterMode.IN);
			        query.registerStoredProcedureParameter("DEBRIDED_TYPE", String.class, ParameterMode.IN);
			        query.registerStoredProcedureParameter("ICD_CODE", String.class, ParameterMode.IN);

			 
			        query.setParameter("USER", req.getUpdatedUser());
			        query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
			        query.setParameter("TRN_RX_ID", req.getTrnRxId());
			        query.setParameter("WOUND_NO", req.getWoundNo());
			        query.setParameter("WOUND_LOCATION", req.getWoundLocation());
			        query.setParameter("WOUND_LENGTH", req.getWoundLength());
			        query.setParameter("WOUND_WIDTH", req.getWoundWidth());
			        query.setParameter("WOUND_DEPTH", req.getWoundDepth());
			        query.setParameter("WOUND_THICKNESS", req.getWoundThickness());
			        query.setParameter("WOUND_TYPE", req.getWoundType());
			        query.setParameter("DRAINEGE", req.getDrainage());
			        query.setParameter("DEBRIDED", req.getDebrided());
			        query.setParameter("DEBRIDED_DATE", req.getDebridedDate());
			        query.setParameter("DEBRIDED_TYPE", req.getDebridedType());
			        query.setParameter("ICD_CODE", req.getIcdCode());
			        query.execute();
			        
			}else if(req.getStatus().equalsIgnoreCase("insert")) {
				
				query=entityManager.createStoredProcedureQuery("usp_Fax_Rx_WoundInfo_Add");
				query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		        query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WOUND_NO", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WOUND_LOCATION", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WOUND_LENGTH", BigDecimal.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WOUND_WIDTH", BigDecimal.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WOUND_DEPTH", BigDecimal.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WOUND_THICKNESS", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WOUND_TYPE", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("DRAINEGE", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("DEBRIDED", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("DEBRIDED_DATE", Date.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("DEBRIDED_TYPE", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("ICD_CODE", String.class, ParameterMode.IN);
				

				query.setParameter("USER", req.getUpdatedUser());
				query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		      	query.setParameter("WOUND_NO", req.getWoundNo());
				query.setParameter("WOUND_LOCATION", req.getWoundLocation());
				query.setParameter("WOUND_LENGTH", req.getWoundLength());
				query.setParameter("WOUND_WIDTH", req.getWoundWidth());
				query.setParameter("WOUND_DEPTH", req.getWoundDepth());
				query.setParameter("WOUND_THICKNESS", req.getWoundThickness());
				query.setParameter("WOUND_TYPE", req.getWoundType());
				query.setParameter("DRAINEGE", req.getDrainage());
				query.setParameter("DEBRIDED", req.getDebrided());
				query.setParameter("DEBRIDED_DATE", req.getDebridedDate());
				query.setParameter("DEBRIDED_TYPE", req.getDebridedType());
				query.setParameter("ICD_CODE", req.getIcdCode());
				query.execute();

				
			}else if(req.getStatus().equalsIgnoreCase("delete")) {
				
				query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_WoundInfo_Del");
				query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WOUND_NO", Integer.class, ParameterMode.IN);
				
				query.setParameter("USER", req.getUpdatedUser());
				query.setParameter("TRN_RX_ID", req.getTrnRxId());
				query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
				query.setParameter("WOUND_NO", req.getWoundNo());
				query.execute();
			}
		 }
		
		
		
        return "Updated successfully";
	}

	@Override
	public String UpdateProductInfoProc(List<UpdateProductInfoRequest> requests) {
		StoredProcedureQuery query = null;
		
		
         for(UpdateProductInfoRequest req : requests) {
			 
			 if(req.getStatus().equalsIgnoreCase("update")) {
				    query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_ProdDetails_Edit");
				 
				    query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);

					query.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);
					// query.registerStoredProcedureParameter("PRODUCT_ID", Integer.class,
					// ParameterMode.IN);

					query.registerStoredProcedureParameter("QUANTITY", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WND1", Integer.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WND2", Integer.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WND3", Integer.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("WND4", Integer.class, ParameterMode.IN);

					query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
					query.setParameter("TRN_RX_ID", req.getTrnRxId());
					query.setParameter("USER", req.getUpdatedUser());
					query.setParameter("PRODUCT_CODE", req.getProductCode());
					// query.setParameter("PRODUCT_CODE", req.getProductCode());
					query.setParameter("QUANTITY", req.getQuantity());
					query.setParameter("WND1", req.getWnd1());
					query.setParameter("WND2", req.getWnd2());
					query.setParameter("WND3", req.getWnd3());
					query.setParameter("WND4", req.getWnd4());
					query.execute();
			        
			}else if(req.getStatus().equalsIgnoreCase("insert")) {
				
				query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_ProdDetails_Add");

				query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);

				query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);

				query.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);
				// query.registerStoredProcedureParameter("PRODUCT_ID", Integer.class,
				// ParameterMode.IN);

				query.registerStoredProcedureParameter("QUANTITY", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WND1", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WND2", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WND3", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("WND4", Integer.class, ParameterMode.IN);

				query.setParameter("USER", "Admin");
				query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
				query.setParameter("TRN_RX_ID", req.getTrnRxId());

				query.setParameter("PRODUCT_CODE", req.getProductCode());
				// query.setParameter("PRODUCT_ID", req.getProductId());
				query.setParameter("QUANTITY", req.getQuantity());
				query.setParameter("WND1", req.getWnd1());
				query.setParameter("WND2", req.getWnd2());
				query.setParameter("WND3", req.getWnd3());
				query.setParameter("WND4", req.getWnd4());
				query.execute();

				
			}else if(req.getStatus().equalsIgnoreCase("delete")) {
				query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_ProdDetails_Del");
				query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);

				query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);

				query.setParameter("USER", "Admin");
				query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
				query.setParameter("TRN_RX_ID", req.getTrnRxId());
				query.setParameter("PRODUCT_CODE", req.getProductCode());
				query.execute();
			}
		 }
		
		
		
		return "Updated successfully";
	}
		
		
		
		
	

	@Override
	public String updateHcpProc(List<UpdateHcpInfoRequest> requests) {
		StoredProcedureQuery query = null;
		
		
        for(UpdateHcpInfoRequest req : requests) {
			 
			 if(req.getStatus().equalsIgnoreCase("update")) {
				    query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Physician_Edit");
				 

					query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
					query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
							query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);

							query.registerStoredProcedureParameter("PROF_ID", Integer.class, ParameterMode.IN);
							//query.registerStoredProcedureParameter("HCP_ID", Integer.class, ParameterMode.IN);
							query.registerStoredProcedureParameter("SIGNATURE_FLAG", Integer.class, ParameterMode.IN);
							query.registerStoredProcedureParameter("SIGNATURE_DATE", Date.class, ParameterMode.IN);
							query.registerStoredProcedureParameter("FIRST_NAME", String.class, ParameterMode.IN);
							query.registerStoredProcedureParameter("MIDDLE_NAME", String.class, ParameterMode.IN);
							query.registerStoredProcedureParameter("LAST_NAME", String.class, ParameterMode.IN);
							query.registerStoredProcedureParameter("NPI", String.class, ParameterMode.IN);
						
							
							query.setParameter("USER", req.getUpdatedUser());
							query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
					        query.setParameter("TRN_RX_ID", req.getTrnRxId());

							query.setParameter("PROF_ID", req.getHcpId());
							//query.setParameter("HCP_ID", req.getHcpId());
							query.setParameter("SIGNATURE_FLAG", req.getSignature_Flag());
							query.setParameter("SIGNATURE_DATE", req.getSignature_Date());
							query.setParameter("FIRST_NAME", req.getFirstName());
							query.setParameter("MIDDLE_NAME", req.getMiddleName());
							query.setParameter("LAST_NAME", req.getLastName());
							query.setParameter("NPI", req.getNpi());
							query.execute();
							
			        
			}else if(req.getStatus().equalsIgnoreCase("insert")) {
				
				query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Physician_Add");
				query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("PROVIDER_TYPE", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("NPI", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("FIRST_NAME", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("MIDDLE_NAME", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("LAST_NAME", String.class, ParameterMode.IN);
				
				query.registerStoredProcedureParameter("SIGNATURE_FLAG", Integer.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("SIGNATURE_DATE", Date.class, ParameterMode.IN);
				
				query.setParameter("USER", "Admin");
				query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
				query.setParameter("PROVIDER_TYPE", 2);
				query.setParameter("NPI", req.getNpi());
				query.setParameter("FIRST_NAME", req.getFirstName());
				query.setParameter("MIDDLE_NAME", req.getMiddleName());
				query.setParameter("LAST_NAME", req.getLastName());
				
				query.setParameter("SIGNATURE_FLAG", req.getSignature_Flag());
				query.setParameter("SIGNATURE_DATE", req.getSignature_Date());
				query.execute();
				
			}
		 }
		
			return "updated Successfully";
		}


		

	@Override
	public String updateOffInfoProc(UpdateOfficeInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Office_Edit");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ACCOUNT_ID", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("ACCOUNT_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CELL_PHONE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("EMAIL", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SHIP_TO_ADDRESS", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CITY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("STATE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ZIP", String.class, ParameterMode.IN);
		
		
		query.setParameter("USER", req.getUpdatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());

		query.setParameter("ACCOUNT_ID", req.getAccountId());
		query.setParameter("ACCOUNT_NAME", req.getAccountName());
      	query.setParameter("CELL_PHONE", req.getPhone());
		query.setParameter("EMAIL", req.getEmail());
		query.setParameter("SHIP_TO_ADDRESS", req.getAddress1());
		query.setParameter("CITY", req.getCity());
		query.setParameter("STATE", req.getState());
		query.setParameter("ZIP", req.getZip());
		
		query.execute();
		return CommonConstants.UPDATEDSUCCESSFULLY;
	}

	@Override
	public String updateChecklistInfoProc(UpdateChecklistInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Checklist_Edit");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("RX_CHECKLIST_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CHECKLIST_FLAG", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("COMMENTS", String.class, ParameterMode.IN);
		
		
		query.setParameter("USER", req.getUpdatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());
      	query.setParameter("RX_CHECKLIST_ID", req.getRxChecklistId());
		query.setParameter("CHECKLIST_FLAG", req.getChecklist_Flag());
		query.setParameter("COMMENTS", req.getComments());
		
		query.execute();
		
		return CommonConstants.UPDATEDSUCCESSFULLY;
	}

	@Override
	public String insertWoundInfoProc(List<InsertWoundInfoRequest> requests) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_WoundInfo_Add");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_NO", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_LOCATION", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_LENGTH", BigDecimal.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_WIDTH", BigDecimal.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_DEPTH", BigDecimal.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_THICKNESS", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_TYPE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("DRAINEGE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("DEBRIDED", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("DEBRIDED_DATE", Date.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("DEBRIDED_TYPE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ICD_CODE", String.class, ParameterMode.IN);
		
		for(InsertWoundInfoRequest req : requests) {
		query.setParameter("USER", req.getCreatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
      	query.setParameter("WOUND_NO", req.getWoundNo());
		query.setParameter("WOUND_LOCATION", req.getWoundLocation());
		query.setParameter("WOUND_LENGTH", req.getWoundLength());
		query.setParameter("WOUND_WIDTH", req.getWoundWidth());
		query.setParameter("WOUND_DEPTH", req.getWoundDepth());
		query.setParameter("WOUND_THICKNESS", req.getWoundThickness());
		query.setParameter("WOUND_TYPE", req.getWoundType());
		query.setParameter("DRAINEGE", req.getDrainage());
		query.setParameter("DEBRIDED", req.getDebrided());
		query.setParameter("DEBRIDED_DATE", req.getDebridedDate());
		query.setParameter("DEBRIDED_TYPE", req.getDebridedType());
		query.setParameter("ICD_CODE", req.getIcdCode());
	
		query.execute();
		}

		return "created successfully";
	}
	

	@Override
	public String InsertProductInfoProc(List<InsertProductInfoRequest> requests) {
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_ProdDetails_Add");

		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);
		// query.registerStoredProcedureParameter("PRODUCT_ID", Integer.class,
		// ParameterMode.IN);

		query.registerStoredProcedureParameter("QUANTITY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND1", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND2", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND3", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND4", Integer.class, ParameterMode.IN);

		for(InsertProductInfoRequest req : requests) {
		query.setParameter("USER", req.getCreatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());

		query.setParameter("PRODUCT_CODE", req.getProductCode());
		// query.setParameter("PRODUCT_ID", req.getProductId());
		query.setParameter("QUANTITY", req.getQuantity());
		query.setParameter("WND1", req.getWnd1());
		query.setParameter("WND2", req.getWnd2());
		query.setParameter("WND3", req.getWnd3());
		query.setParameter("WND4", req.getWnd4());

		query.execute();
		}
		return "created successfully";
	}
		
	

	@Override
	public String InsertHcpInfoProc(List<InsertHcpInfoRequest> requests) {
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Physician_Add");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PROVIDER_TYPE", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("NPI", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FIRST_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("MIDDLE_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("LAST_NAME", String.class, ParameterMode.IN);
		
		query.registerStoredProcedureParameter("SIGNATURE_FLAG", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SIGNATURE_DATE", Date.class, ParameterMode.IN);
		
		
		for(InsertHcpInfoRequest req : requests) {
		query.setParameter("USER", req.getCreateUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("PROVIDER_TYPE", req.getProviderType());
		query.setParameter("NPI", req.getNpi());
		query.setParameter("FIRST_NAME", req.getFirstName());
		query.setParameter("MIDDLE_NAME", req.getMiddleName());
		query.setParameter("LAST_NAME", req.getLastName());
		
		query.setParameter("SIGNATURE_FLAG", req.getSignature_Flag());
		query.setParameter("SIGNATURE_DATE", req.getSignature_Date());
		
		
		query.execute();
		}
				
		return "created successfully";
	}


	@Override
	public String DeleteWoundInfoProc(List<DeleteWoundInfoRequest> requests) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_WoundInfo_Del");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_NO", Integer.class, ParameterMode.IN);
		
		for(DeleteWoundInfoRequest req : requests) {
		 query.setParameter("USER", req.getUser());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("WOUND_NO", req.getWoundNo());
		query.execute();
		}
		
		return "Deleted successfully";
	}
	


	@Override
	public String DeleteProductInfoProc(List<DeleteProductInfoRequest> requests) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_ProdDetails_Del");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);

		for(DeleteProductInfoRequest req : requests) {
		query.setParameter("USER", req.getUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());
		query.setParameter("PRODUCT_CODE", req.getProductCode());
		query.execute();
		}

		return "Deleted Successfully";
	}	

	@Override
	public String DeleteHcpInfoProc(List<DeleteHcpInfoRequest> requests) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Physician_Del");
		
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("HCP_ID", Integer.class, ParameterMode.IN);
		
		for(DeleteHcpInfoRequest req : requests) {
		query.setParameter("USER", "Admin");
		query.setParameter("HCP_ID", req.getHcpId());
		query.execute();
		}
		return "deleted successfully";
	}
	
	

}
