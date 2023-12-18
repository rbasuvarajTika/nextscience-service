package com.nextscience.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowPrevRxHcpsResponse {

	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer caseId;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date faxDate;
	private String faxNumber;
	private String faxUrl;
	private String verifiedFlag;
	private String hcpName;
	private String providerType;

	private String hcpAddress1;
	private String hcpAddress2;
	private String hcpCity;
	private String hcpState;
	private String hcpZip;
	private String accountName;
	private String accAddress1;
	private String accCity;
	private String accState;
	private String accZip;
	private String patientName;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date dateOfBirth;
	private String gender;
	private String cellPhone;
	private String workPhone;
	private String shipToAddress;
	private String patientCity;
	private String patientState;
	private String patientZip;
	private String patientZip4;
	private String ssn;
	private String mrn;
	private String pmsId;
	private String maritialStatus;
	private String emergencyContactName;
	private String emergencyContactPhone;

	private String productCode;
	private String productDisplayName;
	private String wndCode;
	
	

}
