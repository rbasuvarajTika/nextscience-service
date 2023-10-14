package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.ProductDetailsConstant;
import com.nextscience.dto.request.DeleteProductInfoRequest;
import com.nextscience.dto.request.InsertProductInfoRequest;
import com.nextscience.dto.request.UpdateProductInfoRequest;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.ProductKitsResponse;
import com.nextscience.dto.response.RxPatientDetailsResponse;
import com.nextscience.service.ProductDetailsService;
import com.nextscience.utility.ResponseHelper;

/**
 * Processes an {@link ProductDetailsController } request.
 * @author Raghu
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class ProductDetailsController {
	
	
	@Autowired
	ProductDetailsService productDetailsService;
	
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(ProductDetailsConstant.PRODUCTINFO)
	   public NSServiceResponse<List<ProductKitsResponse>>getProductDetail()
	{
	List<ProductKitsResponse> productInfo = productDetailsService.getProductDetailList();
	return ResponseHelper.createResponse(new NSServiceResponse<ProductKitsResponse>(), productInfo, CommonConstants.SUCCESSFULLY,CommonConstants.ERRROR);
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(ProductDetailsConstant.PRODUCTINFOTRNRXID)
	public NSServiceResponse<List<ProductKitsResponse>> getRxPatientDetByTrnRxId(@PathVariable int trnRxId)
	{
		List<ProductKitsResponse> productInfo = productDetailsService.getProductDetByTrnRxId(trnRxId);
		return ResponseHelper.createResponse(new NSServiceResponse<RxPatientDetailsResponse>(), productInfo, CommonConstants.SUCCESSFULLY,CommonConstants.ERRROR);

		

	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/productInfo")
	public NSServiceResponse<InsertProductInfoRequest> InsertProductInfoDet(@RequestBody InsertProductInfoRequest req)
	{
		String response = productDetailsService.InsertProductInfoProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<String>(), 
    			response, "Successfully ", "Error");
	}
	@SuppressWarnings("unchecked")
	@PutMapping("/productInfo")
	public NSServiceResponse<UpdateProductInfoRequest> UpdateProductInfoDet(@RequestBody UpdateProductInfoRequest req)
	{
		String response = productDetailsService.UpdateProductInfoProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<String>(), 
    			response, "Successfully ", "Error");
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/productInfoDetails")
	public NSServiceResponse<DeleteProductInfoRequest> deleteProductDetails(@RequestBody DeleteProductInfoRequest req)
	{
		String response = productDetailsService.DeleteProductInfoProc(req);
    	return ResponseHelper.createResponse(new NSServiceResponse<String>(), 
    			response, "Successfully ", "Error");
	}
	
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/product") public
	 * NSServiceResponse<List<ProductDetailsResponse>>getProductDetail()
	 * 
	 * { List<ProductDetails> product = productDetailsService.findAll(); return
	 * ResponseHelper.createResponse(new
	 * NSServiceResponse<ProductDetailsResponse>(), product, "Successfully ",
	 * "Error"); }
	 */
	

}
