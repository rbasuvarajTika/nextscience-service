package com.nextscience.dto.response;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link ProductDetailsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor

public class ProductDetailsResponse {
	
	private Integer productId;

    private String productCode;

    private String productName;

    private String productDisplayName;

    private String productShortName;

    private String productGroupCode;

    private String productGroupDesc;

    private Integer productOrder;

    private BigDecimal productPrice;

    private String description;

    private Integer productWhId;

    private Integer productGroupId;

    private String productCategory;

    private String productUom;

    private Integer productQty;

    private String activeFlag;

    private String createUser;

    
    private Date createDate;

    private String updateUser;

    
    private Date updateDate;


	public ProductDetailsResponse(Integer productId, String productCode, String productName, String productDisplayName,
			String productShortName, String productGroupCode, String productGroupDesc, Integer productOrder,
			BigDecimal productPrice, String description, Integer productWhId, Integer productGroupId, String productCategory,
			String productUom, Integer productQty, String activeFlag, String createUser, Date createDate,
			String updateUser, Date updateDate) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productDisplayName = productDisplayName;
		this.productShortName = productShortName;
		this.productGroupCode = productGroupCode;
		this.productGroupDesc = productGroupDesc;
		this.productOrder = productOrder;
		this.productPrice = productPrice;
		this.description = description;
		this.productWhId = productWhId;
		this.productGroupId = productGroupId;
		this.productCategory = productCategory;
		this.productUom = productUom;
		this.productQty = productQty;
		this.activeFlag = activeFlag;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}


}
