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
/**
 * Service interface for managing {@link UserService}.
 * 
 * @author Raghu
 */
public interface UserService {
	
	/** Create a new user in UserInfo*/
	String createUser(SignUpRequest request);
	
  /** Retrieves a List of UserDetail.*/
	List<UserResponse> getUserDetail();
	
	 /** Retrieves all List of UsersInfo.*/
	List<User> findAll();

	UserDetailsService userDetailsService();

	/** Updates a values of UsersInfo.*/
	String updateUser(UpdateUserRequest request, int id);
  
	/** Updates Password of UsersInfo.*/
	String updatePassword(UpdatePasswordRequest request, int id);

	/** Delete a user in UsersInfo.*/
	String deleteUser(int id);

	/** Retrieves Email for a user in UsersInfo.*/
	String getUserName(String email);
	
	/** Retrieves userName for a user in UsersInfo.*/
	int getUserId(String userName);
	
	/** Fetches a paginated list of faxRx*/
	public PageResponseDTO fetchUserList(PageRequest page);

	/** Retrieves a List of Activateusers in UsersInfo.*/
	List<UserResponse> getActivateusers();
	
	/** Retrieves a List of DeActivateusers in UsersInfo.*/
	List<UserResponse> getDeactivateUsers();

}