package com.nextscience.service;

import com.nextscience.dto.response.JwtAuthenticationResponse;
import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.SigninRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse adminSignin(SigninRequest request);

	String adminSignup(SignUpRequest request);
}