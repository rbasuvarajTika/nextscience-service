package com.nextscience.dto.response;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdfByFaxIdResponse {
	
	private byte[] pdf;
	//private String pageRaotation;
	private Map<String,Object> pageRaotation;
	

}
