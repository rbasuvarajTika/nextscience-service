package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextscience.dto.request.FaxRxConfirmRequest;
import com.nextscience.dto.request.RemoveRxNotesRequest;
import com.nextscience.dto.response.ShowPrevRxHcpsResponse;
import com.nextscience.repo.FaxRxRepository;
import com.nextscience.service.ValidateNotesService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class ValidateNotesServiceImpl implements ValidateNotesService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	FaxRxRepository faxRxRepository;

	@Override
	public String removeRxNotes(RemoveRxNotesRequest request) {

		Integer trnFaxIdMain = faxRxRepository.findTrnFaxRxId(request.getFaxIdMain());
		Integer trnFaxIdDuplicate = faxRxRepository.findTrnFaxRxId(request.getFaxIdDuplicate());

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_RX_Detach_NotestoRX");

		// Set the parameters for the stored procedure
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID1", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID2", Integer.class, ParameterMode.IN);

		// Set parameter values
		query.setParameter("USER", request.getUserName());
		query.setParameter("TRN_FAX_ID1", trnFaxIdMain);
		query.setParameter("TRN_FAX_ID2", trnFaxIdDuplicate);

		// Execute the stored procedure
		query.execute();
		return "updated successfully";
	}

	@Override
	public List<ShowPrevRxHcpsResponse> showNotesPrevRxHcps(FaxRxConfirmRequest request) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_Show_Notes_PrevRXHCPs");

		// Set the parameters for the stored procedure
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);

		// Set parameter values
		query.setParameter("USER", request.getUserName());
		query.setParameter("TRN_FAX_ID", request.getTrnFaxId());

		// Execute the stored procedure
		List<Object[]> list = query.getResultList();
		List<ShowPrevRxHcpsResponse> response = list.stream().map(this::mapToObjectArray).collect(Collectors.toList());

		return response;
	}

	private ShowPrevRxHcpsResponse mapToObjectArray(Object[] row) {
		ShowPrevRxHcpsResponse response = new ShowPrevRxHcpsResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setCaseId((Integer) row[3]);
		response.setFaxDate((Date) row[4]);
		response.setFaxNumber((String) row[5]);
		response.setFaxUrl((String) row[6]);
		response.setVerifiedFlag((String) row[7]);
		response.setHcpName((String) row[8]);
		response.setProviderType((String) row[9]);
		response.setHcpAddress2((String) row[10]);
		response.setHcpAddress2((String) row[11]);
		response.setHcpCity((String) row[12]);
		response.setHcpState((String) row[13]);
		response.setHcpZip((String) row[14]);
		response.setAccountName((String) row[15]);
		response.setAccAddress1((String) row[16]);
		response.setAccCity((String) row[17]);
		response.setAccState((String) row[18]);
		response.setAccZip((String) row[19]);
		response.setPatientName((String) row[20]);
		response.setDateOfBirth((Date) row[21]);
		response.setGender((String) row[22]);
		response.setCellPhone((String) row[23]);
		response.setWorkPhone((String) row[24]);
		response.setShipToAddress((String) row[25]);
		response.setPatientCity((String) row[26]);
		response.setPatientState((String) row[27]);
		response.setPatientZip((String) row[28]);
		response.setPatientZip4((String) row[29]);
		response.setSsn((String) row[30]);
		response.setMrn((String) row[31]);
		response.setPmsId((String) row[32]);
		response.setMaritialStatus((String) row[33]);
		response.setEmergencyContactName((String) row[34]);
		response.setEmergencyContactPhone((String) row[35]);
		response.setProductCode((String) row[36]);
		response.setProductDisplayName((String) row[37]);
		response.setWndCode((String) row[38]);
		return response;
	}

}
