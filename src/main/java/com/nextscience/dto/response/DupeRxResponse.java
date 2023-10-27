package com.nextscience.dto.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link DupeRxResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class DupeRxResponse {
	
	private Integer trnFaxId;
	private String faxId;
	private Integer caseId;
	private String faxStatus;
	private String dupeFaxId;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date faxDate;
	private String faxNumber;
	private String ocrStatus;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date  ocrDate;
	private String faxUrl;
	private String verifiedFlag;
	private String hcpName;
	private String 	accountName;
	private String patientName;
	
	public DupeRxResponse(Integer trnFaxId, String faxId, Integer caseId, String faxStatus, String dupeFaxId,
			Date faxDate, String faxNumber, String ocrStatus, Date ocrDate, String faxUrl, String verifiedFlag,
			String hcpName, String accountName, String patientName) {
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
		this.faxUrl = faxUrl;
		this.verifiedFlag = verifiedFlag;
		this.hcpName = hcpName;
		this.accountName = accountName;
		this.patientName = patientName;
	}
	

}
