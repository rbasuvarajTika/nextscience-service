package com.nextscience.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFaxRxSplitHistRequest {

	private Integer trnFaxSplitId;
	private String splitStatus;	
	private String splitAttempts;
	private String updatedUser;
	
}
