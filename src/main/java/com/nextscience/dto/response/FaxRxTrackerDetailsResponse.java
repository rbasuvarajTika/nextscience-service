package com.nextscience.dto.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxRxTrackerDetailsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxRxTrackerDetailsResponse {
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
	private Integer patientId;
	private String processStatus;
	private String rxFulfilmentStatus;
	private Integer netsuiteRxId;
	private String primaryPayerName;
	private Integer primaryPayerId;
	private String payerType;
	
	
	
	
	
	
	public FaxRxTrackerDetailsResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer caseId, Date faxDate,
			String faxNumber, String faxUrl, String verifiedFlag, String hcpName,
			String hcpAddress1, String hcpAddress2, String hcpCity, String hcpState, String hcpZip, String accountName,
			String accAddress1, String accCity, String accState, String accZip, String patientName, Date dateOfBirth,
			String gender, String cellPhone, String workPhone, String shipToAddress, String patientCity,
			String patientState, String patientZip, String patientZip4, String ssn, String mrn, String pmsId,
			String maritialStatus, String emergencyContactName, String emergencyContactPhone, Integer patientId,String processStatus,
			String rxFulfilmentStatus, Integer netsuiteRxId, String primaryPayerName,Integer primaryPayerId, String payerType
			) {
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
		this.patientId = patientId;
		this.processStatus = processStatus;
		this.rxFulfilmentStatus = rxFulfilmentStatus;
		this.netsuiteRxId = netsuiteRxId;
		this.primaryPayerName = primaryPayerName;
		this.primaryPayerId = primaryPayerId;
		this.payerType = payerType;
		
	}
	
	

	
	
	
	
	

}
