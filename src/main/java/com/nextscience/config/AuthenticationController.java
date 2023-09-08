package com.nextscience.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.JwtAuthenticationResponse;
import com.nextscience.dto.SignUpRequest;
import com.nextscience.dto.SigninRequest;
import com.nextscience.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup/user")
    public ResponseEntity<String> userSignup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.UserSignup(request));
    }
    
    @PostMapping("/signup/admin")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.adminSignup(request));
    }

    @PostMapping("/signin/admin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.adminSignin(request));
    }
}
