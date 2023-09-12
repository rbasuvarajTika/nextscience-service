package com.nextscience.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.UpdatePasswordRequest;
import com.nextscience.dto.request.UpdateUserRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.UserResponse;
import com.nextscience.entity.User;

public interface UserService {
	
	String createUser(SignUpRequest request);

	List<UserResponse> getUserDetail();
	
	List<User> findAll();

	UserDetailsService userDetailsService();

	String updateUser(UpdateUserRequest request, int id);

	String updatePassword(UpdatePasswordRequest request, int id);

	String deleteUser(int id);

	String getUserName(String email);
	
	public PageResponseDTO fetchUserList(PageRequest page);

	List<UserResponse> getActivateusers();

	List<UserResponse> getDeactivateUsers();

}