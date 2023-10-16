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
 * Represents the entity class for AccountDetails.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "DIM_ACCOUNT ", schema = "dbo")
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private Integer accountId;

	@Column(name = "ACCT_WH_ID", length = 20)
	private String acctWhId;

	@Column(name = "ACCOUNT_NAME", length = 255)
	private String accountName;

	@Column(name = "ACCOUNT_NAME2", length = 255)
	private String accountName2;

	@Column(name = "ACCOUNT_TYPE", length = 50)
	private String accountType;

	@Column(name = "FACILITY_TYPE", length = 150)
	private String facilityType;

	@Column(name = "ADDRESS1", length = 150)
	private String address1;

	@Column(name = "ADDRESS2", length = 150)
	private String address2;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "STATE", length = 2)
	private String state;

	@Column(name = "ZIP", length = 10)
	private String zip;

	@Column(name = "COUNTRY", length = 50)
	private String country;

	@Column(name = "PHONE", length = 50)
	private String phone;

	@Column(name = "FAX", length = 25)
	private String fax;

	@Column(name = "EMAIL", length = 100)
	private String email;

	@Column(name = "NPI", length = 10)
	private String npi;

	@Column(name = "INTERNAL_ID", length = 25)
	private String internalId;

	@Column(name = "CUST_ID", length = 25)
	private String custId;

	@Column(name = "LATITUDE", columnDefinition = "real")
	private float latitude;

	@Column(name = "LONGITUDE", columnDefinition = "real")
	private float longitude;

	@Column(name = "GEO_DATE")
	private Date geoDate;

	@Column(name = "WEBSITE", length = 255)
	private String website;

	@Column(name = "ACO_AFFILIATIONS", length = 4500)
	private String acoAffiliations;

	@Column(name = "OWNERSHIP", length = 255)
	private String ownership;

	@Column(name = "MED_SCHOOL_AFFILIATION", length = 255)
	private String medSchoolAffiliations;

	@Column(name = "DHC_PROFILE_LINK", length = 255)
	private String dhcProfileLink;

	@Column(name = "GPO_AFFILIATIONS", length = 500)
	private String gpoAffiliations;

	@Column(name = "IDN_WH_ID", length = 25)
	private String idnWhId;

	@Column(name = "IDN_NAME", length = 255)
	private String idnName;

	@Column(name = "PARENT_IDN_WH_ID", length = 25)
	private String parentIdnWhId;

	@Column(name = "PARENT_IDN_NAME", length = 255)
	private String parentIdnName;

	@Column(name = "IDN_INTEGRATION_LEVEL", length = 255)
	private String idnIntegrationLevel;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "PRIMARY_HIN", length = 25)
	private String primaryHin;

	@Column(name = "FACILITY_NICKNAME", length = 255)
	private String faculityNickname;

	@Column(name = "GPO_MEMBERSHIP", length = 255)
	private String gpoMembership;

	@Column(name = "ACTIVE_FLAG", length = 25)
	private String activeFlag;

	@Column(name = "COMPLEX", length = 255)
	private String complex;

	@Column(name = "NETWORK", length = 255)
	private String network;

	@Column(name = "FACILITY_CLASSIFICATION", length = 255)
	private String faculityClassification;

	@Column(name = "ACCOUNT_NAME_2", length = 150)
	private String AccountName2;

	@Column(name = "KEY_ACCOUNT", length = 5)
	private String keyAccount;

	@Column(name = "ACCOUNT_CLASS", length = 255)
	private String accountClass;

	@Column(name = "STATE_NAME", length = 255)
	private String stateName;

	@Column(name = "NATIONAL_ACCOUNT_FLAG", length = 5)
	private String nationalAccountFlag;

	@Column(name = "SF_ACCOUNT_NUMBER", length = 25)
	private String sfAccountNumber;

	@Column(name = "SF_ACCOUNT_ID", length = 25)
	private String sfAccountId;

	@Column(name = "SF_ACCOUNT_NAME", length = 255)
	private String sfAccountName;

	@Column(name = "SF_PARENT_ACCOUNT", length = 255)
	private String sfParentAccount;

	@Column(name = "SF_PARENT_ACCOUNT_ID", length = 25)
	private String sfParentAccountId;

	@Column(name = "SF_MATCH_TYPE", length = 500)
	private String sfMatchType;

	@Column(name = "ACCT_STATUS", length = 25)
	private String acctStatus;

	@Column(name = "ACCT_CATG", length = 25)
	private String acctCatg;

	@Column(name = "STATUS", length = 25)
	private String status;

	@Column(name = "STATUS_DATE")
	private Date statusDate;
}
