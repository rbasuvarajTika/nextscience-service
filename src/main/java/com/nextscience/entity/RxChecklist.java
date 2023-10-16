package com.nextscience.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Processes an {@link RxChecklist } .request
 * 
 * @author Raghu
 *
 */

@Data
@Entity
@Table(name = "DIM_RX_CHECKLIST ", schema = "dbo")
public class RxChecklist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RX_CHECKLIST_ID")
	private Integer rxChecklistId;

	@Column(name = "RX_CHECKLIST_DESC", length = 25)
	private String rxChecklistDesc;

	@Column(name = "CREATED_USER", length = 255)
	private String createdUser;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_USER", length = 255)
	private String updatedUser;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
}
