package com.nextscience.dto.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link HcpInfoResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class HcpInfoResponse {
	
	private Integer trnRxId;
	private Integer trnFaxId;
	private String faxId;
	private Integer hcpId;

    private String hcp_first_Name;
    private String hcp_middle_Name;
    
    private String hcp_last_Name;
    
    private String provider_Type;
    private String npi;
    private Integer signature_Flag;
    @JsonFormat(pattern="MM/dd/yyyy")
    private Date signature_Date;
	public HcpInfoResponse(Integer trnRxId, Integer trnFaxId, String faxId, Integer hcpId, String hcp_first_Name,
			String hcp_last_Name, String provider_Type, String npi, Integer signature_Flag, Date signature_Date) {
		super();
		this.trnRxId = trnRxId;
		this.trnFaxId = trnFaxId;
		this.faxId = faxId;
		this.hcpId = hcpId;
		this.hcp_first_Name = hcp_first_Name;
		this.hcp_last_Name = hcp_last_Name;
		this.provider_Type = provider_Type;
		this.npi = npi;
		this.signature_Flag = signature_Flag;
		this.signature_Date = signature_Date;
	}
    
    

	

}
