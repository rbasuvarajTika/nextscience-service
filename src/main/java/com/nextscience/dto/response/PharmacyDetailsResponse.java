package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link PharmacyDetailsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class PharmacyDetailsResponse {
	
	private Integer pharmacyId;

    private String pharmacyName;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String zip;

    private String phone;

    private String fax;

    private String website;

    private String pharmacyWhId;

    private String createdUser;

    
    private Date createdDate;

    private String updatedUser;

    
    private Date updatedDate;


	public PharmacyDetailsResponse(Integer pharmacyId, String pharmacyName, String address1, String address2,
			String city, String state, String zip, String phone, String fax, String website, String pharmacyWhId,
			String createdUser, Date createdDate, String updatedUser, Date updatedDate) {
		super();
		this.pharmacyId = pharmacyId;
		this.pharmacyName = pharmacyName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.fax = fax;
		this.website = website;
		this.pharmacyWhId = pharmacyWhId;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}
    
    

}
