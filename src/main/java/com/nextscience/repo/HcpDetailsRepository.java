package com.nextscience.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.nextscience.entity.HcpDetails;
@Repository
public interface HcpDetailsRepository extends JpaRepository<HcpDetails, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT CELL_PHONE, EMAIL, ADDRESS1, CITY, STATE, ZIP FROM DIM_HCP")
	List<HcpDetails> findAllHcpDetails();
}


   



