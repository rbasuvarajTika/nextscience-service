package com.nextscience.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.FaxRxSplitHist;



@Repository
public interface FaxRxSplitHistRepository extends JpaRepository<FaxRxSplitHist, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * from TRN_FAX_RX_SPLIT_HIST")
	List<Object[]> getALL();

	@Query(nativeQuery = true, value = "SELECT * from TRN_FAX_RX_SPLIT_HIST WHERE FAX_ID = :faxId")
	List<Object[]> getByFaxId(@Param(value = "faxId") String faxId);


	
	

}
