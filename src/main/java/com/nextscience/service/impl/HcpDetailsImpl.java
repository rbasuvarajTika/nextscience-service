package com.nextscience.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.request.InsertHcpInfoRequest;
import com.nextscience.dto.request.UpdateHcpInfoRequest;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.FaxRxWoundProductInfo;
import com.nextscience.entity.HcpDetails;
import com.nextscience.repo.HcpDetailsRepository;
import com.nextscience.service.HcpDetailsService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

/**
 * Service Class for managing {@link HcpDetailsImpl}.request
 * 
 * @author Raghu
 */

@Service
public class HcpDetailsImpl implements HcpDetailsService {

	@Autowired
	HcpDetailsRepository hcpDetailsRepository;
	
	@PersistenceContext
	 private EntityManager entityManager;

	@Override
	public List<HcpInfoResponse> getHcpInfoList() {
		List<Object[]> hcpInfoResponse=hcpDetailsRepository.getHcpInfoList();
		List<HcpInfoResponse> responses = hcpInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}
	private HcpInfoResponse mapToObjectsArray(Object[] row) {
		HcpInfoResponse response = new HcpInfoResponse();
		
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setHcpId((Integer) row[3]);
		response.setHcp_first_Name((String) row[4]);
		response.setHcp_last_Name((String) row[5]);
		response.setProvider_Type((String) row[6]);
		response.setNpi((String) row[7]);
		response.setSignature_Flag((String) row[8]);
		response.setSignature_Date((Date) row[9]);
		return response;
	}
	@Override
	public List<HcpInfoResponse> getHcpDetByTrnRxId(int trnRxId) {
		List<Object[]> hcpInfoResponse=hcpDetailsRepository.getHcpDetByTrnRxId(trnRxId);
		List<HcpInfoResponse> responses = hcpInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
		
	}
	@Override
	public String updateHcpProc(UpdateHcpInfoRequest req) {
		 
	StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Physician_Edit");
	query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);

			query.registerStoredProcedureParameter("PROF_ID", Integer.class, ParameterMode.IN);
			//query.registerStoredProcedureParameter("HCP_ID", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("SIGNATURE_FLAG", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("SIGNATURE_DATE", Date.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("FIRST_NAME", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("MIDDLE_NAME", Date.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("LAST_NAME", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("NPI", Date.class, ParameterMode.IN);
			
			
			
			query.setParameter("USER", req.getUpdatedUser());
			query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
	        query.setParameter("TRN_RX_ID", req.getTrnRxId());

			query.setParameter("PROF_ID", req.getProfId());
			//query.setParameter("HCP_ID", req.getHcpId());
			query.setParameter("SIGNATURE_FLAG", req.getSignature_Flag());
			query.setParameter("SIGNATURE_DATE", req.getSignature_Date());
			query.setParameter("FIRST_NAME", req.getFirstName());
			query.setParameter("MIDDLE_NAME", req.getMiddleName());
			query.setParameter("LAST_NAME", req.getLastName());
			query.setParameter("NPI", req.getNpi());

			
			query.execute();

		return "updated Successfully";
	}
	@Override
	public String InsertHcpInfoProc(InsertHcpInfoRequest req) {
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Physician_Add");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PROVIDER_TYPE", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SIGNATURE_FLAG", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SIGNATURE_DATE", Date.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("NPI", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FIRST_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("MIDDLE_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("LAST_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPECIALTY1", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ADDRESS1", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ADDRESS2", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CITY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("STATE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ZIP", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PHONE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FAX", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("EMAIL", String.class, ParameterMode.IN);
		
		
		query.setParameter("USER", req.getCreateUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("PROVIDER_TYPE", req.getProviderType());
		query.setParameter("SIGNATURE_FLAG", req.getSignature_Flag());
		query.setParameter("SIGNATURE_DATE", req.getSignature_Date());
		query.setParameter("NPI", req.getNpi());
		query.setParameter("FIRST_NAME", req.getFirstName());
		query.setParameter("MIDDLE_NAME", req.getMiddleName());
		query.setParameter("LAST_NAME", req.getLastName());
		query.setParameter("SPECIALTY1", req.getSpecialty1());
		query.setParameter("ADDRESS1", req.getAddress1());
		query.setParameter("ADDRESS2", req.getAddress2());
		query.setParameter("CITY", req.getCity());
		query.setParameter("STATE", req.getState());
		query.setParameter("ZIP", req.getZip());
		query.setParameter("PHONE", req.getPhone());
		query.setParameter("FAX", req.getFax());
		query.setParameter("EMAIL", req.getEmail());
		query.execute();
				
		return "created successfully";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @Override public List<HcpDetails> findAllHcpDetails( String cellPhone, String
	 * email, String address1, String city, String state, String zip) {
	 * 
	 * return hcpDetailsRepository.findAllHcpDetails( cellPhone, email, address1,
	 * city, state, zip);
	 * 
	 * }
	 */
	 
	 

	
	
	  
	 

}
