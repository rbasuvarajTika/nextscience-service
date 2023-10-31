package com.nextscience.dto.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link RxPatientDetailsResponse } response.
 * 
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class RxPatientDetailsResponse {

	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer caseId;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date faxDate;
	private String faxNumber;
	private String faxUrl;
	private Integer patientId;
	private String patientName;
	private String patientFirstName;
	private String patientMiddleName;
	private String patientLastName;
	@JsonFormat(pattern = "MM/dd/yyyy")
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
	private String woundActive;
	private String repName;
	private String repPhoneNo;
	private Integer distributorId;
	private String distributorName;

	public RxPatientDetailsResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer caseId, Date faxDate,
			String faxNumber, String faxUrl, Integer patientId, String patientName, String patientFirstName,
			String patientLastName, Date dateOfBirth, String cellPhone, String shipToAddress, String city, String state,
			String zip, String ssn, String workPhone, String gender, String zip4, String mrn, String pmsId,
			String maritalStatus, String emergencyContactName, String emergencyContactPhone, String placeOfService,
			String orderType, String woundActive, String repName, String repPhoneNo, Integer distributorId,
			String distributorName) {
		super();
		this.trnRxId = trnRxId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.caseId = caseId;
		this.faxDate = faxDate;
		this.faxNumber = faxNumber;
		this.faxUrl = faxUrl;
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.dateOfBirth = dateOfBirth;
		this.cellPhone = cellPhone;
		this.shipToAddress = shipToAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ssn = ssn;
		this.workPhone = workPhone;
		this.gender = gender;
		this.zip4 = zip4;
		this.mrn = mrn;
		this.pmsId = pmsId;
		this.maritalStatus = maritalStatus;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhone = emergencyContactPhone;
		this.placeOfService = placeOfService;
		this.orderType = orderType;
		this.woundActive = woundActive;
		this.repName = repName;
		this.repPhoneNo = repPhoneNo;
		this.distributorId = distributorId;
		this.distributorName = distributorName;
	}

}
