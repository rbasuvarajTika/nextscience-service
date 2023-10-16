package com.nextscience.entity;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents the entity class for HcpDetails.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "DIM_HCP", schema = "dbo")
public class HcpDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HCP_ID")
	private Integer hcpId;

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "MIDDLE_NAME", length = 25)
	private String middleName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@Column(name = "NPI", length = 25)
	private String npi;

	@Column(name = "GENDER", length = 10)
	private String gender;

	@Column(name = "CREDENTIALS", length = 50)
	private String credentials;

	@Column(name = "SPECIALTY1", length = 150)
	private String specialty1;

	@Column(name = "SPECIALTY2", length = 150)
	private String specialty2;

	@Column(name = "ADDRESS1", length = 150)
	private String address1;

	@Column(name = "ADDRESS2", length = 150)
	private String address2;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "STATE", length = 25)
	private String state;

	@Column(name = "COUNTRY", length = 50)
	private String country;

	@Column(name = "ZIP", length = 10)
	private String zip;

	@Column(name = "PHONE", length = 25)
	private String phone;

	@Column(name = "FAX", length = 25)
	private String fax;

	@Column(name = "EMAIL", length = 100)
	private String email;

	@Column(name = "PROF_WH_ID", length = 25)
	private String profWhId;

	@Column(name = "LATITUDE", precision = 18, scale = 9)
	private BigDecimal latitude;

	@Column(name = "LONGITUDE", precision = 18, scale = 9)
	private BigDecimal longitude;

	@Column(name = "RETIRED_FLAG", length = 1)
	private String retiredFlag;

	@Column(name = "STAGE_ID")
	private Integer stageId;

	@Column(name = "STAGE_DESC", length = 50)
	private String stageDesc;

	@Column(name = "RFRSH_DATE")
	private Date rfrshDate;

	@Column(name = "GEO_DATE")
	private Date geoDate;

	@Column(name = "ResidencyFlag", length = 5)
	private String residencyFlag;

	@Column(name = "ResidencyStartYear", length = 10)
	private String residencyStartYear;

	@Column(name = "ResidencyGraduationYear", length = 10)
	private String residencyGraduationYear;

	@Column(name = "OFFICE_PHONE", length = 20)
	private String officePhone;

	@Column(name = "CELL_PHONE", length = 20)
	private String cellPhone;

	@Column(name = "SECONDARY_EMAIL", length = 255)
	private String secondaryEmail;

	@Column(name = "ROLE", length = 55)
	private String role;

	@Column(name = "SALES_TYPE", length = 55)
	private String salesType;

	@Column(name = "CREATE_USER", length = 255)
	private String createUser;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "UPDATE_USER", length = 255)
	private String updateUser;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

}
