package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.FaxRxCase;


@Repository
public interface FaxRxCaseRepository extends JpaRepository<FaxRxCase, Integer> {
    // You can define custom queries here if needed
}
