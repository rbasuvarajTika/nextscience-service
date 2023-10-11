package com.nextscience.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxWoundInfo;

import com.nextscience.repo.FaxRxWoundInfoRepository;
import com.nextscience.service.FaxRxWoundInfoService;

@Service
public class FaxRxWoundInfoImpl implements FaxRxWoundInfoService {
	
	
	@Autowired
	FaxRxWoundInfoRepository faxRxWoundInfoRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<WoundInfoResponse> getRxWoundInfoList() {
		List<Object[]> woundInfoResponse=faxRxWoundInfoRepository.getRxWoundInfoList();
		List<WoundInfoResponse> responses = woundInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}
	
	private WoundInfoResponse mapToObjectsArray(Object[] row) {
		WoundInfoResponse response = new WoundInfoResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setWoundNo((Integer) row[3]);
		response.setWoundLocation((String) row[4]);
		response.setWoundLength((BigDecimal) row[5]);
		response.setWoundWidth((BigDecimal) row[6]);
		response.setWoundDepth((BigDecimal) row[7]);
		response.setWoundThickness((String) row[8]);
		response.setWoundType((String) row[9]);
		response.setDrainage((String) row[10]);
		response.setDebrided((Integer) row[11]);
		response.setDebridedDate((Date) row[12]);
		response.setDebridedType((String) row[13]);
		response.setIcdCode((String) row[14]);
		return response;
		
		
		
		
	}

	@Override
	public List<WoundInfoResponse> getRxWoundDetByTrnRxId(int trnRxId) {
		List<Object[]> woundInfoResponse=faxRxWoundInfoRepository.getRxWoundDetByTrnRxId(trnRxId);
		List<WoundInfoResponse> responses = woundInfoResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;
	}
}
	
	/*@Override
	public List<FaxRxWoundInfo> findAll() {
		// TODO Auto-generated method stub
		return faxRxWoundInfoRepository.findAll();
	}*/


