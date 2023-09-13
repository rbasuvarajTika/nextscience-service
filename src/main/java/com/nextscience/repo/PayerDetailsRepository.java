package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nextscience.entity.PayerDetails;

public interface PayerDetailsRepository extends JpaRepository<PayerDetails, Integer> {

}
