package com.nextscience.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class InsertTrnFaxRxRequest {
	
	private String faxId;
	
	private String faxNumber;
	
	private String faxStatus;
	
	private String processStatus;
	
	private String rxStatus;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date faxDate;
	
	private String faxFilename;
	
	private Integer faxPages;

	private String faxCallerId;
	
	private String faxUrl;
	
	private String createdUser;
	
	

}
