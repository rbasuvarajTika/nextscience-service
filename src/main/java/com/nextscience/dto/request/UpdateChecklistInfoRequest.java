package com.nextscience.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateChecklistInfoRequest {
	private Integer trnRxId;
	private Integer trnFaxId;
	private Integer rxChecklistId;
	private String checklist_Flag;
	private String comments;
	private String updatedUser;
	private Date updatedDate;

}
