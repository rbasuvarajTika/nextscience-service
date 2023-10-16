package com.nextscience.entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents the entity class for FaxRxCase.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "BRDG_FAX_RX_CASES", schema = "dbo")
public class FaxRxCase {

	@Column(name = "TRN_FAX_RX_CASE_ID")
	private Integer trnFaxRxCaseId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CASE_ID")
	private Integer caseId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRN_FAX_ID") // Name of the foreign key column
	private FaxRx faxRx;

	@Column(name = "DUPE_FAX_ID", length = 25)
	private String dupeFaxId;

	@Column(name = "CASE_TYPE", length = 25)
	private String caseType;

	@Column(name = "CASE_COMMENTS", length = 255)
	private String caseComments;

	@Column(name = "ACTION_REQUIRED")
	private Integer actionRequired;

	@Column(name = "ACTIVE_FLAG")
	private Integer activeFlag;

	@Column(name = "VERIFIED_FLAG")
	private Integer verifiedFlag;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	// Constructors, getters, and setters
}
