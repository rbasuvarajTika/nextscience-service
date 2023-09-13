package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.AccountDetails;
@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer>{
	

}
