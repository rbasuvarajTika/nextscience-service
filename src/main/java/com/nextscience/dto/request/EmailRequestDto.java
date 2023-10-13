package com.nextscience.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link EmailRequestDto } request.
 * @author Raghu
 *
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
public class EmailRequestDto {
	

	private String resetLink;
	private String email;
}
