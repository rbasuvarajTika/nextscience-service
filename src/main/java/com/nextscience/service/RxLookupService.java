package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.response.RxLookupResponse;

public interface RxLookupService {

	List<RxLookupResponse> getALL();

	List<RxLookupResponse> getRxLookupByFrequency();

	List<RxLookupResponse> getRxLookupByThickness();

	List<RxLookupResponse> getRxLookupByDrainage();

	List<RxLookupResponse> getRxLookupByWoundstage();

	List<RxLookupResponse> getRxLookupByDebridementType();
	
	List<RxLookupResponse> getRxLookupByPlaceOfService();

	List<RxLookupResponse> getRxLookupByOrderInformation();
}
