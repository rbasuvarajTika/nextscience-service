package com.nextscience.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DIM_STATES", schema = "dbo")
public class StatesDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "STATE_NAME")
	private String stateName;

	@Column(name = "SHORT_NAME")
	private String shortName;

	@Column(name = "CREATED_USER")
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

}
