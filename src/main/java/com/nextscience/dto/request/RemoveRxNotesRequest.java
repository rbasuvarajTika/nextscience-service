package com.nextscience.dto.request;

import lombok.Data;

@Data
public class RemoveRxNotesRequest {
	
	private String userName;
	private Integer trnFaxIdMain;
	private Integer trnFaxIdDuplicate;
	private String faxIdMain;
	private String faxIdDuplicate;

}
