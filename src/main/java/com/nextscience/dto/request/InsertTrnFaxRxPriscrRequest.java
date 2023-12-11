package com.nextscience.dto.request;

import lombok.Data;

@Data
public class InsertTrnFaxRxPriscrRequest {

	private Integer trnFaxId;

	private String processStatus;

	private String rxStatus;

	private Integer patientId;

	private Integer accountId;

	private Integer profId;

	private String email;

	private String repName;

	private String territoryId;

	private Integer payerId;

	private String payerType;

	private String netsuiteRxId;

	private String createdUser;

	private String updatedUser;

}
