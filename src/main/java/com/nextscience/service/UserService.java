package com.nextscience.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.UpdatePasswordRequest;
import com.nextscience.dto.request.UpdateUserRequest;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.UserDetailsResponse;
import com.nextscience.dto.response.UserResponse;
import com.nextscience.entity.User;

/**
 * Service interface for managing {@link UserService}.request
 * 
 * @author Raghu
 */
public interface UserService {

	/** Create a new user in UserInfo */
	String createUser(SignUpRequest request);

	/** Retrieves a List of UserDetail. */
	List<UserResponse> getUserDetail();

	/** Retrieves all List of UsersInfo. */
	List<User> findAll();

	UserDetailsService userDetailsService();

	/** Updates a values of UsersInfo. */
	String updateUser(UpdateUserRequest request, int id);

	/** Updates Password of UsersInfo. */
	String updatePassword(UpdatePasswordRequest request, int id);

	/** Delete a user in UsersInfo. */
	String deleteUser(int id);

	/** Retrieves Email for a user in UsersInfo. */
	String getUserName(String email);

	/** Retrieves userName for a user in UsersInfo. */
	int getUserId(String userName);

	/** Fetches a paginated list of faxRx */
	public PageResponseDTO fetchUserList(PageRequest page);

	/** Retrieves a List of Activateusers in UsersInfo. */
	List<UserResponse> getActivateusers();

	/** Retrieves a List of DeActivateusers in UsersInfo. */
	List<UserResponse> getDeactivateUsers();

	/** Updates patch a values of UsersInfo. */
	String updatePatchUser(Map<String, Object> request, int id);

	/** Fetches a User list by userId of faxRx */
	public List<User> findAllCustomByUserId(Integer userId);

	public List<User> findAllUsersByUserName(String userName);

	public List<UserDetailsResponse> getUserByUserId(Integer userId);

	public List<UserDetailsResponse> getUserByUserName(String userName);

}