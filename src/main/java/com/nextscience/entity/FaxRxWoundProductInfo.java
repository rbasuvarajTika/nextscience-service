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
 * Represents the entity class for FaxRxWoundProductInfo.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "BRDG_FAX_RX_WOUND_PRODUCT_INFO", schema = "dbo")

public class FaxRxWoundProductInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_FAX_ID")
	private Integer trnFaxId;

	@Column(name = "PRODUCT_ID")
	private Integer productId;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "WND1")
	private Integer wnd1;

	@Column(name = "WND2")
	private Integer wnd2;

	@Column(name = "WND3")
	private Integer wnd3;

	@Column(name = "WND4")
	private Integer wnd4;

	@Column(name = "WND_CODE", length = 10)
	private String wndCode;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
