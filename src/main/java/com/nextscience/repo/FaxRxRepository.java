package com.nextscience.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.FaxRx;

@Repository
public interface FaxRxRepository extends JpaRepository<FaxRx, Integer> {

	@Query(nativeQuery = true, value = "SELECT a.TRN_FAX_ID as trnFaxId, a.FAX_ID as faxId, "
			+ "b.CASE_ID as caseId, a.FAX_STATUS as faxStatus, "
			+ "CASE WHEN b.DUPE_FAX_ID IS NULL THEN 'NA' ELSE b.DUPE_FAX_ID END as dupeFaxId, "
			+ "a.FAX_DATE as faxDate, a.FAX_NUMBER as faxNumber, " + "a.OCR_STATUS as ocrStatus, a.OCR_DATE as ocrDate "
			+ "FROM TRN_FAX_RX a " + "JOIN BRDG_FAX_RX_CASES b ON (a.TRN_FAX_ID = b.TRN_FAX_ID)")
	Page<Object[]> fetchFaxList(PageRequest page);

}
