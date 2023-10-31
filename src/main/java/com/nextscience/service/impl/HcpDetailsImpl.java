package com.nextscience.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextscience.dto.request.DeleteHcpInfoRequest;
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
		List<HcpInfoResponse> responsesMap = hcpInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		List<HcpInfoResponse> responses = responsesMap.stream().filter(e->e.getHcpId()!=null).collect(Collectors.toList());
		return responses;
	}
	private HcpInfoResponse mapToObjectsArray(Object[] row) {
		HcpInfoResponse response = new HcpInfoResponse();
		
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setHcpId((Integer) row[3]);
		response.setFirstName((String) row[4]);
		response.setMiddleName((String) row[5]);
		response.setLastName((String) row[6]);
		response.setProvider_Type((String) row[7]);
		response.setNpi((String) row[8]);
		response.setSignature_Flag((Integer) row[9]);
		response.setSignature_Date((Date) row[10]);
		response.setProfId((Integer) row[3]);
		return response;
	}
	@Override
	public List<HcpInfoResponse> getHcpDetByTrnRxId(int trnRxId) {
		List<Object[]> hcpInfoResponse=hcpDetailsRepository.getHcpDetByTrnRxId(trnRxId);
		List<HcpInfoResponse> responsesMap = hcpInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		List<HcpInfoResponse> responses = responsesMap.stream().filter(e->e.getHcpId()!=null).collect(Collectors.toList());
		return responses;
		
	}
	@Override
	@Transactional
	public String updateHcpProc(UpdateHcpInfoRequest req) {
		 
	StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Physician_Edit");
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
	@Transactional
	public String InsertHcpInfoProc(InsertHcpInfoRequest req) {
		
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
				
		return "created successfully";
	}
	@Override
	public String DeleteHcpInfoProc(DeleteHcpInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Physician_Del");
		
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("HCP_ID", Integer.class, ParameterMode.IN);
		query.setParameter("USER", req.getUser());
		query.setParameter("HCP_ID", req.getHcpId());
		query.execute();
		return "deleted successfully";
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
