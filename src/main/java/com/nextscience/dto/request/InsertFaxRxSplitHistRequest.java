package com.nextscience.dto.request;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertFaxRxSplitHistRequest {
	
	private Integer trnFaxId;
	private String faxId;
	private String mainFileName;
	private String splitFaxId;
	private String splitFileName;
	private String faxUrl;
	private String splitPages;
	private Integer pageCount;
	private String createdUser;

}
