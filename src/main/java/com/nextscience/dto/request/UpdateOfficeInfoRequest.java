package com.nextscience.dto.request;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link UpdateOfficeInfoRequest } request.
 * 
 * @author Raghu
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOfficeInfoRequest {
	private Integer trnFaxId;
	private Integer trnRxId;
	private Integer accountId;
	private String accountName;
	private String phone;
	private String email;
	private String address1;
	private String city;
	private String state;
	private String zip;
	private String updatedUser;

}
