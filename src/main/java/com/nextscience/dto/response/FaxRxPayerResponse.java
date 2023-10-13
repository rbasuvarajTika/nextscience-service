package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxRxPayerResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxRxPayerResponse {
	
	private Integer trnFaxPayerId;

    private Integer trnFaxId;

    private Integer profId;

    private Integer payerId;
    
    private String createdUser;

    private Date createdDate;

    private String updatedUser;

    private Date updatedDate;

    public FaxRxPayerResponse(Integer trnFaxPayerId, Integer trnFaxId, Integer profId, Integer payerId,
			String createdUser, Date createdDate, String updatedUser, Date updatedDate) {
		super();
		this.trnFaxPayerId = trnFaxPayerId;
		this.trnFaxId = trnFaxId;
		this.profId = profId;
		this.payerId = payerId;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}

	

}
