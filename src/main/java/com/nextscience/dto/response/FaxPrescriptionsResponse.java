package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxPrescriptionsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxPrescriptionsResponse {
	
	 private Integer trnRxId;
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
	    private Integer netsuiteRxId;
	    private String createdUser;
	    private Date createdDate;
	    private String updatedUser;
	    private Date updatedDate;

		public FaxPrescriptionsResponse(Integer trnRxId, Integer trnFaxId, String processStatus, String rxStatus,
				Integer patientId, Integer accountId, Integer profId, String email, String repName, String territoryId,
				Integer payerId, String payerType, Integer netsuiteRxId, String createdUser, Date createdDate,
				String updatedUser, Date updatedDate) {
			super();
			this.trnRxId = trnRxId;
			this.trnFaxId = trnFaxId;
			this.processStatus = processStatus;
			this.rxStatus = rxStatus;
			this.patientId = patientId;
			this.accountId = accountId;
			this.profId = profId;
			this.email = email;
			this.repName = repName;
			this.territoryId = territoryId;
			this.payerId = payerId;
			this.payerType = payerType;
			this.netsuiteRxId = netsuiteRxId;
			this.createdUser = createdUser;
			this.createdDate = createdDate;
			this.updatedUser = updatedUser;
			this.updatedDate = updatedDate;
		}
	    
	    

}
