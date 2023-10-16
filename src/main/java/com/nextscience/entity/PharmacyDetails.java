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
 * Represents the entity class for PharmacyDetails.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "DIM_PHARMACY ", schema = "dbo")

public class PharmacyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PHARMACY_ID")
	private Integer pharmacyId;

	@Column(name = "PHARMACY_NAME", length = 255)
	private String pharmacyName;

	@Column(name = "ADDRESS1", length = 100)
	private String address1;

	@Column(name = "ADDRESS2", length = 50)
	private String address2;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "STATE", length = 2)
	private String state;

	@Column(name = "ZIP", length = 5)
	private String zip;

	@Column(name = "PHONE", length = 15)
	private String phone;

	@Column(name = "FAX", length = 15)
	private String fax;

	@Column(name = "WEBSITE", length = 255)
	private String website;

	@Column(name = "PHARMACY_WH_ID", length = 15)
	private String pharmacyWhId;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
