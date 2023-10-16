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
 * Represents the entity class for FaxRxPayer.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "BRDG_FAX_RX_PAYER", schema = "dbo")
public class FaxRxPayer {

	@Column(name = "TRN_FAX_PAYER_ID")
	private Integer trnFaxPayerId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_FAX_ID")
	private Integer trnFaxId;

	@Column(name = "PROF_ID")
	private Integer profId;

	@Column(name = "PAYER_ID")
	private Integer payerId;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
