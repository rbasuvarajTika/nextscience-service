package com.nextscience.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertHcpInfoRequest {
	private Integer trnFaxId;
	private Integer providerType;
	private Integer signature_Flag;
	private Date signature_Date;
	private String npi;
	private String firstName;
	private String middleName;
	private String lastName;
	private String specialty1;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
    private String phone;
	private String fax;
	private String email;
	private String createUser;

}
