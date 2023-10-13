package com.nextscience.dto.request;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link UpdateChecklistInfoRequest } request.
 * @author Raghu
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateChecklistInfoRequest {
	private Integer trnFaxId;
	private Integer trnRxId;
	private Integer rxChecklistId;
	private String checklist_Flag;
	private String comments;
	private String updatedUser;
	
}
