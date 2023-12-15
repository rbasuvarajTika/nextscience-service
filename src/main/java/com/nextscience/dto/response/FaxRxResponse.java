package com.nextscience.dto.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxRxResponse } response.
 * 
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxRxResponse {

	private Integer trnFaxId;
	private String faxId;
	private Integer caseId;
	private String faxStatus;
	private String dupeFaxId;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date faxDate;
	private String faxNumber;
	private String ocrStatus;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date ocrDate;
	@JsonFormat(pattern = "HH:MM:SS")
	private Date faxDateTime;

	private Integer noOfRxs;
	private String verifiedFlag;
	private String actionRequired;

	private String accountName;

	private String hcpFirstName;
	private String hcpLastName;

	private String patientFirstName;
	private String patientLastName;

	public FaxRxResponse(Integer trnFaxId, String faxId, Integer caseId, String faxStatus, String dupeFaxId,
			Date faxDate, String faxNumber, String ocrStatus, Date ocrDate, Date faxDateTime, String verifiedFlag,
			String actionRequired, String accountName, String hcpFirstName, String hcpLastName,
			String patientFirstName, String patientLastName) {
		super();
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.caseId = caseId;
		this.faxStatus = faxStatus;
		this.dupeFaxId = dupeFaxId;
		this.faxDate = faxDate;
		this.faxNumber = faxNumber;
		this.ocrStatus = ocrStatus;
		this.ocrDate = ocrDate;
		this.faxDateTime = faxDateTime;
		this.verifiedFlag = verifiedFlag;
		this.actionRequired = actionRequired;
		this.accountName = accountName;
		this.hcpFirstName = hcpFirstName;
		this.hcpLastName = hcpLastName;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
	}

}
