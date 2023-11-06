package com.nextscience.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextscience.dto.response.RxLookupResponse;
import com.nextscience.entity.RxLookup;
import com.nextscience.enums.ErrorCodes;
import com.nextscience.exceptions.NSException;
import com.nextscience.repo.RxLookupRepository;
import com.nextscience.service.RxLookupService;

@Service
public class RxLookupServiceImpl implements RxLookupService {

	@Autowired
	RxLookupRepository rxLookupRepository;

	@Override
	public List<RxLookupResponse> getALL() {
		List<Object[]> resultList = rxLookupRepository.getALL();
		List<RxLookupResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookupResponse> getRxLookupByFrequency() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByFrequency();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookupResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookupResponse> getRxLookupByThickness() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByThickness();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookupResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookupResponse> getRxLookupByDrainage() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByDrainage();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookupResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookupResponse> getRxLookupByWoundstage() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByWoundstage();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookupResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookupResponse> getRxLookupByDebridementType() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByDebridementType();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookupResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookupResponse> getRxLookupByPlaceOfService() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByPlaceOfService();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookupResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookupResponse> getRxLookupByOrderInformation() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByOrderInformation();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}

		List<RxLookupResponse> responses = resultList.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());
		return responses;
	}

	private RxLookupResponse mapToObjectsArray(Object[] row) {
		RxLookupResponse response = new RxLookupResponse();
		response.setRxLookupId((Integer) row[0]);
		response.setRxLookupDisplay((String) row[1]);
		response.setRxLookupInput((String) row[2]);
		return response;

	}

}
