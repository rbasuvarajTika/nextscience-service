package com.nextscience.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.FaxRxPayerResponse;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRx;
import com.nextscience.service.FaxRxPayerService;
import com.nextscience.service.FaxRxService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/fax")
public class FaxContoller {

	@Autowired
	private FaxRxService faxRxService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/faxList")
    public NSServiceResponse<List<FaxRxResponse>> executeCustomQuery(
    		@RequestParam(value = "pageNo", required = false, defaultValue ="0") int pageNo,
    		@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
    		@RequestParam(value = "sortBy", defaultValue = "created_date", required = false) String sortBy,            
    		@RequestParam(value = "orderBy",defaultValue = "desc", required = false) String orderType ){ 
		 PageRequest page = null;       
		 if ("desc".equals(orderType)) {    
			 page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());    
			 } else {               
				 page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending()); 
				 }
		 PageResponseDTO response =faxRxService.fetchList(page);
		//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
				response, "Successfully ", "Error");
    }
	

	@GetMapping(value="/faxPdf",produces= MediaType.APPLICATION_PDF_VALUE)
	public  @ResponseBody byte[]  faxPdfDownload() {

	    try {
	    	InputStream is;
	    	is = new URL("https://sftp.tika.mobi/ftp/tikaftp/NextScience/RxMgmt/Fax_Files/fax1509414370.pdf").openStream();
	        return is.readAllBytes();
	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return null;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/faxDupe")
	public NSServiceResponse<List<DupeRxResponse>> executeCustomQuery(){
    
		List<DupeRxResponse> response =faxRxService.getDuplicateResponse();
		//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
				response, "Successfully ", "Error");
    }
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/faxDupeById/{faxId}")
	public NSServiceResponse<List<DupeRxResponse>> faxDupeId(@PathVariable String faxId){
    
		List<DupeRxResponse> response =faxRxService.getDuplicateByIdResponse(faxId);
		//List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), 
				response, "Successfully ", "Error");
    }
	
	@GetMapping(value="/getFaxPdf/{faxId}",produces= MediaType.APPLICATION_PDF_VALUE)
	public  @ResponseBody byte[]  faxPdfDownload(@PathVariable String faxId) {

	    try {
	    	
	    	FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
	    	InputStream is;
	    	String ftpUrl= faxRxResponse.getFaxUrl();
	    	is = new URL(ftpUrl).openStream();
	        return is.readAllBytes();
	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/getFaxDetails/{faxId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public  NSServiceResponse<FaxRx>  faxDetails(@PathVariable String faxId) {
	    	FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
	    	return ResponseHelper.createResponse(new NSServiceResponse<FaxRx>(), 
	    			faxRxResponse, "Successfully ", "Error");
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping(value="/updateFax/{dupeTrnFaxId}/{mainTrnFaxId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public  NSServiceResponse<FaxRx>  updateFax(@PathVariable String dupeTrnFaxId,@PathVariable String mainTrnFaxId) {
	    	FaxRx faxRxResponse = faxRxService.updatefax(dupeTrnFaxId, mainTrnFaxId);
	    	return ResponseHelper.createResponse(new NSServiceResponse<FaxRx>(), 
	    			faxRxResponse, "Successfully ", "Error");
	}
	
	
	@SuppressWarnings("unchecked")
	@PutMapping(value="/keepDuplicate/{trnFaxId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public  NSServiceResponse<String>  keepDuplicate(@PathVariable String trnFaxId) {
	    	String response = faxRxService.keepDuplicate(trnFaxId);
	    	return ResponseHelper.createResponse(new NSServiceResponse<FaxRx>(), 
	    			response, "updated Successfully ", "Error");
	}
	
}

