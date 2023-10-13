package com.nextscience.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link DeleteWoundInfoRequest } request.
 * @author Raghu
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteWoundInfoRequest {
	private Integer trnFaxId;
	private Integer trnRxId;	
	private Integer woundNo;
	private String user;
	

}
