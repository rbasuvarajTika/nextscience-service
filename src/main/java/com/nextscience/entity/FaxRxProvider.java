package com.nextscience.entity;

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
@Table(name = "BRDG_FAX_RX_PROVIDER" , schema ="dbo")
public class FaxRxProvider {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_FAX_PROVIDER_ID")
	private Integer trnFaxProviderId;
	
	@Column(name = "TRN_FAX_ID")
	private Integer trnFaxId;
	
	@Column(name = "PROF_ID")
	private Integer profId;
	
	@Column(name = "PROVIDER_TYPE", length = 25)
	private Integer providerType;
	
	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	
	
	
}
