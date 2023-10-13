package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link PayerDetailsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class PayerDetailsResponse {

	private Integer payerId;

    private Integer planTypeId;

    private String payerName;

    private String planType;

    private String policyNo;

    private String groupId;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String zip;

    private String phone;

    private String fax;

    private String website;

    private String payerWhId;

    private String createdUser;

    
    private Date createdDate;

    private String updatedUser;

    private Date updatedDate;

	public PayerDetailsResponse(Integer payerId, Integer planTypeId, String payerName, String planType, String policyNo,
			String groupId, String address1, String address2, String city, String state, String zip, String phone,
			String fax, String website, String payerWhId, String createdUser, Date createdDate, String updatedUser,
			Date updatedDate) {
		super();
		this.payerId = payerId;
		this.planTypeId = planTypeId;
		this.payerName = payerName;
		this.planType = planType;
		this.policyNo = policyNo;
		this.groupId = groupId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.fax = fax;
		this.website = website;
		this.payerWhId = payerWhId;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}

    
}
