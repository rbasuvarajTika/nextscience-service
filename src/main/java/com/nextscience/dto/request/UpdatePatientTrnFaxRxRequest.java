package com.nextscience.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePatientTrnFaxRxRequest {
	
	private Integer patientId;
	private Integer trnFaxId;
	private String faxId;
	private String patientFullName;
	private Date dateOfBirth;
	private String cellPhone;
	private String shipToAddress;
	private String city;
	private String state;
    private String zip;
    private String ssn;
    private String placeOfService;
    private String updatedUser;
    private Date updatedDate;
	private String orderType;
	private Integer woundActive;
	private String repName;
	private Integer repPhoneNo;
	private Integer distributorId;
}
