package com.nextscience.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link OfficeAccResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class OfficeAccResponse {
	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer accountId;
	private String accountName;
	private String phone;
	private String email;
	private String address1;
	private String city;

	private String state;

	private String zip;

	public OfficeAccResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer accountId, String accountName,String phone,String email,
			String address1, String city, String state, String zip) {
		super();
		this.trnRxId = trnRxId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.accountId = accountId;
		this.accountName = accountName;
		this.phone = phone;
		this.email = email;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

}
