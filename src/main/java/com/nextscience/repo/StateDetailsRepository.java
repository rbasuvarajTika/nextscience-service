package com.nextscience.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.RxChecklist;
import com.nextscience.entity.StatesDetails;

@Repository
public interface StateDetailsRepository extends JpaRepository<StatesDetails, Integer>{
	 
	@Query(nativeQuery = true, value = "SELECT STATE_ID, STATE_NAME, SHORT_NAME FROM DIM_STATES")
	    List<Object[]> getStatesDetails();

}
