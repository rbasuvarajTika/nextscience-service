package com.nextscience.dto.request;

import lombok.Data;

@Data
public class FaxRxAttachNotesToRaxRequest {

	private String userName;
	private Integer trnFaxIdMain;
	private Integer trnFaxIdDuplicate;

}
