package com.nextscience.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextscience.Constants.FaxPrescriptionsConstant;
import com.nextscience.dto.response.FaxPrscTrkWoundResponse;
import com.nextscience.dto.response.FaxRxTrackerDetailsResponse;
import com.nextscience.dto.response.FaxRxTrackerResponse;
import com.nextscience.entity.FaxPrescriptions;
import com.nextscience.repo.FaxPrescriptionsRepository;
import com.nextscience.service.FaxPrescriptionsService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Service Class for managing {@link FaxPrescriptionsImpl}.request
 * 
 * @author Raghu
 */

@Service
public class FaxPrescriptionsImpl implements FaxPrescriptionsService {

	@Autowired
	FaxPrescriptionsRepository faxPrescriptionsRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<FaxPrescriptions> findAll() {
		// TODO Auto-generated method stub
		return faxPrescriptionsRepository.findAll();
	}

	@Override
	public List<FaxRxTrackerResponse> getFaxRxTrackerList() {
		List<Object[]> faxRxTrackerResponse = faxPrescriptionsRepository.getFaxRxTrackerList();
		List<FaxRxTrackerResponse> responses = faxRxTrackerResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}

	private FaxRxTrackerResponse mapToObjectsArray(Object[] row) {
		FaxRxTrackerResponse response = new FaxRxTrackerResponse();

		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setCaseId((Integer) row[3]);
		response.setFaxDate((Date) row[4]);
		response.setFaxNumber((String) row[5]);
		response.setFaxUrl((String) row[6]);
		response.setVerifiedFlag((String) row[7]);
		response.setProviderType((String) row[8]);
		response.setHcpName((String) row[9]);
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

	private FaxRxTrackerDetailsResponse mapToObjectsArrays(Object[] row) {
		FaxRxTrackerDetailsResponse response = new FaxRxTrackerDetailsResponse();

		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setCaseId((Integer) row[3]);
		response.setFaxDate((Date) row[4]);
		response.setFaxNumber((String) row[5]);
		response.setFaxUrl((String) row[6]);
		response.setVerifiedFlag((String) row[7]);
		response.setHcpName((String) row[8]);
		response.setHcpAddress1((String) row[9]);
		response.setHcpAddress2((String) row[10]);
		response.setHcpCity((String) row[11]);
		response.setHcpState((String) row[12]);
		response.setHcpZip((String) row[13]);
		response.setAccountName((String) row[14]);
		response.setAccAddress1((String) row[15]);
		response.setAccCity((String) row[16]);
		response.setAccState((String) row[17]);
		response.setAccZip((String) row[18]);
		response.setPatientName((String) row[19]);
		response.setDateOfBirth((Date) row[20]);
		response.setGender((String) row[21]);
		response.setCellPhone((String) row[22]);
		response.setWorkPhone((String) row[23]);
		response.setShipToAddress((String) row[24]);
		response.setPatientCity((String) row[25]);
		response.setPatientState((String) row[26]);
		response.setPatientZip((String) row[27]);
		response.setPatientZip4((String) row[28]);
		response.setSsn((String) row[29]);
		response.setMrn((String) row[30]);
		response.setPmsId((String) row[31]);
		response.setMaritialStatus((String) row[32]);
		response.setEmergencyContactName((String) row[33]);
		response.setEmergencyContactPhone((String) row[34]);
		response.setProcessStatus((String) row[35]);
		response.setRxFulfilmentStatus((String) row[36]);
		response.setNetsuiteRxId((String) row[37]);
		response.setPrimaryPayerName((String) row[38]);
		response.setPrimaryPayerId((Integer) row[39]);
		response.setPatientId((Integer) row[40]);
		response.setPayerType((String) row[41]);

		return response;
	}

	@Override
	public List<FaxRxTrackerDetailsResponse> getFaxRxTrackerDetailsList() {
		List<Object[]> faxRxTrackerResponse = faxPrescriptionsRepository.getFaxRxTrackerDetailsList();
		List<FaxRxTrackerDetailsResponse> responses = faxRxTrackerResponse.stream().map(this::mapToObjectsArrays)
				.collect(Collectors.toList());

		return responses;
	}

	@Override
	public List<FaxPrscTrkWoundResponse> getFaxRxTrkWoundDetailsList() {
		List<Object[]> faxPrscTrkkWoundResponse = faxPrescriptionsRepository.getFaxRxTrkWoundDetailsList();
		List<FaxPrscTrkWoundResponse> responses = faxPrscTrkkWoundResponse.stream().map(this::mapToObjectsArrayFax)
				.collect(Collectors.toList());

		return responses;
	}

	private FaxPrscTrkWoundResponse mapToObjectsArrayFax(Object[] row) {
		FaxPrscTrkWoundResponse response = new FaxPrscTrkWoundResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setCaseId((Integer) row[3]);
		response.setFaxDate((Date) row[4]);
		response.setFaxNumber((String) row[5]);
		response.setFaxUrl((String) row[6]);
		response.setWoundNo((Integer) row[8]);
		response.setWoundLocation((String) row[9]);
		response.setWoundLength((BigDecimal) row[10]);
		response.setWoundWidth((BigDecimal) row[11]);
		response.setWoundDepth((BigDecimal) row[12]);
		response.setWoundThickness((String) row[13]);
		response.setDrainage((String) row[14]);
		response.setDebrided((Integer) row[15]);
		response.setDebridedDate((Date) row[16]);
		response.setIcdCode((String) row[17]);
		return response;
	}

	@Override
	public List<FaxRxTrackerDetailsResponse> getFaxRxTrackerListById(int trnRxId) {
		List<Object[]> faxRxTrackerResponse = faxPrescriptionsRepository.getFaxRxTrackerDetailsList(trnRxId);
		List<FaxRxTrackerDetailsResponse> responses = faxRxTrackerResponse.stream().map(this::mapToObjectsArrays)
				.collect(Collectors.toList());

		return responses;
	}

	@Override
	public List<FaxRxTrackerDetailsResponse> getFaxRxTrackerListByCaseId(int caseId) {
		List<Object[]> faxRxTrackerResponse = faxPrescriptionsRepository.getFaxRxTrackerCaseList(caseId);
		List<FaxRxTrackerDetailsResponse> responses = faxRxTrackerResponse.stream().map(this::mapToObjectsArrays)
				.collect(Collectors.toList());

		return responses;
	}

	@Override
	public List<FaxPrscTrkWoundResponse> getWoundByIdResponse(int trnRxId) {
		List<Object[]> faxPrscTrkkWoundResponse = faxPrescriptionsRepository.getFaxRxTrkWoundDetailsList(trnRxId);
		List<FaxPrscTrkWoundResponse> responses = faxPrscTrkkWoundResponse.stream().map(this::mapToObjectsArrayFax)
				.collect(Collectors.toList());

		return responses;

	}

	@Override
	public List<FaxPrscTrkWoundResponse> getWoundByCaseId(int caseId) {
		List<Object[]> faxPrscTrkkWoundResponse = faxPrescriptionsRepository.getFaxRxTrkWoundCaseList(caseId);
		List<FaxPrscTrkWoundResponse> responses = faxPrscTrkkWoundResponse.stream().map(this::mapToObjectsArrayFax)
				.collect(Collectors.toList());

		return responses;

	}

	@Override
	public List<FaxRxTrackerDetailsResponse> getFaxRxTrackerDetailsListNew(String columnName, String sort, int page,
			int pageSize) {
		String getColumn = getColumnName(columnName);

		String formattedQuery = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID,b.CASE_ID,b.FAX_DATE,b.FAX_NUMBER,b.FAX_URL\r\n"
				+ "					,case when cp.VERIFIED_FLAG=1 then 'Yes' else 'No' end VERIFIED_FLAG\r\n"
				+ "					,concat(p.FIRST_NAME,' ',p.LAST_NAME) HCP_NAME\r\n"
				+ "					,p.ADDRESS1,p.ADDRESS2 ,p.CITY ,p.[STATE] ,p.ZIP \r\n"
				+ "					,h.ACCOUNT_NAME,h.ADDRESS1,h.CITY,h.[STATE],h.ZIP\r\n"
				+ "					,concat(r.PATIENT_FIRST_NAME,' ',r.PATIENT_LAST_NAME) PATIENT_NAME\r\n"
				+ "					,r.DATE_OF_BIRTH ,r.GENDER ,r.CELL_PHONE ,r.WORK_PHONE\r\n"
				+ "					,r.SHIP_TO_ADDRESS ,r.CITY ,r.[STATE] ,r.ZIP ,r.ZIP4\r\n"
				+ "					,r.SSN,r.MRN,r.PMS_ID,r.MARITIAL_STATUS,r.EMERGENCY_CONTACT_NAME,r.EMERGENCY_CONTACT_PHONE\r\n"
				+ "					,a.PROCESS_STATUS,a.RX_STATUS RX_FULFILMENT_STATUS\r\n"
				+ "					,a.NETSUITE_RX_ID\r\n" + "					,i.PAYER_NAME PRIMARY_PAYER_NAME\r\n"
				+ "					,i.PAYER_ID PRIMARY_PAYER_ID\r\n"
				+ "					,r.PATIENT_ID, i.PAYER_TYPE \r\n"
				+ "					FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
				+ "					join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
				+ "					join [BRDG_FAX_RX_CASES] cp on (a.[TRN_FAX_ID]=cp.[TRN_FAX_ID])\r\n"
				+ "					left join [DIM_HCP] p on (a.[PROF_ID]=p.[HCP_ID])\r\n"
				+ "					left join [DIM_ACCOUNT] h on (a.[ACCOUNT_ID]=h.[ACCOUNT_ID])\r\n"
				+ "					left join [DIM_PATIENT] r on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n"
				+ "					left join DIM_PAYER i on (a.PAYER_ID=i.PAYER_ID)";
		StringBuilder sql = new StringBuilder(formattedQuery).append(" ORDER BY ").append(getColumn).append(" ")
				.append(sort).append(" ").append(" OFFSET ").append(page).append(" ").append(" ROWS ")
				.append(" FETCH NEXT ").append(pageSize).append(" ROWS ONLY ");

		Query nativeQuery = entityManager.createNativeQuery(sql.toString());

		List<Object[]> listDetails = nativeQuery.getResultList();

		List<FaxRxTrackerDetailsResponse> faxRxResponses = listDetails.stream().map(this::mapsToObjectsArrays)
				.collect(Collectors.toList());
		return faxRxResponses;
	}

	private String getColumnName(String columnName) {
		String setColumn;
		switch (columnName) {
		case "caseId":
			setColumn = FaxPrescriptionsConstant.CASEID;
			break;
		case "processStatus":
			setColumn = FaxPrescriptionsConstant.PROCESSSTATUS;
			break;
		case "rxFulfilmentStatus":
			setColumn = FaxPrescriptionsConstant.RXFULFILMENTSTATUS;
			break;
		case "netsuiteRxId":
			setColumn = FaxPrescriptionsConstant.NETSUITERXID;
			break;
		case "faxId":
			setColumn = FaxPrescriptionsConstant.FAXID;
			break;
		case "patientName":
			setColumn = FaxPrescriptionsConstant.PATIENTNAME;
			break;
		case "patientId":
			setColumn = FaxPrescriptionsConstant.PATIENTID;
			break;
		case "hcpName":
			setColumn = FaxPrescriptionsConstant.HCPNAME;
			break;
		case "accountName":
			setColumn = FaxPrescriptionsConstant.ACCOUNTNAME;
			break;
		case "primaryPayerName":
			setColumn = FaxPrescriptionsConstant.PRIMARYPAYERNAME;
			break;
		case "payerType":
			setColumn = FaxPrescriptionsConstant.PAYERTYPE;
			break;
		default:
			setColumn = FaxPrescriptionsConstant.TRNRXID;
			break;
		}

		return setColumn;

	}

	private FaxRxTrackerDetailsResponse mapsToObjectsArrays(Object[] row) {
		FaxRxTrackerDetailsResponse response = new FaxRxTrackerDetailsResponse();

		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setCaseId((Integer) row[3]);
		response.setFaxDate((Date) row[4]);
		response.setFaxNumber((String) row[5]);
		response.setFaxUrl((String) row[6]);
		response.setVerifiedFlag((String) row[7]);
		response.setHcpName((String) row[8]);
		response.setHcpAddress1((String) row[9]);
		response.setHcpAddress2((String) row[10]);
		response.setHcpCity((String) row[11]);
		response.setHcpState((String) row[12]);
		response.setHcpZip((String) row[13]);
		response.setAccountName((String) row[14]);
		response.setAccAddress1((String) row[15]);
		response.setAccCity((String) row[16]);
		response.setAccState((String) row[17]);
		response.setAccZip((String) row[18]);
		response.setPatientName((String) row[19]);
		response.setDateOfBirth((Date) row[20]);
		response.setGender((String) row[21]);
		response.setCellPhone((String) row[22]);
		response.setWorkPhone((String) row[23]);
		response.setShipToAddress((String) row[24]);
		response.setPatientCity((String) row[25]);
		response.setPatientState((String) row[26]);
		response.setPatientZip((String) row[27]);
		response.setPatientZip4((String) row[28]);
		response.setSsn((String) row[29]);
		response.setMrn((String) row[30]);
		response.setPmsId((String) row[31]);
		response.setMaritialStatus((String) row[32]);
		response.setEmergencyContactName((String) row[33]);
		response.setEmergencyContactPhone((String) row[34]);
		response.setProcessStatus((String) row[35]);
		response.setRxFulfilmentStatus((String) row[36]);
		response.setNetsuiteRxId((String) row[37]);
		response.setPrimaryPayerName((String) row[38]);
		response.setPrimaryPayerId((Integer) row[39]);
		response.setPatientId((Integer) row[40]);
		response.setPayerType((String) row[41]);

		return response;
	}

	@Override
	public List<FaxRxTrackerDetailsResponse> filterFaxRxTrackerDetailsList(String hcpName, String accountName,
			String patientName) {
		int i = 0;
		StringBuilder filter = new StringBuilder();
		StringBuilder executeSql = new StringBuilder();
		String formattedQuery = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID,b.CASE_ID,b.FAX_DATE,b.FAX_NUMBER,b.FAX_URL\r\n"
				+ "					,case when cp.VERIFIED_FLAG=1 then 'Yes' else 'No' end VERIFIED_FLAG\r\n"
				+ "					,concat(p.FIRST_NAME,' ',p.LAST_NAME) HCP_NAME\r\n"
				+ "					,p.ADDRESS1,p.ADDRESS2 ,p.CITY ,p.[STATE] ,p.ZIP \r\n"
				+ "					,h.ACCOUNT_NAME,h.ADDRESS1,h.CITY,h.[STATE],h.ZIP\r\n"
				+ "					,concat(r.PATIENT_FIRST_NAME,' ',r.PATIENT_LAST_NAME) PATIENT_NAME\r\n"
				+ "					,r.DATE_OF_BIRTH ,r.GENDER ,r.CELL_PHONE ,r.WORK_PHONE\r\n"
				+ "					,r.SHIP_TO_ADDRESS ,r.CITY ,r.[STATE] ,r.ZIP ,r.ZIP4\r\n"
				+ "					,r.SSN,r.MRN,r.PMS_ID,r.MARITIAL_STATUS,r.EMERGENCY_CONTACT_NAME,r.EMERGENCY_CONTACT_PHONE\r\n"
				+ "					,a.PROCESS_STATUS,a.RX_STATUS RX_FULFILMENT_STATUS\r\n"
				+ "					,a.NETSUITE_RX_ID\r\n" + "					,i.PAYER_NAME PRIMARY_PAYER_NAME\r\n"
				+ "					,i.PAYER_ID PRIMARY_PAYER_ID\r\n"
				+ "					,r.PATIENT_ID, i.PAYER_TYPE \r\n"
				+ "					FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
				+ "					join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
				+ "					join [BRDG_FAX_RX_CASES] cp on (a.[TRN_FAX_ID]=cp.[TRN_FAX_ID])\r\n"
				+ "					left join [DIM_HCP] p on (a.[PROF_ID]=p.[HCP_ID])\r\n"
				+ "					left join [DIM_ACCOUNT] h on (a.[ACCOUNT_ID]=h.[ACCOUNT_ID])\r\n"
				+ "					left join [DIM_PATIENT] r on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n"
				+ "					left join DIM_PAYER i on (a.PAYER_ID=i.PAYER_ID)";

		if (!hcpName.isEmpty()) {
			filter.append("( FIRST_NAME LIKE '%").append(hcpName).append("%'").append(" OR ")
					.append(" LAST_NAME LIKE '%").append(hcpName).append("%'").append(")").append(" AND ");
		}
		if (!accountName.isEmpty()) {
			filter.append(" ACCOUNT_NAME LIKE '%").append(accountName).append("%'").append(" AND ");
		}
		if (!patientName.isEmpty()) {
			filter.append("( PATIENT_FIRST_NAME LIKE '%").append(patientName).append("%'").append(" OR ")
					.append(" PATIENT_LAST_NAME LIKE '%").append(patientName).append("%'").append(")");
		}
		StringBuilder sql = new StringBuilder(formattedQuery).append(" WHERE ").append(filter);
		int length = sql.toString().length();
		if (sql.toString().endsWith(" AND ")) {
			String getFilter = sql.toString().substring(0, length - 4);
			executeSql.append(getFilter);
		} else if (sql.toString().endsWith(" WHERE ")) {
			String getSql = sql.toString().substring(0, length - 7);
			executeSql.append(getSql);
		} else {
			executeSql.append(sql);
		}

		executeSql.append(" ORDER BY ").append(" TRN_FAX_ID ASC");
		Query nativeQuery = entityManager.createNativeQuery(executeSql.toString());

		List<Object[]> listDetails = nativeQuery.getResultList();

		List<FaxRxTrackerDetailsResponse> faxRxResponses = listDetails.stream().map(this::mapsToObjectsArrays)
				.collect(Collectors.toList());
		return faxRxResponses;
	}

}
