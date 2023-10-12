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
public class InsertProductInfoRequest {
	
	private Integer trnFaxId;
	private Integer productId;
	private Integer quantity;
	private Integer wnd1;
	private Integer wnd2;
	private Integer wnd3;
	private Integer wnd4;
	private String createdUser;
	private Date createdDate;
	

}
