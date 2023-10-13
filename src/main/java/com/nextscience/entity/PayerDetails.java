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
 * Represents the entity class for PayerDetails.
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "DIM_PAYER ", schema = "dbo")

public class PayerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYER_ID")
	private Integer payerId;

	@Column(name = "PLAN_TYPE_ID")
	private Integer planTypeId;

	@Column(name = "PAYER_NAME", length = 255)
	private String payerName;

	@Column(name = "PLAN_TYPE", length = 50)
	private String planType;

	@Column(name = "POLICY_NO", length = 50)
	private String policyNo;

	@Column(name = "GROUP_ID", length = 50)
	private String groupId;

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

	@Column(name = "PAYER_WH_ID", length = 15)
	private String payerWhId;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
}
