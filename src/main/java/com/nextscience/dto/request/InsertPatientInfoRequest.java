package com.nextscience.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertPatientInfoRequest {
	
	private Integer trnFaxId;
	
	private Integer trnRxId;
	
	private Integer faxId;

	private Integer patientId;

	private String patientFirstName;

	private String patientLastName;
	
	private String patientMiddleName;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date dateOfBirth;
	
	private String patientFullName;
	
	private String patientWhId;

	private String gender;

	private String cellPhone;

	private String workPhone;

	private String shipToAddress;

	private String city;

	private String state;

	private String zip;

	private String zip4;

	private String ssn;
	
	private String email;

	private String mrn;

	private String pmsId;

	private String maritalStatus;

	private String emergencyContactName;

	private String emergencyContactPhone;

	private String createdUser;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date createdDate;

	private String updatedUser;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date updatedDate;

}
