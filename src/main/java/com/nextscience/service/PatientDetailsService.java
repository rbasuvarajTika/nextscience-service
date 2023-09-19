package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.PatientDetails;

public interface PatientDetailsService {

	List<PatientDetails> findAll();
	

}
