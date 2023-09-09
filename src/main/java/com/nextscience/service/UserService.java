package com.nextscience.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.UpdateUserRequest;
import com.nextscience.dto.response.UserResponse;
import com.nextscience.entity.User;

public interface UserService {
	
	String createUser(SignUpRequest request);

	List<UserResponse> getUserDetail();
	
	List<User> findAll();

	UserDetailsService userDetailsService();

	String updateUser(UpdateUserRequest request);
	
	
}