package com.nextscience.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link HcpDetailsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class HcpDetailsResponse {
	
	private Integer hcpId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String npi;

    private String gender;

    private String credentials;

    private String specialty1;

    private String specialty2;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String country;

    private String zip;

    private String phone;

    private String fax;

    private String email;

    private String profWhId;

    private Double latitude;

    private Double longitude;

    private String retiredFlag;

    private Integer stageId;

    private String stageDesc;
    
    private Date rfrshDate;

    @JsonFormat(pattern="MM/dd/yyyy")
    private Date geoDate;

    private String residencyFlag;

    private String residencyStartYear;

    private String residencyGraduationYear;

    private String officePhone;

    private String cellPhone;

    private String secondaryEmail;

    private String role;

    private String salesType;

    private String createUser;

   
    private Date createDate;

    private String updateUser;

    
    private Date updateDate;


	public HcpDetailsResponse(Integer hcpId, String firstName, String middleName, String lastName, String npi,
			String gender, String credentials, String specialty1, String specialty2, String address1, String address2,
			String city, String state, String country, String zip, String phone, String fax, String email,
			String profWhId, Double latitude, Double longitude, String retiredFlag, Integer stageId, String stageDesc,
			Date rfrshDate, Date geoDate, String residencyFlag, String residencyStartYear,
			String residencyGraduationYear, String officePhone, String cellPhone, String secondaryEmail, String role,
			String salesType, String createUser, Date createDate, String updateUser, Date updateDate) {
		super();
		this.hcpId = hcpId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.npi = npi;
		this.gender = gender;
		this.credentials = credentials;
		this.specialty1 = specialty1;
		this.specialty2 = specialty2;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.profWhId = profWhId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.retiredFlag = retiredFlag;
		this.stageId = stageId;
		this.stageDesc = stageDesc;
		this.rfrshDate = rfrshDate;
		this.geoDate = geoDate;
		this.residencyFlag = residencyFlag;
		this.residencyStartYear = residencyStartYear;
		this.residencyGraduationYear = residencyGraduationYear;
		this.officePhone = officePhone;
		this.cellPhone = cellPhone;
		this.secondaryEmail = secondaryEmail;
		this.role = role;
		this.salesType = salesType;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}
    
    
    
    

}
