package com.nextscience.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RxPatientDetailsResponse {

	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer caseId;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date faxDate;
	private String faxNumber;
	private String faxUrl;
	private Integer patientId;
	private String patientName;
	private Date dateOfBirth;
	private String cellPhone;
	private String shipToAddress;
	private String city;

	private String state;

	private String zip;
	private String ssn;
	private String workPhone;
	private String gender;
	private String zip4;
	private String mrn;

	private String pmsId;
	private String maritalStatus;
	private String emergencyContactName;

	private String emergencyContactPhone;
	private String placeOfService;
	private String orderType;
	private Integer woundActive;
	private String repName;
	private Integer repPhoneNo;
	private Integer distributorId;
	private String distributorName;

}
