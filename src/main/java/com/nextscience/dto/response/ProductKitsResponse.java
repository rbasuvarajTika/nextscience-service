package com.nextscience.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link ProductKitsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class ProductKitsResponse {

	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer productId;
	private String productCode;
	private String productDisplayName;
	private Integer quantity;
	private Integer wnd1;
	private Integer wnd2;
	private Integer wnd3;
	private Integer wnd4;
	private String wndCode;
	public ProductKitsResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer productId, String productCode,
			String productDisplayName, Integer quantity, Integer wnd1, Integer wnd2, Integer wnd3, Integer wnd4,
			String wndCode) {
		super();
		this.trnRxId = trnRxId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.productId = productId;
		this.productCode = productCode;
		this.productDisplayName = productDisplayName;
		this.quantity = quantity;
		this.wnd1 = wnd1;
		this.wnd2 = wnd2;
		this.wnd3 = wnd3;
		this.wnd4 = wnd4;
		this.wndCode = wndCode;
	}

}
