package com.nextscience.service.impl;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.nextscience.entity.User;

import com.nextscience.dto.JwtAuthenticationResponse;
import com.nextscience.dto.SignUpRequest;
import com.nextscience.dto.SigninRequest;
import com.nextscience.repo.UserRepository;
import com.nextscience.service.AuthenticationService;
import com.nextscience.service.JwtService;
import com.nextscience.entity.Role;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public String UserSignup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .userMail(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone()).address1(request.getAddress()).build();
        userRepository.save(user);
        return "User created successfully";
    }

    @Override
    public JwtAuthenticationResponse adminSignin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByUserMail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

	@Override
	public String adminSignup(SignUpRequest request) {
		 var user = User.builder()
				 .firstName(request.getFirstName())
				 .middleName(request.getMiddleName())
				 .lastName(request.getLastName())
				 .userMail(request.getEmail())
				 .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				 .password(passwordEncoder.encode(request.getPassword()))
				 .otherPassword(passwordEncoder.encode(request.getOtherPassword()))
				 .passwordUpdatedDate(request.getPasswordUpdatedDate())
				 .phone(request.getPhone())
				 .address1(request.getAddress())
				 .role(request.getRole())
				 .userType(request.getType())
				 .city(request.getCity())
				 .state(request.getState())
				 .zip(request.getZip())
				 .userImageUrl(request.getImage())
				 .salesForce(request.getSalesForce())
				 
				 .createdUser(request.getCreatedUser())
				 .createdDate(request.getCreatedDate())
				 .updatedUser(request.getUpdatedUser())
				 .updatedDate(request.getUpdateDate())
				 
				 
	                .build();
	        userRepository.save(user);
	        return "Admin user created successfully";
	}
}