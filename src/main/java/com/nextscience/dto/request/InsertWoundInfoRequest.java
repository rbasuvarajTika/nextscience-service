package com.nextscience.dto.request;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link InsertWoundInfoRequest } request.
 * @author Raghu
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertWoundInfoRequest {
	private Integer trnFaxId;
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
	private String createdUser;
	private Date createdDate;

}
