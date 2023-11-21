package com.nextscience.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TRN_FAX_RX_HIST", schema = "dbo")
public class FaxRxSplitHist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_FAX_SPLIT_ID")
	private Integer trnFaxSplitId;
	
	@Column(name = "TRN_FAX_ID")
	private Integer trnFaxId;

	@Column(name = "FAX_ID", length = 25)
	private String faxId;

	@Column(name = "FAX_FILENAME", length = 255)
	private String faxFileName;
	
	@Column(name = "SPLIT_FAX_ID" , length = 25)
	private String splitFaxId;
	
	@Column(name = "SPLIT_FILE_NAME" , length = 255)
	private String splitFileName;

	@Column(name = "FAX_URL")
	private String faxUrl;


	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	

}
