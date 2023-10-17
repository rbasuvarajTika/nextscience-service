package com.nextscience.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.dto.request.UpdateChecklistInfoRequest;
import com.nextscience.dto.response.CheckListResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.entity.ProductDetails;
import com.nextscience.entity.RxChecklist;
import com.nextscience.repo.RxChecklistRepository;
import com.nextscience.service.RxChecklistService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

/**
 * Service Class for managing {@link RxChecklistImpl}.request
 * 
 * @author Raghu
 */

@Service
public class RxChecklistImpl implements RxChecklistService {
	
	@Autowired
	RxChecklistRepository rxChecklistRepository;
	
	@PersistenceContext
	 private EntityManager entityManager;

	@Override
	public List<CheckListResponse> getCheckList() {
		List<Object[]> checkListResponse=rxChecklistRepository.getCheckList();
		List<CheckListResponse> responses = checkListResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
		
	}
	private CheckListResponse mapToObjectsArray(Object[] row) {
		CheckListResponse response = new CheckListResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setRxChecklistId((Integer) row[3]);
		response.setRxChecklistDesc((String) row[4]);
		response.setChecklist_Flag((String) row[5]);
		response.setComments((String) row[6]);
		return response;
	}
	@Override
	public List<CheckListResponse> getCheckLisDetByTrnRxId(int trnRxId) {
		List<Object[]> checkListResponse=rxChecklistRepository.getCheckLisDetByTrnRxId(trnRxId);
		List<CheckListResponse> responses = checkListResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
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
		
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<RxChecklist> findAll() { // TODO Auto-generated method
	 * stub return rxChecklistRepository.findAll(); }
	 */

}
