package com.nextscience.dto.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxRxResponse } response.
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
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date faxDate;
	private String faxNumber;
	private String ocrStatus;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date ocrDate;
	@JsonFormat(pattern="HH:MM:SS")
	private Date faxDateTime;
	private String verifiedFlag;
	private String actionRequired;
	
	
	
	
	public FaxRxResponse(Integer trnFaxId, String faxId, Integer caseId, String faxStatus, String dupeFaxId,
			Date faxDate, String faxNumber, String ocrStatus, Date ocrDate, Date faxDateTime, String verifiedFlag,
			String actionRequired) {
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
	}
	
	
	
	

	
	}

