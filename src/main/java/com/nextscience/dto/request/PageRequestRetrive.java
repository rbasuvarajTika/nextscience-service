package com.nextscience.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestRetrive {
	
	private String faxId;
	private String splitFaxId;
	private Integer trnFaxSplitId;
	private String pages;
    private String userName;
    private String splitType;
    private String splitAttempts;
    private String splitStatus;
}
