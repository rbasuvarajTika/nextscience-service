package com.nextscience.service;

import java.util.List;

import com.nextscience.entity.RxLookup;

public interface RxLookupService {

	List<RxLookup> getALL();

	List<RxLookup> getRxLookupByFrequency();

	List<RxLookup> getRxLookupByThickness();

	List<RxLookup> getRxLookupByDrainage();

	List<RxLookup> getRxLookupByWoundstage();

	List<RxLookup> getRxLookupByDebridementType();

}
