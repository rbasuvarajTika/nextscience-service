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
public class FaxRxDupeRequest {
	
	public Integer dupeTrnFaxId;
	public Integer mainTrnFaxId;
	public String user;
	
	
	
	

}
