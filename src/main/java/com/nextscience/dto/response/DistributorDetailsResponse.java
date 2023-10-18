package com.nextscience.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DistributorDetailsResponse {
	private Integer distributorId;
	private String distributorName;
	public DistributorDetailsResponse(Integer distributorId, String distributorName) {
		super();
		this.distributorId = distributorId;
		this.distributorName = distributorName;
	}

}
