package com.nextscience.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.RxChecklist;

/**
 * Repository interface for managing {@link RxChecklistRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface RxChecklistRepository extends JpaRepository<RxChecklist, Integer> {
	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ",rc.RX_CHECKLIST_ID,r.RX_CHECKLIST_DESC ,rc.CHECKLIST_FLAG,rc.COMMENTS\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join BRDG_FAX_RX_CHECKLIST rc on (a.[TRN_RX_ID]=rc.[TRN_RX_ID])\r\n"
			+ "left join [DIM_RX_CHECKLIST] r on (rc.[RX_CHECKLIST_ID]=r.[RX_CHECKLIST_ID])")
	List<Object[]> getCheckList();

	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ",rc.RX_CHECKLIST_ID,r.RX_CHECKLIST_DESC ,rc.CHECKLIST_FLAG,rc.COMMENTS\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join BRDG_FAX_RX_CHECKLIST rc on (a.[TRN_RX_ID]=rc.[TRN_RX_ID])\r\n"
			+ "left join [DIM_RX_CHECKLIST] r on (rc.[RX_CHECKLIST_ID]=r.[RX_CHECKLIST_ID])\r\n"
			+ "WHERE a.[TRN_RX_ID]=:TRN_RX_ID")
	List<Object[]> getCheckLisDetByTrnRxId(@Param(value = "TRN_RX_ID") int trnRxId);

}
