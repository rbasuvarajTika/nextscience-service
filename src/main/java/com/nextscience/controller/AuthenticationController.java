package com.nextscience.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.SigninRequest;
import com.nextscience.dto.response.JwtAuthenticationResponse;
import com.nextscience.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

/**
 * Processes an {@link AuthenticationController } .controller
 * @author Raghu
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1AUTH)
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    
    /**Create a Newuser in userinfo.*/
    @PostMapping("/signup")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.adminSignup(request));
    }
    /** Login a User.*/
    @PostMapping("/signin")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.adminSignin(request));
    }
}
