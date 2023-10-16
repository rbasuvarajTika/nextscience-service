package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.FaxRxProvider;

/**
 * Repository interface for managing {@link FaxRxProviderRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface FaxRxProviderRepository extends JpaRepository<FaxRxProvider, Integer> {

}
