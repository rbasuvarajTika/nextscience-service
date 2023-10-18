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
 * Represents the entity class for PatientDetails.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "DIM_PATIENT ", schema = "dbo")
public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PATIENT_ID")
	private Integer patientId;

	@Column(name = "PATIENT_FIRST_NAME", length = 125)
	private String patientFirstName;

	@Column(name = "PATIENT_LAST_NAME", length = 125)
	private String patientLastName;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name = "GENDER", length = 15)
	private String gender;

	@Column(name = "CELL_PHONE", length = 15)
	private String cellPhone;

	@Column(name = "WORK_PHONE", length = 15)
	private String workPhone;

	@Column(name = "SHIP_TO_ADDRESS", length = 255)
	private String shipToAddress;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "STATE", length = 2)
	private String state;

	@Column(name = "ZIP", length = 5)
	private String zip;

	@Column(name = "ZIP4", length = 4)
	private String zip4;

	@Column(name = "SSN", length = 15)
	private String ssn;

	@Column(name = "MRN", length = 15)
	private String mrn;

	@Column(name = "PMS_ID", length = 15)
	private String pmsId;

	@Column(name = "MARITIAL_STATUS", length = 15)
	private String maritialStatus;

	@Column(name = "EMERGENCY_CONTACT_NAME", length = 125)
	private String emergencyContactName;

	@Column(name = "EMERGENCY_CONTACT_PHONE", length = 15)
	private String emergencyContactPhone;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
