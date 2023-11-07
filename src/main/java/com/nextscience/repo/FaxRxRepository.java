package com.nextscience.repo;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.FaxRx;

/**
 * Repository interface for managing {@link FaxRxRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface FaxRxRepository extends JpaRepository<FaxRx, Integer> {

	@Query(nativeQuery = true, value = "SELECT a.TRN_FAX_ID as trnFaxId, a.FAX_ID as faxId, \r\n"
			+ "b.CASE_ID as caseId, a.FAX_STATUS as faxStatus, \r\n"
			+ "CASE WHEN b.DUPE_FAX_ID IS NULL THEN 'NA' ELSE b.DUPE_FAX_ID END as dupeFaxId, \r\n"
			+ "a.FAX_DATE as faxDate, a.FAX_NUMBER as faxNumber, a.OCR_STATUS as ocrStatus, a.OCR_DATE as ocrDate ,\r\n"
			+ "[FAX_RECEIVED_DATE] faxDateTime,\r\n"
			+ "case when b.VERIFIED_FLAG=1 then 'Yes' else 'No' end VERIFIED_FLAG,\r\n"
			+ "case when b.ACTION_REQUIRED=1 then 'Yes' else 'No' end ACTION_REQUIRED\r\n"
			+ "FROM TRN_FAX_RX a JOIN BRDG_FAX_RX_CASES b ON (a.TRN_FAX_ID = b.TRN_FAX_ID) ORDER BY b.CASE_ID ASC")
	Page<Object[]> fetchFaxList(PageRequest page);

	@Query(nativeQuery = true, value = "SELECT a.TRN_FAX_ID as trnFaxId, a.FAX_ID as faxId, "
			+ "b.CASE_ID as caseId, a.FAX_STATUS as faxStatus, "
			+ "CASE WHEN b.DUPE_FAX_ID IS NULL THEN 'NA' ELSE b.DUPE_FAX_ID END as dupeFaxId, "
			+ "a.FAX_DATE as faxDate, a.FAX_NUMBER as faxNumber, " + "a.OCR_STATUS as ocrStatus, a.OCR_DATE as ocrDate "
			+ "FROM TRN_FAX_RX a " + "JOIN BRDG_FAX_RX_CASES b ON (a.TRN_FAX_ID = b.TRN_FAX_ID) AND a.FAX_ID=: faxId")
	Object[] fetchFaxList(@Param(value = "faxId") int faxId);

	FaxRx findByFaxId(String faxId);
	
	

	@Query(nativeQuery = true, value = "SELECT a.[TRN_FAX_ID]\r\n" + ",a.FAX_ID\r\n" + ",b.CASE_ID\r\n"
			+ ",a.FAX_STATUS\r\n" + ",case when b.DUPE_FAX_ID is null then 'NA' else b.DUPE_FAX_ID end DUPE_FAX_ID\r\n"
			+ ",a.FAX_DATE\r\n" + ",a.FAX_NUMBER\r\n" + ",a.OCR_STATUS\r\n" + ",a.OCR_DATE\r\n"
			+ ",a.FAX_URL,case when b.VERIFIED_FLAG=1 then 'Yes' else 'No' end VERIFIED_FLAG\r\n"
			+ ",concat(p.FIRST_NAME,' ',p.LAST_NAME) HCP_NAME\r\n" + ",h.ACCOUNT_NAME\r\n"
			+ ",concat(r.PATIENT_FIRST_NAME,' ',r.PATIENT_LAST_NAME) PATIENT_NAME\r\n"
			+ "FROM [NEXTSCI_DEV].[dbo].[TRN_FAX_RX] a\r\n"
			+ "join [BRDG_FAX_RX_CASES] b on (a.[CASE_ID]=b.[CASE_ID])\r\n"
			+ "join [DIM_HCP] p on (a.[PROF_ID]=p.[HCP_ID])\r\n"
			+ "join [DIM_ACCOUNT] h on (a.[ACCOUNT_ID]=h.[ACCOUNT_ID])\r\n"
			+ "join [DIM_PATIENT] r on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n" + "where b.CASE_TYPE='Duplicate'")
	List<Object[]> getDupeResponse();


	/*
	 * @Query(nativeQuery = true, value = "UPDATE TRN_FAX_RX \r\n" +
	 * "    SET PLACE_OF_SERVICE = :PLACE_OF_SERVICE, \r\n" +
	 * "        ORDER_TYPE = :ORDER_TYPE, \r\n" +
	 * "        WOUND_ACTIVE = :WOUND_ACTIVE, \r\n" +
	 * "        REP_NAME = :REP_NAME, \r\n" +
	 * "        REP_PHONE_NO = :REP_PHONE_NO, \r\n" +
	 * "        DISTRIBUTOR_ID = :DISTRIBUTOR_ID,  \r\n" +
	 * "        UPDATED_USER = :USER, \r\n" +
	 * "        UPDATED_DATE = GETDATE() \r\n" +
	 * "    WHERE  TRN_FAX_ID = :TRN_FAX_ID AND \r\n" +
	 * "           FAX_ID = :FAX_ID  AND \r\n" +
	 * "           PATIENT_ID = :PATIENT_ID") int updateFaxRxDetails(@Param(value =
	 * "PLACE_OF_SERVICE") String placeOfService,
	 * 
	 * @Param(value = "ORDER_TYPE") String orderType,
	 * 
	 * @Param(value = "WOUND_ACTIVE") Integer woundActive,
	 * 
	 * @Param(value = "REP_NAME") String repName,
	 * 
	 * @Param(value = "REP_PHONE_NO") String repPhoneNo,
	 * 
	 * @Param(value = "DISTRIBUTOR_ID") String state,
	 * 
	 * @Param(value = "USER") String user,
	 * 
	 * @Param(value = "TRN_FAX_ID") Integer trnFaxId,
	 * 
	 * @Param(value = "FAX_ID") String faxId,
	 * 
	 * @Param(value = "PATIENT_ID") Integer patientId);
	 * 
	 * 
	 */
}
