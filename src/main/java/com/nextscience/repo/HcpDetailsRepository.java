package com.nextscience.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.HcpDetails;

/**
 * Repository interface for managing {@link HcpDetailsRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface HcpDetailsRepository extends JpaRepository<HcpDetails, Integer> {
	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ",p.hCP_ID,p.FIRST_NAME HCP_FIRST_NAME,p.MIDDLE_NAME HCP_MIDDLE_NAME,p.LAST_NAME HCP_LAST_NAME,c.PROVIDER_TYPE\r\n"
			+ ",p.NPI,c.SIGNATURE_FLAG,c.SIGNATURE_DATE\r\n"
			+ "----,p.ADDRESS1,p.ADDRESS2 ,p.CITY ,p.[STATE] ,p.ZIP \r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [BRDG_FAX_RX_PROVIDER] c on (a.[TRN_FAX_ID]=c.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_HCP] p on (c.[HCP_ID]=p.[HCP_ID])")
	List<Object[]> getHcpInfoList();

	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.TRN_FAX_ID,b.FAX_ID\r\n"
			+ ",p.hCP_ID,p.FIRST_NAME HCP_FIRST_NAME,p.MIDDLE_NAME HCP_MIDDLE_NAME,p.LAST_NAME HCP_LAST_NAME,c.PROVIDER_TYPE\r\n"
			+ ",p.NPI,c.SIGNATURE_FLAG,c.SIGNATURE_DATE\r\n"
			+ ",b.PROF_ID ,p.ADDRESS1,p.ADDRESS2 ,p.CITY ,p.[STATE] ,p.ZIP \r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [BRDG_FAX_RX_PROVIDER] c on (a.[TRN_FAX_ID]=c.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_HCP] p on (c.[HCP_ID]=p.[HCP_ID])\r\n" + "WHERE a.[TRN_RX_ID]=:TRN_RX_ID")
	List<Object[]> getHcpDetByTrnRxId(@Param(value = "TRN_RX_ID") int trnRxId);

}
