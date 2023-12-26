package com.nextscience.service;

import java.util.List;

import com.nextscience.dto.request.FaxRxConfirmRequest;
import com.nextscience.dto.request.RemoveRxNotesRequest;
import com.nextscience.dto.response.ShowPrevRxHcpsResponse;

public interface ValidateNotesService {
	
	public String removeRxNotes(RemoveRxNotesRequest request);
	public List<ShowPrevRxHcpsResponse> showNotesPrevRxHcps(FaxRxConfirmRequest request);

}
