package com.nextscience.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StateDetailsResponse {

	private Integer stateId;
	private String stateName;
	private String shortName;
	private String createdUser;
	private Date createdDate;
	public StateDetailsResponse(Integer stateId, String stateName, String shortName, String createdUser,
			Date createdDate) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.shortName = shortName;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
	}

}
