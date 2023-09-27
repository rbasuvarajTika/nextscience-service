package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRx;
import com.nextscience.repo.FaxRxRepository;
import com.nextscience.service.FaxRxService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class FaxRxImpl implements FaxRxService {

	@Autowired
	FaxRxRepository faxRxRepository;
	
	 @PersistenceContext
	 private EntityManager entityManager;

	

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
	
	@Override
	public List<DupeRxResponse> getDuplicateByIdResponse(String faxId) {
		
		List<Object[]> faxRxResponse= faxRxRepository.getDupeResponse();
		List<DupeRxResponse> dupeRxResponse = faxRxResponse.stream().map(this::mapToObjectsArray)
		        .collect(Collectors.toList());
		      	
		List<DupeRxResponse> filterResponse =  dupeRxResponse.stream().filter(e->e.getFaxId().equalsIgnoreCase(faxId)).collect(Collectors.toList());
		String dupeFaxId = filterResponse.get(0).getDupeFaxId();
		List<DupeRxResponse> filterResponseNew =  dupeRxResponse.stream().filter(e->e.getDupeFaxId().equalsIgnoreCase(dupeFaxId)).collect(Collectors.toList());
		return filterResponseNew;
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
     @Override
	@Transactional
	public FaxRx updatefax(String dupeTrnFaxId ,String mainTrnFaxId) {
		
		 String trnFaxRxUpdateQuery = "UPDATE TRN_FAX_RX t SET t.FAX_STATUS = 'Main' WHERE t.FAX_STATUS = 'Duplicate' AND t.TRN_FAX_ID = :DUPE_TRN_FAX_ID";
		 
	        String trnFaxRxDupeQuery = "UPDATE TRN_FAX_RX t SET t.FAX_STATUS = 'Duplicate' WHERE t.TRN_FAX_ID = :MAIN_TRN_FAX_ID";

	        // Update BRDG_FAX_RX_CASES
	        String brdgFaxRxCasesUpdateQuery = "UPDATE BRDG_FAX_RX_CASES b SET b.CASE_TYPE = 'Main' WHERE b.CASE_TYPE = 'Duplicate' AND b.TRN_FAX_ID = :DUPE_TRN_FAX_ID";
	        
	        String brdgFaxRxCasesDupeQuery = "UPDATE BRDG_FAX_RX_CASES b SET b.CASE_TYPE = 'Duplicate' WHERE b.TRN_FAX_ID = :mainTrnFaxId";


	        entityManager.createNativeQuery(trnFaxRxUpdateQuery)
	            .setParameter("dupeTrnFaxId", dupeTrnFaxId)
	            .executeUpdate();
	        
	        entityManager.createNativeQuery(trnFaxRxDupeQuery)
            .setParameter("mainTrnFaxId", mainTrnFaxId)
            .executeUpdate();
	        
	        

	        entityManager.createNativeQuery(brdgFaxRxCasesUpdateQuery)
	            .setParameter("dupeTrnFaxId", dupeTrnFaxId)
	            .executeUpdate();
	        
	        entityManager.createNativeQuery(brdgFaxRxCasesDupeQuery)
            .setParameter("mainTrnFaxId", mainTrnFaxId)
            .executeUpdate();
	        
	        
	        
	        return null;
	    }

	
	}

		
		
		
	
	


