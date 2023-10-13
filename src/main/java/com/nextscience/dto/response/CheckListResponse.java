package com.nextscience.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link CheckListResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class CheckListResponse {

	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer rxChecklistId;
	private String rxChecklistDesc;
	private String checklist_Flag;
	private String comments;
	public CheckListResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer rxChecklistId,
			String rxChecklistDesc, String checklist_Flag, String comments) {
		super();
		this.trnRxId = trnRxId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.rxChecklistId = rxChecklistId;
		this.rxChecklistDesc = rxChecklistDesc;
		this.checklist_Flag = checklist_Flag;
		this.comments = comments;
	}
	

}
