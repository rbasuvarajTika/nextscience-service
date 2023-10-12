package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.DeleteProductInfoRequest;
import com.nextscience.dto.request.DeleteWoundInfoRequest;
import com.nextscience.dto.request.InsertProductInfoRequest;
import com.nextscience.dto.request.UpdatePatientTrnFaxRxRequest;
import com.nextscience.dto.request.UpdateProductInfoRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.dto.response.WoundInfoResponse;
import com.nextscience.entity.ProductDetails;

public interface ProductDetailsService {
	
	//public List<ProductDetails> findAll();
	public List<ProductKitsResponse> getProductDetailList();
	public List<ProductKitsResponse> getProductDetByTrnRxId(int trnRxId);
	public String InsertProductInfoProc(InsertProductInfoRequest req);
	public String UpdateProductInfoProc(UpdateProductInfoRequest req);
	public String DeleteProductInfoProc(DeleteProductInfoRequest req);



}
