package com.nextscience.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.PatientDetails;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer> {

	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID,b.CASE_ID,b.FAX_DATE,b.FAX_NUMBER,b.FAX_URL\r\n"
			+ ",a.PATIENT_ID,concat(r.PATIENT_FIRST_NAME,' ',r.PATIENT_LAST_NAME) PATIENT_NAME\r\n"
			+ ",r.DATE_OF_BIRTH ,r.CELL_PHONE \r\n" + ",r.SHIP_TO_ADDRESS ,r.CITY ,r.[STATE] ,r.ZIP,r.SSN\r\n"
			+ ",r.WORK_PHONE,r.GENDER ,r.ZIP4,r.MRN,r.PMS_ID,r.MARITIAL_STATUS\r\n"
			+ ",r.EMERGENCY_CONTACT_NAME,r.EMERGENCY_CONTACT_PHONE\r\n"
			+ ",b.PLACE_OF_SERVICE, b.ORDER_TYPE,b.WOUND_ACTIVE\r\n"
			+ ",b.REP_NAME, b.REP_PHONE_NO,d.DISTRIBUTOR_ID,d.DISTRIBUTOR_NAME\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_PATIENT] r on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n"
			+ "left join [DIM_DISTRIBUTOR] d on (a.[PATIENT_ID]=r.[PATIENT_ID])")
	List<Object[]> getRxPatientList();
	
	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID,b.CASE_ID,b.FAX_DATE,b.FAX_NUMBER,b.FAX_URL\r\n"
			+ ",a.PATIENT_ID,concat(r.PATIENT_FIRST_NAME,' ',r.PATIENT_LAST_NAME) PATIENT_NAME\r\n"
			+ ",r.DATE_OF_BIRTH ,r.CELL_PHONE \r\n" + ",r.SHIP_TO_ADDRESS ,r.CITY ,r.[STATE] ,r.ZIP,r.SSN\r\n"
			+ ",r.WORK_PHONE,r.GENDER ,r.ZIP4,r.MRN,r.PMS_ID,r.MARITIAL_STATUS\r\n"
			+ ",r.EMERGENCY_CONTACT_NAME,r.EMERGENCY_CONTACT_PHONE\r\n"
			+ ",b.PLACE_OF_SERVICE, b.ORDER_TYPE,b.WOUND_ACTIVE\r\n"
			+ ",b.REP_NAME, b.REP_PHONE_NO,d.DISTRIBUTOR_ID,d.DISTRIBUTOR_NAME\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_PATIENT] r on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n"
			+ "left join [DIM_DISTRIBUTOR] d on (a.[PATIENT_ID]=r.[PATIENT_ID])\r\n"
			+ "WHERE a.[TRN_RX_ID]=:TRN_RX_ID")
	List<Object[]> getRxPatientDetByTrnRxId(@Param(value = "TRN_RX_ID") int trnFaxId);

	@Query(nativeQuery = true, value = "UPDATE DIM_PATIENT \r\n"
			+ "    SET PATIENT_FULL_NAME = :PATIENT_NAME, \r\n"
			+ "        DATE_OF_BIRTH = :DATE_OF_BIRTH, \r\n"
			+ "        CELL_PHONE = :CELL_PHONE, \r\n"
			+ "        SHIP_TO_ADDRESS = :SHIP_TO_ADDRESS, \r\n"
			+ "        CITY = :CITY, \r\n"
			+ "        STATE = :STATE,  \r\n"
			+ "        ZIP = :ZIP, \r\n"
			+ "        SSN = CONCAT( 'XXX-XXXX-', :SSN), \r\n"
			+ "        UPDATED_USER = :USER, \r\n"
			+ "        UPDATED_DATE = GETDATE() \r\n"
			+ "    WHERE PATIENT_ID = :PATIENT_ID")
	int updateRxPatientDetails(@Param(value = "PATIENT_NAME") String patientName,
			@Param(value = "DATE_OF_BIRTH") Date dateOfBirth,
			@Param(value = "CELL_PHONE") String cellPhone,
			@Param(value = "SHIP_TO_ADDRESS") String shipToAddress,
			@Param(value = "CITY") String city,@Param(value = "STATE") String state,
			@Param(value = "ZIP") String zip,@Param(value = "SSN") String ssn,
			@Param(value = "UPDATED_USER") String updatedUser,
			@Param(value = "UPDATED_DATE") Date updatedDate,
			@Param(value = "PATIENT_ID") Integer patientId);
	
	
	
	
	
}
