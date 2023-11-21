package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.FaxRxSplitHist;



@Repository
public interface FaxRxSplitHistRepository extends JpaRepository<FaxRxSplitHist, Integer>{

}
