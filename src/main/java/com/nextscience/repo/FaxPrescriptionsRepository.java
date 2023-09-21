package com.nextscience.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.FaxPrescriptions;

@Repository
public interface FaxPrescriptionsRepository extends JpaRepository<FaxPrescriptions, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID,b.CASE_ID,b.FAX_DATE,b.FAX_NUMBER,b.FAX_URL\r\n"
			+ ",case when cp.VERIFIED_FLAG=1 then 'Yes' else 'No' end VERIFIED_FLAG\r\n"
			+ ",concat(p.FIRST_NAME,' ',p.LAST_NAME) HCP_NAME,c.PROVIDER_TYPE\r\n"
			+ ",p.ADDRESS1,p.ADDRESS2 ,p.CITY ,p.[STATE] ,p.ZIP \r\n"
			+ ",h.ACCOUNT_NAME,h.ADDRESS1,h.CITY,h.[STATE],h.ZIP\r\n"
			+ ",concat(r.PATIENT_FIRST_NAME,' ',r.PATIENT_LAST_NAME) PATIENT_NAME\r\n"
			+ ",r.DATE_OF_BIRTH ,r.GENDER ,r.CELL_PHONE ,r.WORK_PHONE\r\n"
			+ ",r.SHIP_TO_ADDRESS ,r.CITY ,r.[STATE] ,r.ZIP ,r.ZIP4\r\n"
			+ ",r.SSN,r.MRN,r.PMS_ID,r.MARITIAL_STATUS,r.EMERGENCY_CONTACT_NAME,r.EMERGENCY_CONTACT_PHONE\r\n"
			+ ",pr.PRODUCT_CODE,pr.PRODUCT_DISPLAY_NAME,wp.WND_CODE\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "join [BRDG_FAX_RX_CASES] cp on (a.[TRN_FAX_ID]=cp.[TRN_FAX_ID])\r\n"
			+ "join [BRDG_FAX_RX_PROVIDER] c on (a.[TRN_FAX_ID]=c.[TRN_FAX_ID])\r\n"
			+ "join [DIM_HCP] p on (c.[HCP_ID]=p.[HCP_ID])\r\n"
			+ "join [DIM_ACCOUNT] h on (a.[ACCOUNT_ID]=h.[ACCOUNT_ID])\r\n"
			+ "join [DIM_PATIENT] r on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n"
			+ "join [BRDG_FAX_RX_WOUND_PRODUCT_INFO] wp on (a.[TRN_FAX_ID]=wp.[TRN_FAX_ID])\r\n"
			+ "join [DIM_PRODUCT] pr on (wp.[PRODUCT_ID]=pr.PRODUCT_ID)")
	List<Object[]> getFaxRxPrscTrackerList();


}