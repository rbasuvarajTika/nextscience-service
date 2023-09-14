
package com.nextscience.service;


import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.entity.User;

public interface FaxRxPayerService {
	
	public PageResponseDTO fetchList(PageRequest page);
	
	//List<FaxRxPayer> findAll();
}
