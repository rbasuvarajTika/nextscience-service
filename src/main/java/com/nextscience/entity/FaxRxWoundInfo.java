package com.nextscience.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents the entity class for FaxRxWoundInfo.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "BRDG_FAX_RX_WOUND_INFO", schema = "dbo")

public class FaxRxWoundInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_FAX_ID")
	private Integer trnFaxId;

	@Column(name = "WOUND_NO")
	private Integer woundNo;

	@Column(name = "WOUND_LOCATION", length = 50)
	private String woundLocation;

	@Column(name = "WOUND_LENGTH", precision = 5, scale = 2)
	private float woundLength;

	@Column(name = "WOUND_WIDTH", precision = 5, scale = 2)
	private float woundWidth;

	@Column(name = "WOUND_DEPTH", precision = 5, scale = 2)
	private float woundDepth;

	@Column(name = "WOUND_THICKNESS", length = 1)
	private String woundThickness;

	@Column(name = "DRAINAGE", length = 15)
	private String drainage;

	@Column(name = "DEBRIDED")
	private Integer debrided;

	@Column(name = "DEBRIDED_DATE")
	private Date debridedDate;

	@Column(name = "ICD_CODE", length = 15)
	private String icdCode;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
