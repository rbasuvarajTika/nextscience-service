package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRx;
import com.nextscience.repo.FaxRxRepository;
import com.nextscience.service.FaxRxService;

@Service
public class FaxRxImpl implements FaxRxService {

	@Autowired
	FaxRxRepository faxRxRepository;

	@Override
	public PageResponseDTO fetchList( PageRequest page) {
		Page<Object[]> listDetails = faxRxRepository.fetchFaxList(page);
		
		 List<FaxRxResponse> faxRxResponses = listDetails
			        .getContent()
			        .stream()
			        .map(this::mapToObjectArray)
			        .collect(Collectors.toList());
		 
		Page<FaxRxResponse> pageOfFaxResponses = new PageImpl<>(faxRxResponses, page, listDetails.getTotalElements());

		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfFaxResponses.getContent());
		pageResponse.setFirst(pageOfFaxResponses.isFirst());
		pageResponse.setLast(pageOfFaxResponses.isLast());
		pageResponse.setPageNumber(pageOfFaxResponses.getNumber());
		pageResponse.setRecordCount(pageOfFaxResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfFaxResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfFaxResponses.getSize());
		pageResponse.setTotalPages(pageOfFaxResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfFaxResponses.getTotalElements());
		return pageResponse;
	}
	
	private FaxRxResponse mapToObjectArray(Object[] row) {
	    FaxRxResponse response = new FaxRxResponse();
	    response.setTrnFaxId((Integer) row[0]);
	    response.setFaxId((String) row[1]);
	    response.setCaseId((Integer) row[2]);
	    response.setFaxStatus((String) row[3]);
	    response.setDupeFaxId((String) row[4]);
	    response.setFaxDate((Date) row[5]);
	    response.setFaxNumber((String) row[6]);
	    response.setOcrStatus((String) row[7]);
	    response.setOcrDate((Date) row[8]);
	    return response;
	}
	
	public FaxRx fetchListById(String faxId) {
		FaxRx faxRxResponse= faxRxRepository.findByFaxId(faxId);
		return faxRxResponse;
	}


	@Override
	public List<DupeRxResponse> getDuplicateResponse() {
		
		List<Object[]> faxRxResponse= faxRxRepository.getDupeResponse();
		List<DupeRxResponse> dupeRxResponse = faxRxResponse.stream().map(this::mapToObjectsArray)
		        .collect(Collectors.toList());
		      	
		return dupeRxResponse;
	}
	private DupeRxResponse mapToObjectsArray(Object[] row) {
		DupeRxResponse response = new DupeRxResponse();
	    response.setTrnFaxId((Integer) row[0]);
	    response.setFaxId((String) row[1]);
	    response.setCaseId((Integer) row[2]);
	    response.setFaxStatus((String) row[3]);
	    response.setDupeFaxId((String) row[4]);
	    response.setFaxDate((Date) row[5]);
	    response.setFaxNumber((String) row[6]);
	    response.setOcrStatus((String) row[7]);
	    response.setOcrDate((Date) row[8]);
	    response.setFaxUrl((String) row[9]);
	    response.setVerifiedFlag((String) row[10]);
	    response.setHcpName((String)row[11] );
	    response.setAccountName((String) row[12]);
	    response.setPatientName((String) row[13]);
	    return response;
	}
	

}
