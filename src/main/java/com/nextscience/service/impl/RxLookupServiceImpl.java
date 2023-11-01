package com.nextscience.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<RxLookup> getALL() {
		List<RxLookup> resultList = rxLookupRepository.getALL();
		return resultList;
	}

	@Override
	public List<RxLookup> getRxLookupByFrequency() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByFrequency();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookup> responses = resultList.stream().map(this::mapToObjectsArray).collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookup> getRxLookupByThickness() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByThickness();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookup> responses = resultList.stream().map(this::mapToObjectsArray).collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookup> getRxLookupByDrainage() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByDrainage();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookup> responses = resultList.stream().map(this::mapToObjectsArray).collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookup> getRxLookupByWoundstage() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByWoundstage();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookup> responses = resultList.stream().map(this::mapToObjectsArray).collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RxLookup> getRxLookupByDebridementType() {
		List<Object[]> resultList = rxLookupRepository.getRxLookupByDebridementType();
		if (resultList == null || resultList.isEmpty()) {
			throw new NSException(ErrorCodes.OK, "List is Empty");
		}
		List<RxLookup> responses = resultList.stream().map(this::mapToObjectsArray).collect(Collectors.toList());
		return responses;
	}

	private RxLookup mapToObjectsArray(Object[] row) {
		RxLookup response = new RxLookup();
		response.setRxLookupId((Integer) row[0]);
		response.setRxLookupDisplay((String) row[1]);
		response.setRxLookupInput((String) row[2]);
		return response;

	}

}
