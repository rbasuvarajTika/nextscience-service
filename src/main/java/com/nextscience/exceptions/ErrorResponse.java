package com.nextscience.exceptions;

import lombok.Data;

@Data
public class ErrorResponse {

	private int errorCode;

	private String message;

	private Boolean success;
}
