package com.nextscience.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.dto.request.DeleteOfficeInfoRequest;
import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertOfficeInfoRequest;
import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.OfficeAccResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.repo.AccountDetailsRepository;
import com.nextscience.service.AccountDetailsService;
import com.nextscience.service.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

/**
 * Service Class for managing {@link AccountDetailsImpl}.request
 * 
 * @author Raghu
 */
@Service
public class AccountDetailsImpl implements AccountDetailsService {

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<OfficeAccResponse> getAccountList() {
		List<Object[]> officeAccResponse = accountDetailsRepository.getAccountList();
		List<OfficeAccResponse> responses = officeAccResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}

	private OfficeAccResponse mapToObjectsArray(Object[] row) {
		OfficeAccResponse response = new OfficeAccResponse();

		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setAccountId((Integer) row[3]);
		response.setAccountName((String) row[4]);
		response.setPhone((String) row[5]);
		response.setEmail((String) row[6]);
		response.setAddress1((String) row[7]);
		response.setCity((String) row[8]);
		response.setState((String) row[9]);
		response.setZip((String) row[10]);
		return response;
	}

	@Override
	public List<OfficeAccResponse> getAccDetByTrnRxId(int trnRxId) {
		List<Object[]> officeAccResponse = accountDetailsRepository.getAccDetByTrnRxId(trnRxId);
		List<OfficeAccResponse> responses = officeAccResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;

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
	public String DeleteOfficeInfoProc(DeleteOfficeInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Office_Del");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ACCOUNT_ID", Integer.class, ParameterMode.IN);

		query.setParameter("USER", req.getUser());
		query.setParameter("ACCOUNT_ID", req.getAccountId());

		query.execute();

		return "Deleted successfully";
	}

	@Override
	public String InsertOfficeInfoProc(InsertOfficeInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Office_Add");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ACCOUNT_NAME", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CELL_PHONE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("EMAIL", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("CITY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("STATE", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("ZIP", String.class, ParameterMode.IN);
		
		query.setParameter("USER", req.getCreatedUser());
		query.setParameter("ACCOUNT_NAME", req.getAccountName());
		query.setParameter("CELL_PHONE", req.getPhone());
		query.setParameter("EMAIL", req.getEmail());
		query.setParameter("CITY", req.getCity());
		query.setParameter("STATE", req.getState());
		query.setParameter("ZIP", req.getZip());
		
		query.execute();
		

		return "Created Successfully";
	}

}

/*
 * @Override public List<AccountDetails> findAll() { // TODO Auto-generated
 * method stub return accountDetailsRepository.findAll(); }
 */
