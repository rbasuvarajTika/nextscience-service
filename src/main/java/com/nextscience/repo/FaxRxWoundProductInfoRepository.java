package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.FaxRxWoundProductInfo;

@Repository
public interface FaxRxWoundProductInfoRepository extends JpaRepository<FaxRxWoundProductInfo, Integer> {

}
