package com.nextscience.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.FaxRxWoundInfo;

/**
 * Repository interface for managing {@link FaxRxWoundInfoRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface FaxRxWoundInfoRepository extends JpaRepository<FaxRxWoundInfo, Integer> {
	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ", wi.[WOUND_NO], wi.[WOUND_LOCATION], wi.[WOUND_LENGTH], wi.[WOUND_WIDTH], wi.[WOUND_DEPTH]\r\n"
			+ ",wi.[WOUND_THICKNESS],wi.[WOUND_TYPE], wi.[DRAINEGE], wi.[DEBRIDED], wi.[DEBRIDED_DATE]\r\n"
			+ ", wi.[DEBRIDED_TYPE], wi.[ICD_CODE]\r\n" + "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [BRDG_FAX_RX_CASES] cp on (a.[TRN_FAX_ID]=cp.[TRN_FAX_ID])\r\n"
			+ "left join [BRDG_FAX_RX_WOUND_INFO] wi on (a.[TRN_FAX_ID]=wi.[TRN_FAX_ID])")
	List<Object[]> getRxWoundInfoList();

	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ", wi.[WOUND_NO], wi.[WOUND_LOCATION], wi.[WOUND_LENGTH], wi.[WOUND_WIDTH], wi.[WOUND_DEPTH]\r\n"
			+ ",wi.[WOUND_THICKNESS],wi.[WOUND_TYPE], wi.[DRAINEGE], wi.[DEBRIDED], wi.[DEBRIDED_DATE]\r\n"
			+ ", wi.[DEBRIDED_TYPE], wi.[ICD_CODE]\r\n" + "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [BRDG_FAX_RX_CASES] cp on (a.[TRN_FAX_ID]=cp.[TRN_FAX_ID])\r\n"
			+ "left join [BRDG_FAX_RX_WOUND_INFO] wi on (a.[TRN_FAX_ID]=wi.[TRN_FAX_ID])\r\n"
			+ "WHERE a.[TRN_RX_ID]=:TRN_RX_ID")
	List<Object[]> getRxWoundDetByTrnRxId(@Param(value = "TRN_RX_ID") int trnRxId);

}
