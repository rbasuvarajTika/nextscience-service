package com.nextscience.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nextscience.entity.DistributorDetails;

public interface DistributorDetailsRepository extends JpaRepository<DistributorDetails, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT DISTRIBUTOR_ID, DISTRIBUTOR_NAME FROM DIM_DISTRIBUTOR")
    List<Object[]> getDistributorDetails();

}
