package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nextscience.entity.PayerDetails;

/**
 * Repository interface for managing {@link PayerDetailsRepository}.request
 * 
 * @author Raghu
 */

public interface PayerDetailsRepository extends JpaRepository<PayerDetails, Integer> {

}
