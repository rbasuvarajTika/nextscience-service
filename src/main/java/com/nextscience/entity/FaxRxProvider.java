package com.nextscience.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents the entity class for FaxRxProvider.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "BRDG_FAX_RX_PROVIDER", schema = "dbo")
public class FaxRxProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_FAX_PROVIDER_ID")
	private Integer trnFaxProviderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRN_FAX_ID")
	private FaxRx faxRx;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HCP_ID")
	private HcpDetails hcpDetails;

	@Column(name = "PROVIDER_TYPE", length = 25)
	private String providerType;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
