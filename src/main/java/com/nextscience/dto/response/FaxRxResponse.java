package com.nextscience.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FaxRxResponse {

	private Integer trnFaxId;
	private String faxId;
	private Integer caseId;
	private String faxStatus;
	private String dupeFaxId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date faxDate;
	private String faxNumber;
	private String ocrStatus;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  ocrDate;

	public FaxRxResponse(Integer trnFaxId, String faxId, Integer caseId, String faxStatus, String dupeFaxId,
			Date faxDate, String faxNumber, String ocrStatus, Date  ocrDate) {
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.caseId = caseId;
		this.faxStatus = faxStatus;
		this.dupeFaxId = dupeFaxId;
		this.faxDate = faxDate;
		this.faxNumber = faxNumber;
		this.ocrStatus = ocrStatus;
		this.ocrDate = ocrDate;
	}
}
