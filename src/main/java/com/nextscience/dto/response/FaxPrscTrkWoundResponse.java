package com.nextscience.dto.response;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxPrscTrkWoundResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxPrscTrkWoundResponse {
	
	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer caseId;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date faxDate;
	private String faxNumber;
	private String faxUrl;
	private Integer woundNo;
	private String woundLocation;
    private BigDecimal woundLength;
	private BigDecimal woundWidth;
	private BigDecimal woundDepth;
	private String woundThickness;
	private String drainage;
	private Integer debrided;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date debridedDate;
	private String icdCode;
	
	public FaxPrscTrkWoundResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer caseId,
			Date faxDate, String faxNumber, String faxUrl, Integer woundNo, String woundLocation, BigDecimal woundLength,
			BigDecimal woundWidth, BigDecimal woundDepth, String woundThickness, String drainage, Integer debrided,
			Date debridedDate, String icdCode) {
		super();
		this.trnRxId = trnRxId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.caseId = caseId;
		this.faxDate = faxDate;
		this.faxNumber = faxNumber;
		this.faxUrl = faxUrl;
		this.woundNo = woundNo;
		this.woundLocation = woundLocation;
		this.woundLength = woundLength;
		this.woundWidth = woundWidth;
		this.woundDepth = woundDepth;
		this.woundThickness = woundThickness;
		this.drainage = drainage;
		this.debrided = debrided;
		this.debridedDate = debridedDate;
		this.icdCode = icdCode;
	}


}
