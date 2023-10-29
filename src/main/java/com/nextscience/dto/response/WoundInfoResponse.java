package com.nextscience.dto.response;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link WoundInfoResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class WoundInfoResponse {
	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer woundNo;
	private String woundLocation;
	private BigDecimal woundLength;
	private BigDecimal woundWidth;
	private BigDecimal woundDepth;
	private String woundThickness;
	private String woundType;
	private String drainage;
	private Integer debrided;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date debridedDate;
	private String debridedType;
	private String icdCode;
	private String status="update";
	
	public WoundInfoResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer woundNo, String woundLocation,
			BigDecimal woundLength, BigDecimal woundWidth, BigDecimal woundDepth, String woundThickness,
			String woundType, String drainage, Integer debrided, Date debridedDate, String debridedType,
			String icdCode,String status) {
		super();
		this.trnRxId = trnRxId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.woundNo = woundNo;
		this.woundLocation = woundLocation;
		this.woundLength = woundLength;
		this.woundWidth = woundWidth;
		this.woundDepth = woundDepth;
		this.woundThickness = woundThickness;
		this.woundType = woundType;
		this.drainage = drainage;
		this.debrided = debrided;
		this.debridedDate = debridedDate;
		this.debridedType = debridedType;
		this.icdCode = icdCode;
		this.status=status;
	}

}
