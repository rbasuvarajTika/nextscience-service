package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.FaxRxPayer;

/**
 * Repository interface for managing {@link FaxRxPayerRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface FaxRxPayerRepository extends JpaRepository<FaxRxPayer, Integer> {

}
