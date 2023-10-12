package com.nextscience.dto.request;

import java.math.BigDecimal;
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
public class UpdateHcpInfoRequest {
	private Integer trnFaxId;
	private Integer profId;
	private Integer hcpId;
	private String signature_Flag;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date signature_Date;
    private String updatedUser;
    private Date updatedDate;
	 
	

}
