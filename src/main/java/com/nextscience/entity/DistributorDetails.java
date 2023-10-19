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

@Data
@Entity
@Table(name = "DIM_DISTRIBUTOR", schema = "dbo")

public class DistributorDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DISTRIBUTOR_ID")
	private Integer distributorId;
	
	@Column(name = "DISTRIBUTOR_NAME")
	private String distributorName;
	
	@Column(name = "ADDRESS1")
	private String address1;
	
	@Column(name = "ADDRESS2")
	private String address2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ZIP")
	private String zip;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "FAX")
	private String fax;
	
	@Column(name = "LATITUDE")
	private BigDecimal latitude;
	
	@Column(name = "LONGITUDE")
	private BigDecimal longitude;
	
	@Column(name = "GEO_DATE")
	private Date geoDate;
	
	@Column(name = "ACTIVE_IND")
	private String activeInd;
	
	@Column(name = "WAREHOUSE_CODE")
	private String warehousecode;
	
	@Column(name = "CREATE_USER")
	private String createUser;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	
	
	
	
	

	
}
