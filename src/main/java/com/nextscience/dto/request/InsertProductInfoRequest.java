package com.nextscience.dto.request;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link InsertProductInfoRequest } request.
 * @author Raghu
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertProductInfoRequest {
	
	private Integer trnFaxId;
	private Integer trnRxId;
	private String productCode;
	//private Integer productId;
	private String quantity;
	private Integer wnd1;
	private Integer wnd2;
	private Integer wnd3;
	private Integer wnd4;
	private String createdUser;
	

}
