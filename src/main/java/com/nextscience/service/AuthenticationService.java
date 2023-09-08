package com.nextscience.service;

import com.nextscience.dto.JwtAuthenticationResponse;
import com.nextscience.dto.SignUpRequest;
import com.nextscience.dto.SigninRequest;

public interface AuthenticationService {
    String UserSignup(SignUpRequest request);

    JwtAuthenticationResponse adminSignin(SigninRequest request);

	String adminSignup(SignUpRequest request);
}