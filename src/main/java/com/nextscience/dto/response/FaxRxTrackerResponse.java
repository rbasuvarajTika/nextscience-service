package com.nextscience.dto.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxRxTrackerResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxRxTrackerResponse {

	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer caseId;
	@JsonFormat(pattern="MM/dd/yyyy")
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
	@JsonFormat(pattern="MM/dd/yyyy")
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
	
	
	public FaxRxTrackerResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer caseId, Date faxDate,
			String faxNumber, String faxUrl, String verifiedFlag, String hcpName, String providerType,
			String hcpAddress1, String hcpAddress2, String hcpCity, String hcpState, String hcpZip, String accountName,
			String accAddress1, String accCity, String accState, String accZip, String patientName, Date dateOfBirth,
			String gender, String cellPhone, String workPhone, String shipToAddress, String patientCity,
			String patientState, String patientZip, String patientZip4, String ssn, String mrn, String pmsId,
			String maritialStatus, String emergencyContactName, String emergencyContactPhone, String productCode,
			String productDisplayName, String wndCode) {
		super();
		this.trnRxId = trnRxId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.caseId = caseId;
		this.faxDate = faxDate;
		this.faxNumber = faxNumber;
		this.faxUrl = faxUrl;
		this.verifiedFlag = verifiedFlag;
		this.hcpName = hcpName;
		this.providerType = providerType;
		this.hcpAddress1 = hcpAddress1;
		this.hcpAddress2 = hcpAddress2;
		this.hcpCity = hcpCity;
		this.hcpState = hcpState;
		this.hcpZip = hcpZip;
		this.accountName = accountName;
		this.accAddress1 = accAddress1;
		this.accCity = accCity;
		this.accState = accState;
		this.accZip = accZip;
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.shipToAddress = shipToAddress;
		this.patientCity = patientCity;
		this.patientState = patientState;
		this.patientZip = patientZip;
		this.patientZip4 = patientZip4;
		this.ssn = ssn;
		this.mrn = mrn;
		this.pmsId = pmsId;
		this.maritialStatus = maritialStatus;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhone = emergencyContactPhone;
		this.productCode = productCode;
		this.productDisplayName = productDisplayName;
		this.wndCode = wndCode;
		
	}
	
	
	
}
