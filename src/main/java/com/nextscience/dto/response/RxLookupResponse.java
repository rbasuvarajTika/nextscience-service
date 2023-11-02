package com.nextscience.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RxLookupResponse {
	
	private Integer rxLookupId;
	
	private String rxLookupType;
	
	private String rxLookupDisplay;
	
	private String rxLookupInput;

	private String activeInd;

	private String createdUser;
	
	private Date createdDate;

}
