package com.nextscience.service;

import com.nextscience.dto.response.JwtAuthenticationResponse;
import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.SigninRequest;

/**
 * Service interface for managing {@link AuthenticationService}.request
 * 
 * @author Raghu
 */

public interface AuthenticationService {

	/** Perform authentication for admin users. */
	JwtAuthenticationResponse adminSignin(SigninRequest request);

	/** Perform signup for admin users. */
	String adminSignup(SignUpRequest request);
}