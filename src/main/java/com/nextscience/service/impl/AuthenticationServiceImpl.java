package com.nextscience.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.config.CustomPasswordEncoder;
import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.SigninRequest;
import com.nextscience.dto.response.JwtAuthenticationResponse;
import com.nextscience.entity.User;
import com.nextscience.repo.UserRepository;
import com.nextscience.service.AuthenticationService;
import com.nextscience.service.JwtService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextscience.dto.request.UpdateOfficeInfoRequest;
import com.nextscience.dto.response.AccountDetailsResponse;
import com.nextscience.dto.response.HcpInfoResponse;
import com.nextscience.dto.response.OfficeAccResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.AccountDetails;
import com.nextscience.entity.FaxRxPayer;
import com.nextscience.repo.AccountDetailsRepository;
import com.nextscience.service.AccountDetailsService;
import com.nextscience.service.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

/**
 * Service Class for managing {@link AuthenticationServiceImpl}.request
 * 
 * @author Raghu
 */

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
   // private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    @Autowired
    private final CustomPasswordEncoder passwordEncoder;

   

    @Override
    public JwtAuthenticationResponse adminSignin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        var user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new IllegalArgumentException(CommonConstants.INVALIDEMAILORPASSWORD));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).role(user.getRole()).userId(user.getUserId()).build();
    }

	@Override
	public String adminSignup(SignUpRequest request) {
		 var user = User.builder()
				 .userName(request.getUserName())
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
				 .updatedDate(request.getUpdateDate()).build();
	        userRepository.save(user);
	        return CommonConstants.ADMINUSERCREATEDSUCCESSFULLY;
	}
}