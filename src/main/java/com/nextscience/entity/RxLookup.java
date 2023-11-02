package com.nextscience.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DIM_RX_LOOKUP", schema = "dbo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RxLookup {
	@Id
	@Column(name = "RX_LOOKUP_ID")
	private Integer rxLookupId;
	
	@Column(name = "RX_LOOKUP_TYPE")
	private String rxLookupType;
	
	@Column(name = "RX_LOOKUP_DISPLAY")
	private String rxLookupDisplay;
	
	@Column(name = "RX_LOOKUP_INPUT")
	private String rxLookupInput;
	
	@Column(name = "ACTIVE_IND")
	private String activeInd;
	
	@Column(name = "CREATED_USER")
	private String createdUser;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;

}
