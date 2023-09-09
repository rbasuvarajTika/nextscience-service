package com.nextscience.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;

public interface FaxRxService {


	public PageResponseDTO fetchList(PageRequest page);

}
