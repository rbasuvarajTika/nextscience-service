package com.nextscience.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.RxLookup;

@Repository
public interface RxLookupRepository extends JpaRepository<RxLookup, Integer> {

	@Query(nativeQuery = true, value = "SELECT * from DIM_RX_LOOKUP")
	List<Object[]> getALL();

	@Query(nativeQuery = true, value = "SELECT [RX_LOOKUP_ID], [RX_LOOKUP_DISPLAY], [RX_LOOKUP_INPUT]\r\n"
			+ "FROM DIM_RX_LOOKUP\r\n" + "WHERE [ACTIVE_IND]='Y' AND [RX_LOOKUP_TYPE]='Frequency'")
	List<Object[]> getRxLookupByFrequency();
	
	@Query(nativeQuery = true, value = "SELECT [RX_LOOKUP_ID], [RX_LOOKUP_DISPLAY], [RX_LOOKUP_INPUT]\r\n"
			+ "FROM DIM_RX_LOOKUP\r\n" + "WHERE [ACTIVE_IND]='Y' AND [RX_LOOKUP_TYPE]='Thickness'")
	List<Object[]> getRxLookupByThickness();
	
	@Query(nativeQuery = true, value = "SELECT [RX_LOOKUP_ID], [RX_LOOKUP_DISPLAY], [RX_LOOKUP_INPUT]\r\n"
			+ "FROM DIM_RX_LOOKUP\r\n" + "WHERE [ACTIVE_IND]='Y' AND [RX_LOOKUP_TYPE]='Drainage'")
	List<Object[]> getRxLookupByDrainage();
	
	@Query(nativeQuery = true, value = "SELECT [RX_LOOKUP_ID], [RX_LOOKUP_DISPLAY], [RX_LOOKUP_INPUT]\r\n"
			+ "FROM DIM_RX_LOOKUP\r\n" + "WHERE [ACTIVE_IND]='Y' AND [RX_LOOKUP_TYPE]='Woundstage'")
	List<Object[]> getRxLookupByWoundstage();
	
	@Query(nativeQuery = true, value = "SELECT [RX_LOOKUP_ID], [RX_LOOKUP_DISPLAY], [RX_LOOKUP_INPUT]\r\n"
			+ "FROM DIM_RX_LOOKUP\r\n" + "WHERE [ACTIVE_IND]='Y' AND [RX_LOOKUP_TYPE]='Debridement Type'")
	List<Object[]> getRxLookupByDebridementType();
	
	@Query(nativeQuery = true, value = "SELECT [RX_LOOKUP_ID], [RX_LOOKUP_DISPLAY], [RX_LOOKUP_INPUT]\r\n"
			+ "FROM DIM_RX_LOOKUP\r\n" + "WHERE [ACTIVE_IND]='Y' AND [RX_LOOKUP_TYPE]='Place Of Service'")
	List<Object[]> getRxLookupByPlaceOfService();
	
	@Query(nativeQuery = true, value = "SELECT [RX_LOOKUP_ID], [RX_LOOKUP_DISPLAY], [RX_LOOKUP_INPUT]\r\n"
			+ "FROM DIM_RX_LOOKUP\r\n" + "WHERE [ACTIVE_IND]='Y' AND [RX_LOOKUP_TYPE]='Order Information'")
	List<Object[]> getRxLookupByOrderInformation();
	

}
