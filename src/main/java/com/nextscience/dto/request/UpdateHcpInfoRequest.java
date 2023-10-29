package com.nextscience.dto.request;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link UpdateHcpInfoRequest } request.
 * @author Raghu
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHcpInfoRequest {
	private Integer trnFaxId;
	private Integer trnRxId;
	private Integer profId;
	private Integer hcpId;
	private Integer signature_Flag;
	@JsonFormat(pattern="MM/dd/yyyy")
    private Date signature_Date;
    private String firstName;
    private String middleName;
	private String lastName;
	private String npi;
    private String updatedUser;
    private String status;
	 
	

}
