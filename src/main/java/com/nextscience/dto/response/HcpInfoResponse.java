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

    private String firstName;
    private String middleName;
    
    private String lastName;
    
    private String provider_Type;
    private String npi;
    private Integer signature_Flag;
    @JsonFormat(pattern="MM/dd/yyyy")
    private Date signature_Date;
    private Integer profId;
    private String status="update";

}
