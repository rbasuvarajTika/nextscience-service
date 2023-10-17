package com.nextscience.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductInfoResponse {
	private Integer productId;
	private String productCode;
	private String productName;

	public ProductInfoResponse(Integer productId, String productCode, String productName) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
	}

}
