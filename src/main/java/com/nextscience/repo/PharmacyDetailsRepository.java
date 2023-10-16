package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nextscience.entity.PharmacyDetails;

/**
 * Repository interface for managing {@link PharmacyDetailsRepository}.request
 * 
 * @author Raghu
 */

public interface PharmacyDetailsRepository extends JpaRepository<PharmacyDetails, Integer> {

}
