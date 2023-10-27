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
	private String npi;
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer signature_Flag;
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date signature_Date;
	private String createUser;

}
