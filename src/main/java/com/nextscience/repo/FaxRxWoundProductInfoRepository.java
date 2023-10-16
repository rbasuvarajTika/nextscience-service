package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.FaxRxWoundProductInfo;

/**
 * Repository interface for managing {@link FaxRxWoundProductInfoRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface FaxRxWoundProductInfoRepository extends JpaRepository<FaxRxWoundProductInfo, Integer> {

}
