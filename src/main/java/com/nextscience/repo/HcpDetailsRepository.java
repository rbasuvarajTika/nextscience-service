package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.nextscience.entity.HcpDetails;
@Repository
public interface HcpDetailsRepository extends JpaRepository<HcpDetails, Integer> {

}
