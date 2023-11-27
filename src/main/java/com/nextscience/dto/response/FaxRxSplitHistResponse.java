package com.nextscience.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class FaxRxSplitHistResponse {
	private Integer trnFaxSplitId;
	private Integer trnFaxId;
	private String faxId;
	private String faxFileName;
	private String splitFaxId;
	private String splitFileName;
	private String faxUrl;
	private String splitPages;
	private Integer pageCount;
	private String createdUser;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date createdDate;
	private String updatedUser;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date updatedDate;
	public FaxRxSplitHistResponse(Integer trnFaxSplitId, Integer trnFaxId, String faxId, String faxFileName,
			String splitFaxId, String splitFileName, String faxUrl, String splitPages, Integer pageCount,
			String createdUser, Date createdDate, String updatedUser, Date updatedDate) {
		super();
		this.trnFaxSplitId = trnFaxSplitId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.faxFileName = faxFileName;
		this.splitFaxId = splitFaxId;
		this.splitFileName = splitFileName;
		this.faxUrl = faxUrl;
		this.splitPages = splitPages;
		this.pageCount = pageCount;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}

	
}
