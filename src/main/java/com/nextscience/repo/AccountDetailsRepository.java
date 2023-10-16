package com.nextscience.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.AccountDetails;

/**
 * Repository interface for managing {@link AccountDetailsRepository}.request
 * 
 * @author Raghu
 */
@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer> {
	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ",h.ACCOUNT_ID,h.ACCOUNT_NAME,h.PHONE,h.EMAIL,h.ADDRESS1,h.CITY,h.[STATE],h.ZIP\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_ACCOUNT] h on (a.[ACCOUNT_ID]=h.[ACCOUNT_ID])")
	List<Object[]> getAccountList();

	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ",h.ACCOUNT_ID,h.ACCOUNT_NAME,h.PHONE,h.EMAIL,h.ADDRESS1,h.CITY,h.[STATE],h.ZIP\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_ACCOUNT] h on (a.[ACCOUNT_ID]=h.[ACCOUNT_ID])\r\n" + "WHERE a.[TRN_RX_ID]=:TRN_RX_ID")
	List<Object[]> getAccDetByTrnRxId(@Param(value = "TRN_RX_ID") int trnRxId);

}
