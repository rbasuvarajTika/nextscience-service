package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.DeleteProductInfoRequest;
import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertProductInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.request.UpdateProductInfoRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductDetailsResponse;
import com.nextscience.dto.response.ProductInfoResponse;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.entity.ProductDetails;

/**
 * Service interface for managing {@link ProductDetailsService}.request
 * 
 * @author Raghu
 */

public interface ProductDetailsService {

	// public List<ProductDetails> findAll();

	/** Retrieves A List Of ProductDetailList */
	public List<ProductKitsResponse> getProductDetailList();

	/** Retrieves A List Of ProductDetailByTrnRxId */
	public List<ProductKitsResponse> getProductDetByTrnRxId(int trnRxId);

	/** Insert a Values in ProductDetails */
	public String InsertProductInfoProc(InsertProductInfoRequest req);

	/** Update a Values in ProductDetails */
	public String UpdateProductInfoProc(UpdateProductInfoRequest req);

	/** Delete a Values in ProductDetails */
	public String DeleteProductInfoProc(DeleteProductInfoRequest req);
	
	
	public List<ProductInfoResponse>getProductInfoDetails();

}
