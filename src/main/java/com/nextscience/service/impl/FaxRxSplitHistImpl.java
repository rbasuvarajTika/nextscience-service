package com.nextscience.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextscience.dto.request.InsertFaxRxSplitHistRequest;
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
		
		
		
		query.setParameter("USER", req.getCreatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
        query.setParameter("FAX_ID", req.getFaxId());

		query.setParameter("MAIN_FILE_NAME", req.getMainFileName());
		query.setParameter("SPLIT_FAX_ID", req.getSplitFaxId());
		query.setParameter("SPLIT_FILE_NAME", req.getSplitFileName());
		query.setParameter("FAX_URL", req.getFaxUrl());
		query.setParameter("SPLIT_PAGES", req.getSplitPages());
		query.setParameter("PAGE_COUNT", req.getPageCount());
		
		
		query.execute();
		
		return "created successfully";
		
		

	}
}
