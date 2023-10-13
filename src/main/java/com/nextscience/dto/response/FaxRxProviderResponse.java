package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxRxProviderResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxRxProviderResponse {
	
	private Integer trnFaxProviderId;
	private Integer trnFaxId;
	private Integer profId;
	private String providerType;
	private String createdUser;
	private Date createdDate;
	private String updatedUser;
	private Date updatedDate;
	
	
	public FaxRxProviderResponse(Integer trnFaxProviderId, Integer trnFaxId, Integer profId, String providerType,
			String createdUser, Date createdDate, String updatedUser, Date updatedDate) {
		super();
		this.trnFaxProviderId = trnFaxProviderId;
		this.trnFaxId = trnFaxId;
		this.profId = profId;
		this.providerType = providerType;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}
	
	

}
