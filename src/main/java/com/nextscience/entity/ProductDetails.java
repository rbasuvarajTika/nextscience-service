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
 * Represents the entity class for ProductDetails.request
 * 
 * @author Raghu
 */

@Data
@Entity
@Table(name = "DIM_PRODUCT ", schema = "dbo")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Integer productId;

	@Column(name = "PRODUCT_CODE", length = 100)
	private String productCode;

	@Column(name = "PRODUCT_NAME", length = 500)
	private String productName;

	@Column(name = "PRODUCT_DISPLAY_NAME", length = 500)
	private String productDisplayName;

	@Column(name = "PRODUCT_SHORT_NAME", length = 12)
	private String productShortName;

	@Column(name = "PRODUCT_GROUP_CODE", length = 55)
	private String productGroupCode;

	@Column(name = "PRODUCT_GROUP_DESC", length = 500)
	private String productGroupDesc;

	@Column(name = "PRODUCT_ORDER")
	private Integer productOrder;

	@Column(name = "PRODUCT_PRICE", precision = 18, scale = 2)
	private BigDecimal productPrice;

	@Column(name = "DESCRIPTION", length = 255)
	private String description;

	@Column(name = "PRODUCT_WH_ID")
	private Integer productWhId;

	@Column(name = "PRODUCT_GROUP_ID")
	private Integer productGroupId;

	@Column(name = "PRODUCT_CATEGORY", length = 50)
	private String productCategory;

	@Column(name = "PRODUCT_UOM", length = 50)
	private String productUom;

	@Column(name = "PRODUCT_QTY")
	private Integer productQty;

	@Column(name = "ACTIVE_FLAG", length = 5)
	private String activeFlag;

	@Column(name = "CREATE_USER", length = 255)
	private String createUser;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "UPDATE_USER", length = 255)
	private String updateUser;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

}
