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
 * Represents the entity class for FaxPrescriptions.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "TRN_FAX_RX_PRESCRIPTIONS", schema = "dbo")

public class FaxPrescriptions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_RX_ID")
	private Integer trnRxId;

	@Column(name = "TRN_FAX_ID")
	private Integer trnFaxId;

	@Column(name = "PROCESS_STATUS", length = 25)
	private String processStatus;

	@Column(name = "RX_STATUS", length = 25)
	private String rxStatus;

	@Column(name = "PATIENT_ID")
	private Integer patientId;

	@Column(name = "ACCOUNT_ID")
	private Integer accountId;

	@Column(name = "PROF_ID")
	private Integer profId;

	@Column(name = "EMAIL", length = 255)
	private String email;

	@Column(name = "REP_NAME", length = 125)
	private String repName;

	@Column(name = "TERRITORY_ID", length = 155)
	private String territoryId;

	@Column(name = "PAYER_ID")
	private Integer payerId;

	@Column(name = "PAYER_TYPE", length = 25)
	private String payerType;

	@Column(name = "NETSUITE_RX_ID")
	private Integer netsuiteRxId;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
