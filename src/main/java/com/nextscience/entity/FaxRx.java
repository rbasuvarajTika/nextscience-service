package com.nextscience.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents the entity class for FaxRx.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "TRN_FAX_RX", schema = "dbo")

public class FaxRx {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_FAX_ID")
	private Integer trnFaxId;

	@Column(name = "FAX_ID", length = 25)
	private String faxId;

	@Column(name = "DOCUMENT_NO", length = 50)
	private String documentNo;

	@Column(name = "FAX_NUMBER", length = 15)
	private String faxNumber;

	@Column(name = "SUPPORT_CONTACT_NAME", length = 125)
	private String supportContactName;

	@Column(name = "SUPPORT_CONTACT_PHONE", length = 15)
	private String supportContactPhone;

	@Column(name = "FAX_STATUS", length = 25)
	private String faxStatus;

	@Column(name = "PROCESS_STATUS", length = 25)
	private String processStatus;

	@Column(name = "RX_STATUS", length = 25)
	private String rxStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID")
	private PatientDetails patientDetails;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private AccountDetails accountDetails;

	@Column(name = "PROF_ID")
	private Integer profId;

	@Column(name = "EMAIL", length = 255)
	private String email;

	@Column(name = "PLACE_OF_SERVICE", length = 255)
	private String placeOfService;

	@Column(name = "ORDER_TYPE", length = 25)
	private String orderType;

	@Column(name = "WOUND_ACTIVE")
	private Integer woundActive;

	@Column(name = "REP_NAME", length = 125)
	private String repName;

	@Column(name = "TERRITORY_ID", length = 155)
	private String territoryId;

	@Column(name = "PAYER_ID")
	private Integer payerId;

	@Column(name = "PAYER_TYPE", length = 25)
	private String payerType;

	@Column(name = "PHARMACY_ID")
	private Integer pharmacyId;

	@Column(name = "SIGNATURE", length = 500)
	private String signature;

	@Column(name = "FAX_DATE")
	private Date faxDate;

	@Column(name = "FAX_FILENAME", length = 255)
	private String faxFilename;

	@Column(name = "FAX_FWD_FLAG")
	private Integer faxFwdFlag;

	@Column(name = "FAX_PAGES")
	private Integer faxPages;

	@Column(name = "FAX_CALLER_ID", length = 15)
	private String faxCallerId;

	@Column(name = "FAX_RECEIVED_DATE")
	private Date faxReceivedDate;

	@Column(name = "FAX_RENAME", length = 255)
	private String faxRename;

	@Column(name = "FAX_MOVETO_FOLDER", length = 255)
	private String faxMoveToFolder;

	@Column(name = "FAX_DELETE_FLAG", length = 255)
	private String faxDeleteFlag;

	@Column(name = "OCR_STATUS", length = 25)
	private String ocrStatus;

	@Column(name = "OCR_DATE")
	private Date ocrDate;

	@Column(name = "FAX_URL")
	private String faxUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CASE_ID")
	private FaxRxCase faxRxCase;

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
