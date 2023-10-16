package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.FaxRxCase;

/**
 * Repository interface for managing {@link FaxRxCaseRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface FaxRxCaseRepository extends JpaRepository<FaxRxCase, Integer> {

}
