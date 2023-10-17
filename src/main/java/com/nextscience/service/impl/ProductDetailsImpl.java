package com.nextscience.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextscience.dto.request.DeleteProductInfoRequest;
import com.nextscience.dto.request.InsertProductInfoRequest;
import com.nextscience.dto.request.UpdateProductInfoRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductDetailsResponse;
import com.nextscience.dto.response.ProductInfoResponse;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.dto.response.StateDetailsResponse;
import com.nextscience.entity.PharmacyDetails;
import com.nextscience.entity.ProductDetails;
import com.nextscience.repo.ProductDetailsRepository;
import com.nextscience.service.ProductDetailsService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

/**
 * Service Class for managing {@link ProductDetailsImpl}.request
 * 
 * @author Raghu
 */

@Service
public class ProductDetailsImpl implements ProductDetailsService {

	@Autowired
	ProductDetailsRepository productDetailsRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProductKitsResponse> getProductDetailList() {
		List<Object[]> productKitsResponse = productDetailsRepository.getProductList();
		List<ProductKitsResponse> responses = productKitsResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;

	}

	private ProductKitsResponse mapToObjectsArray(Object[] row) {
		ProductKitsResponse response = new ProductKitsResponse();
		response.setTrnRxId((Integer) row[0]);
		response.setTrnFaxId((Integer) row[1]);
		response.setFaxId((String) row[2]);
		response.setProductId((Integer) row[3]);
		response.setProductCode((String) row[4]);
		response.setProductDisplayName((String) row[5]);
		response.setQuantity((String) row[6]);
		response.setWnd1((Integer) row[7]);
		response.setWnd2((Integer) row[8]);
		response.setWnd3((Integer) row[9]);
		response.setWnd4((Integer) row[10]);
		response.setWndCode((String) row[11]);
		return response;
	}

	@Override
	public List<ProductKitsResponse> getProductDetByTrnRxId(int trnRxId) {
		List<Object[]> productKitsResponse = productDetailsRepository.getProductDetByTrnRxId(trnRxId);
		List<ProductKitsResponse> responses = productKitsResponse.stream().map(this::mapToObjectsArray)
				.collect(Collectors.toList());

		return responses;

	}

	@Override
	public String InsertProductInfoProc(InsertProductInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_ProdDetails_Add");

		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);
		// query.registerStoredProcedureParameter("PRODUCT_ID", Integer.class,
		// ParameterMode.IN);

		query.registerStoredProcedureParameter("QUANTITY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND1", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND2", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND3", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND4", Integer.class, ParameterMode.IN);

		query.setParameter("USER", req.getCreatedUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());

		query.setParameter("PRODUCT_CODE", req.getProductCode());
		// query.setParameter("PRODUCT_ID", req.getProductId());
		query.setParameter("QUANTITY", req.getQuantity());
		query.setParameter("WND1", req.getWnd1());
		query.setParameter("WND2", req.getWnd2());
		query.setParameter("WND3", req.getWnd3());
		query.setParameter("WND4", req.getWnd4());

		query.execute();
		return "created successfully";
	}

	@Override
	public String UpdateProductInfoProc(UpdateProductInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_ProdDetails_Edit");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);
		// query.registerStoredProcedureParameter("PRODUCT_ID", Integer.class,
		// ParameterMode.IN);

		query.registerStoredProcedureParameter("QUANTITY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND1", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND2", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND3", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("WND4", Integer.class, ParameterMode.IN);

		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());
		query.setParameter("USER", req.getUpdatedUser());
		query.setParameter("PRODUCT_CODE", req.getProductCode());
		// query.setParameter("PRODUCT_CODE", req.getProductCode());
		query.setParameter("QUANTITY", req.getQuantity());
		query.setParameter("WND1", req.getWnd1());
		query.setParameter("WND2", req.getWnd2());
		query.setParameter("WND3", req.getWnd3());
		query.setParameter("WND4", req.getWnd4());

		query.execute();

		return "Updated successfully";
	}

	@Override
	public String DeleteProductInfoProc(DeleteProductInfoRequest req) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Fax_Rx_ProdDetails_Del");
		query.registerStoredProcedureParameter("USER", String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter("TRN_FAX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("TRN_RX_ID", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);

		query.setParameter("USER", req.getUser());
		query.setParameter("TRN_FAX_ID", req.getTrnFaxId());
		query.setParameter("TRN_RX_ID", req.getTrnRxId());
		query.setParameter("PRODUCT_CODE", req.getProductCode());
		query.execute();

		return "Deleted Successfully";
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ProductInfoResponse> getProductInfoDetails() {
		List<Object[]> productDetailsResponse = productDetailsRepository.getProductInfoDetails();

		        List<ProductInfoResponse> responses = productDetailsResponse.stream().map(this::mapToObjectsArrays)
						.collect(Collectors.toList());
		        return responses;
		    }
	private ProductInfoResponse mapToObjectsArrays(Object[] row) {
		ProductInfoResponse response = new ProductInfoResponse();
		response.setProductId((Integer) row[0]);
		response.setProductCode((String) row[1]);
		response.setProductName((String) row[2]);
		return response;
		
	}
}


/*
 * @SuppressWarnings("unchecked")
 * 
 * @Override public List<ProductDetails> findAll() {
 * 
 * return productDetailsRepository.findAll(); }
 */
