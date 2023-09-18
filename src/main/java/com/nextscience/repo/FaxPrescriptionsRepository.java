package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.FaxPrescriptions;

@Repository
public interface FaxPrescriptionsRepository extends JpaRepository<FaxPrescriptions, Integer>{

}
