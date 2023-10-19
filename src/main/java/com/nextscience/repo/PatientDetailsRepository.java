package com.nextscience.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.PatientDetails;

/**
 * Repository interface for managing {@link PatientDetailsRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer> {

	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID,b.CASE_ID,b.FAX_DATE,b.FAX_NUMBER,b.FAX_URL\r\n"
			+ ",a.PATIENT_ID,concat(r.PATIENT_FIRST_NAME,' ',r.PATIENT_LAST_NAME) PATIENT_NAME\r\n"
			+ ",r.PATIENT_FIRST_NAME,r.PATIENT_MIDDLE_NAME,r.PATIENT_LAST_NAME,r.DATE_OF_BIRTH ,r.CELL_PHONE \r\n" + ",r.SHIP_TO_ADDRESS ,r.CITY ,r.[STATE] ,r.ZIP,r.SSN\r\n"
			+ ",r.WORK_PHONE,r.GENDER ,r.ZIP4,r.MRN,r.PMS_ID,r.MARITIAL_STATUS\r\n"
			+ ",r.EMERGENCY_CONTACT_NAME,r.EMERGENCY_CONTACT_PHONE\r\n"
			+ ",b.PLACE_OF_SERVICE, b.ORDER_TYPE,b.WOUND_ACTIVE\r\n"
			+ ",b.REP_NAME, b.REP_PHONE_NO,d.DISTRIBUTOR_ID,d.DISTRIBUTOR_NAME\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_PATIENT] r on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n"
			+ "left join [DIM_DISTRIBUTOR] d on (b.[DISTRIBUTOR_ID]=d.[DISTRIBUTOR_ID])")
	List<Object[]> getRxPatientList();

	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID,b.CASE_ID,b.FAX_DATE,b.FAX_NUMBER,b.FAX_URL\r\n"
			+ ",a.PATIENT_ID,concat(r.PATIENT_FIRST_NAME,' ',r.PATIENT_LAST_NAME) PATIENT_NAME\r\n"
			+ ",r.PATIENT_FIRST_NAME,r.PATIENT_MIDDLE_NAME,r.PATIENT_LAST_NAME,r.DATE_OF_BIRTH ,r.CELL_PHONE \r\n" + ",r.SHIP_TO_ADDRESS ,r.CITY ,r.[STATE] ,r.ZIP,r.SSN\r\n"
			+ ",r.WORK_PHONE,r.GENDER ,r.ZIP4,r.MRN,r.PMS_ID,r.MARITIAL_STATUS\r\n"
			+ ",r.EMERGENCY_CONTACT_NAME,r.EMERGENCY_CONTACT_PHONE\r\n"
			+ ",b.PLACE_OF_SERVICE, b.ORDER_TYPE,b.WOUND_ACTIVE\r\n"
			+ ",b.REP_NAME, b.REP_PHONE_NO,d.DISTRIBUTOR_ID,d.DISTRIBUTOR_NAME\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_PATIENT] r on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n"
			+ "left join [DIM_DISTRIBUTOR] d on (b.[DISTRIBUTOR_ID]=d.[DISTRIBUTOR_ID])\r\n"
			+ "WHERE a.[TRN_RX_ID]=:TRN_RX_ID")
	List<Object[]> getRxPatientDetByTrnRxId(@Param(value = "TRN_RX_ID") int trnRxId);

}
