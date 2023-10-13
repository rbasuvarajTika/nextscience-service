package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxRxWoundInfoResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxRxWoundInfoResponse {
	
	private Integer trnFaxId;

    private Integer woundNo;

    private String woundLocation;
    
    private float woundLength;

    private float woundWidth;

    private float woundDepth;

    private String woundThickness;

    private String drainage;

    private Integer debrided;

    
    private Date debridedDate;

    private String icdCode;

    private String createdUser;

    
    private Date createdDate;

    private String updatedUser;

    
    private Date updatedDate;


    public FaxRxWoundInfoResponse(Integer trnFaxId, Integer woundNo, String woundLocation, float woundLength,
			float woundWidth, float woundDepth, String woundThickness, String drainage, Integer debrided,
			Date debridedDate, String icdCode, String createdUser, Date createdDate, String updatedUser,
			Date updatedDate) {
		super();
		this.trnFaxId = trnFaxId;
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
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}


	
}
