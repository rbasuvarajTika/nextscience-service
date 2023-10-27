package com.nextscience.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link PatientDetailsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class PatientDetailsResponse {
	
	private Integer patientId;

    private String patientFirstName;

    private String patientLastName;

    @JsonFormat(pattern="MM/dd/yyyy")
    private Date dateOfBirth;

    private String gender;

    private String cellPhone;

    private String workPhone;

    private String shipToAddress;

    private String city;

    private String state;

    private String zip;

    private String zip4;

    private String ssn;

    private String mrn;

    private String pmsId;

    private String maritalStatus;

    private String emergencyContactName;

    private String emergencyContactPhone;

    private String createdUser;

    
    private Date createdDate;

    private String updatedUser;

    
    private Date updatedDate;


	public PatientDetailsResponse(Integer patientId, String patientFirstName, String patientLastName, Date dateOfBirth,
			String gender, String cellPhone, String workPhone, String shipToAddress, String city, String state,
			String zip, String zip4, String ssn, String mrn, String pmsId, String maritalStatus,
			String emergencyContactName, String emergencyContactPhone, String createdUser, Date createdDate,
			String updatedUser, Date updatedDate) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.shipToAddress = shipToAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.zip4 = zip4;
		this.ssn = ssn;
		this.mrn = mrn;
		this.pmsId = pmsId;
		this.maritalStatus = maritalStatus;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhone = emergencyContactPhone;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}


}
