package com.nextscience.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDetailsSaveRequest {

	private UpdatePatientTrnFaxRxRequest updatePatient;
	private List<UpdateWoundInfoRequest> updateWound;
	private List<UpdateProductInfoRequest> updateProduct;
	private List<UpdateHcpInfoRequest> updateHcp;
	private UpdateOfficeInfoRequest updateOffice;
	private UpdateChecklistInfoRequest updateChecklist;

	private List<InsertWoundInfoRequest>insertWound;
	private List<InsertProductInfoRequest>insertProduct;
	private List<InsertHcpInfoRequest>insertHcp;
	private List<DeleteWoundInfoRequest>deleteWound;
	private List<DeleteProductInfoRequest>deleteProduct;
}
