package com.nextscience.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertWoundInfoRequest;
import com.nextscience.dto.request.UpdateWoundInfoRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxWoundInfo;

import com.nextscience.repo.FaxRxWoundInfoRepository;
import com.nextscience.service.FaxRxWoundInfoService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

/**
 * Service Class for managing {@link FaxRxWoundInfoImpl}.request
 * 
 * @author Raghu
 */

@Service
public class FaxRxWoundInfoImpl implements FaxRxWoundInfoService {

	@Autowired
	FaxRxWoundInfoRepository faxRxWoundInfoRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<WoundInfoResponse> getRxWoundInfoList() {
		List<Object[]> woundInfoResponse = faxRxWoundInfoRepository.getRxWoundInfoList();
		List<WoundInfoResponse> responses = woundInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}

	private WoundInfoResponse mapToObjectsArray(Object[] row) {
		WoundInfoResponse response = new WoundInfoResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setWoundNo((Integer) row[3]);
		response.setWoundLocation((String) row[4]);
		response.setWoundLength((BigDecimal) row[5]);
		response.setWoundWidth((BigDecimal) row[6]);
		response.setWoundDepth((BigDecimal) row[7]);
		response.setWoundThickness((String) row[8]);
		response.setWoundType((String) row[9]);
		response.setDrainage((String) row[10]);
		response.setDebrided((Integer) row[11]);
		response.setDebridedDate((Date) row[12]);
		response.setDebridedType((String) row[13]);
		response.setIcdCode((String) row[14]);
		return response;

	}

	@Override
	public List<WoundInfoResponse> getRxWoundDetByTrnRxId(int trnRxId) {
		List<Object[]> woundInfoResponse = faxRxWoundInfoRepository.getRxWoundDetByTrnRxId(trnRxId);
		List<WoundInfoResponse> responses = woundInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}

	@Override
	public String insertWoundInfoProc(InsertWoundInfoRequest req) {
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

		return "created successfully";
	}

	@Override
	public String updateWoundInfoProc(UpdateWoundInfoRequest req) {		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_WoundInfo_Edit");
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
        return "Updated successfully";
		
	}

	@Override
	public String DeleteWoundInfoProc(DeleteWoundInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_WoundInfo_Del");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WOUND_NO", Integer.class, ParameterMode.IN);
		
		 query.setParameter("USER", req.getUser());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("WOUND_NO", req.getWoundNo());
		query.execute();
		
		return "Deleted successfully";
	}
}

/*
 * @Override public List<FaxRxWoundInfo> findAll() { // TODO Auto-generated
 * method stub return faxRxWoundInfoRepository.findAll(); }
 */
