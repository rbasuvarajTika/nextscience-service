package com.nextscience.repo;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.PayerDetails;
@Repository
public interface FaxRxPayerRepository extends JpaRepository<FaxRxPayer, Integer> {


	

	

}
