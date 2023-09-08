package com.nextscience.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nextscience.dto.FaxRxResponse;
import com.nextscience.dto.PageResponseDTO;

public interface FaxRxService {


	public PageResponseDTO fetchList(PageRequest page);

}
