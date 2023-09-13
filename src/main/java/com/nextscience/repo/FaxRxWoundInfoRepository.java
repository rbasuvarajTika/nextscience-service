package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.FaxRxWoundInfo;
@Repository
public interface FaxRxWoundInfoRepository extends JpaRepository<FaxRxWoundInfo, Integer>{

}
