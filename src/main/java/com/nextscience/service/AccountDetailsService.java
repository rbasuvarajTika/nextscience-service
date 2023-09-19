package com.nextscience.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;

public interface AccountDetailsService {

	List<AccountDetails> findAll();
	
	
}
