package com.nextscience.dto.request;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link UpdatePatientTrnFaxRxRequest } request.
 * @author Raghu
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePatientTrnFaxRxRequest {
	
	private Integer patientId;
	private Integer trnFaxId;
	private Integer trnRxId;
	private String faxId;
	
	private String patientFullName;
	private String patientName;
	private String patientFirstName;
	private String patientMiddleName;
	private String patientLastName;
	
	
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date dateOfBirth;
	
	private String cellPhone;
	private String shipToAddress;
	private String city;
	private String state;
    private String zip;
    
    private String ssn;
    private String placeOfService;
    private String updatedUser;
    @JsonFormat(pattern="MM/dd/yyyy")
    private Date updatedDate;
	private String orderType;
	private String woundActive;
	private String repName;
	private String repPhoneNo;
	private Integer distributorId;
	private String distributorName;
}
