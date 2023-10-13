package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link RxChecklistResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class RxChecklistResponse {
	
	private Integer rxChecklistId;

    private String rxChecklistDesc;

    private String createdUser;

    
    private Date createdDate;

    private String updatedUser;

    
    private Date updatedDate;


	public RxChecklistResponse(Integer rxChecklistId, String rxChecklistDesc, String createdUser, Date createdDate,
			String updatedUser, Date updatedDate) {
		super();
		this.rxChecklistId = rxChecklistId;
		this.rxChecklistDesc = rxChecklistDesc;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}
	
	

}
