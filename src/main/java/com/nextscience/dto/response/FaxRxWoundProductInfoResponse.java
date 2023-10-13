package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link FaxRxWoundProductInfoResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class FaxRxWoundProductInfoResponse {
	
	  private Integer trnFaxId;

	    private Integer productId;
	    
	    private Integer quantity;
	    
	    private Integer wnd1;
	    
	    private Integer wnd2;
	    
	    private Integer wnd3;
	    
	    private Integer wnd4;

	    private String createdUser;

	   
	    private Date createdDate;

	    private String updatedUser;

	    private Date updatedDate;

		public FaxRxWoundProductInfoResponse(Integer trnFaxId, Integer productId, Integer quantity, Integer wnd1,
				Integer wnd2, Integer wnd3, Integer wnd4, String createdUser, Date createdDate, String updatedUser,
				Date updatedDate) {
			super();
			this.trnFaxId = trnFaxId;
			this.productId = productId;
			this.quantity = quantity;
			this.wnd1 = wnd1;
			this.wnd2 = wnd2;
			this.wnd3 = wnd3;
			this.wnd4 = wnd4;
			this.createdUser = createdUser;
			this.createdDate = createdDate;
			this.updatedUser = updatedUser;
			this.updatedDate = updatedDate;
		}

	    
}
