package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextscience.dto.request.DeleteFaxRxSplitHistRequest;
import com.nextscience.dto.request.InsertFaxRxSplitHistRequest;
import com.nextscience.dto.request.UpdateFaxRxSplitHistRequest;
import com.nextscience.dto.response.FaxRxSplitHistResponse;
import com.nextscience.dto.response.OfficeAccResponse;
import com.nextscience.dto.response.RxLookupResponse;
import com.nextscience.entity.FaxRxSplitHist;
import com.nextscience.repo.FaxRxSplitHistRepository;
import com.nextscience.service.FaxRxSplitHistService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class FaxRxSplitHistImpl implements FaxRxSplitHistService {

	@Autowired
	FaxRxSplitHistRepository faxRxSplitHistRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public String InsertFaxRxSplitHistInfoProc(InsertFaxRxSplitHistRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Split_Add");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FAX_ID", String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("MAIN_FILE_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPLIT_FAX_ID", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPLIT_FILE_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("FAX_URL", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPLIT_PAGES", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PAGE_COUNT", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPLIT_TYPE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPLIT_ATTEMPTS", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPLIT_STATUS", String.class, ParameterMode.IN);

		query.setParameter("USER", req.getCreatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("FAX_ID", req.getFaxId());

		query.setParameter("MAIN_FILE_NAME", req.getMainFileName());
		query.setParameter("SPLIT_FAX_ID", req.getSplitFaxId());
		query.setParameter("SPLIT_FILE_NAME", req.getSplitFileName());
		query.setParameter("FAX_URL", req.getFaxUrl());
		query.setParameter("SPLIT_PAGES", req.getSplitPages());
		query.setParameter("PAGE_COUNT", req.getPageCount());
		query.setParameter("SPLIT_TYPE", req.getSplitType());
		query.setParameter("SPLIT_ATTEMPTS", req.getSplitAttempts());
		query.setParameter("SPLIT_STATUS", req.getSplitStatus());

		query.execute();

		return "created successfully";

	}

	@Override
	public List<FaxRxSplitHistResponse> getAllFaxRxSPlitHistResponses() {
		List<Object[]> resultList = faxRxSplitHistRepository.getALL();
		List<FaxRxSplitHistResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	private FaxRxSplitHistResponse mapToObjectsArray(Object[] row) {
		FaxRxSplitHistResponse response = new FaxRxSplitHistResponse();
		response.setTrnFaxSplitId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setFaxFileName((String) row[3]);
		response.setSplitFaxId((String) row[4]);
		response.setSplitFileName((String) row[5]);
		response.setFaxUrl((String) row[6]);
		response.setSplitType((String) row[7]);
		response.setSplitAttempts((String) row[8]);
		response.setSplitStatus((String) row[9]);
		response.setSplitPages((String) row[10]);
		response.setPageCount((Integer) row[11]);
		response.setCreatedUser((String) row[12]);
		response.setCreatedDate((Date) row[13]);
		response.setUpdatedUser((String) row[14]);
		response.setUpdatedDate((Date) row[15]);

		return response;

	}

	@Override
	public List<FaxRxSplitHistResponse> getByFaxId(String faxId) {
		List<Object[]> resultList = faxRxSplitHistRepository.getByFaxId(faxId);
		List<FaxRxSplitHistResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	@Transactional
	public String DeleteFaxRxSplitHistInfoProc(DeleteFaxRxSplitHistRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Split_Hist_Del");
		query.registerStoredProcedureParameter("TRN_FAX_SPLIT_ID", Integer.class, ParameterMode.IN);

		query.setParameter("TRN_FAX_SPLIT_ID", req.getTrnFaxSplitId());
		query.execute();

		return "deleted successfully";
	}

	@Override
	@Transactional
	public String updateFaxRxSplitHistInfoProc(UpdateFaxRxSplitHistRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Split_Hist_Edit");	
		query.registerStoredProcedureParameter("TRN_FAX_SPLIT_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPLIT_STATUS", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("SPLIT_ATTEMPTS", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
				
		query.setParameter("TRN_FAX_SPLIT_ID", req.getTrnFaxSplitId());
		query.setParameter("SPLIT_STATUS", req.getSplitStatus());	
		query.setParameter("SPLIT_ATTEMPTS", req.getSplitAttempts());
		query.setParameter("USER", req.getUpdatedUser());
		
		query.execute();

		return "updated successfully";

	}

}
