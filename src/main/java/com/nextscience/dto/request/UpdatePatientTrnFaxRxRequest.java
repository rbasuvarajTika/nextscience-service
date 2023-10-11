package com.nextscience.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
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
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	private String cellPhone;
	private String shipToAddress;
	private String city;
	private String state;
    private String zip;
    
    private String ssn;
    private String placeOfService;
    private String updatedUser;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updatedDate;
	private String orderType;
	private Integer woundActive;
	private String repName;
	private Integer repPhoneNo;
	private Integer distributorId;
}
