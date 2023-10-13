package com.nextscience.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link DeleteProductInfoRequest } request.
 * @author Raghu
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductInfoRequest {
	private Integer trnFaxId;
	private String productCode;
	private Integer trnRxId;
	private String user;

}
