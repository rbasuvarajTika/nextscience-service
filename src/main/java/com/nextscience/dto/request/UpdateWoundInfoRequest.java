package com.nextscience.dto.request;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link UpdateWoundInfoRequest } request.
 * 
 * @author Raghu
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWoundInfoRequest {

	private int trnFaxId;
	private int trnRxId;
	private String woundNo;

	private String woundLocation;

	private double woundLength;

	private double woundWidth;

	private double woundDepth;

	private String woundThickness;
	private String woundType;

	private String drainage;

	private int debrided;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date debridedDate;
	private String debridedType;

	private String icdCode;
	private String updatedUser;
	private String status;

}
