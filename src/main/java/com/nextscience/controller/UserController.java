package com.nextscience.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.UsersConstant;
import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.UpdatePasswordRequest;
import com.nextscience.dto.request.UpdateUserRequest;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.UserDetailsResponse;
import com.nextscience.dto.response.UserResponse;
import com.nextscience.entity.User;
import com.nextscience.service.UserService;
import com.nextscience.utility.ResponseHelper;

import jakarta.validation.Valid;

/**
 * Processes an {@link UserController } controller.
 * 
 * @author Raghu
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(CommonConstants.APIV1USERS)
public class UserController {

	@Autowired
	private UserService userService;

	/** Create a User in userList */
	@PostMapping(UsersConstant.CREATEUSER)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> createUser(@Valid @RequestBody SignUpRequest request) {
		return ResponseEntity.ok(userService.createUser(request));
	}

	/** Update User in UserDetails list */
	@PutMapping(UsersConstant.UPDATEUSERID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<String> updateUser(@RequestBody UpdateUserRequest request, @PathVariable int id) {
		return ResponseEntity.ok(userService.updateUser(request, id));
	}

	/** Update Password in UserDetails List */
	@PutMapping(UsersConstant.UPDATEUSERPASSWORDID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest request, @PathVariable int id) {
		return ResponseEntity.ok(userService.updatePassword(request, id));
	}

	/** Retrieves A list of UserDetails List */
	@SuppressWarnings("unchecked")
	@GetMapping(UsersConstant.GETUSERSLIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<UserResponse>> getUserDetail() {
		List<UserResponse> userDto = userService.getUserDetail();
		return ResponseHelper.createResponse(new NSServiceResponse<UserResponse>(), userDto,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Delete a User in UserDetails List */
	@PutMapping(UsersConstant.DELETEUSERID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return ResponseEntity.ok(userService.deleteUser(id));
	}

	/** Retrieves A list of UserDetails By Email */
	@GetMapping(UsersConstant.FORTOTUSEREMAIL)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<String> getUserName(@PathVariable String email) {
		String userName = userService.getUserName(email);
		if (userName == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("Your UserName is: " + userName);
	}

	/** Retrieves A list of User By Pagination */
	@SuppressWarnings("unchecked")
	@GetMapping(UsersConstant.USERSLIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<?>> executeCustomQuery(

			@RequestParam(value = CommonConstants.PAGENO, required = false, defaultValue = "0") int pageNo,
			@RequestParam(value = CommonConstants.PAGESIZE, required = false, defaultValue = "150") int pageSize,
			@RequestParam(value = CommonConstants.SORTBY, defaultValue = CommonConstants.CREATEDDATE, required = false) String sortBy,
			@RequestParam(value = CommonConstants.ORDERBY, defaultValue = CommonConstants.DESC, required = false) String orderType) {
		PageRequest page = null;
		if (CommonConstants.DESC.equals(orderType)) {
			page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		} else {
			page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		}
		PageResponseDTO response = userService.fetchUserList(page);
		// List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), response,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A list Of ActiveUsers In UserDetails List */
	@SuppressWarnings("unchecked")
	@GetMapping(UsersConstant.ACTIVATEUSERS)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<UserResponse>> getActivateusers(
			/* @Parameter(description = "Authorization Token", required = true) */
			@RequestHeader(name = CommonConstants.AUTHORIZATION) String authorizationToken)

	{
		String token = authorizationToken.replace(CommonConstants.BEARER, "");

		List<UserResponse> ActivateusersList = userService.getActivateusers();
		/*
		 * if(ActivateusersList ==null && ActivateusersList.isEmpty()) { return
		 * NSServiceResponse.notFound().build(); }
		 */
		return ResponseHelper.createResponse(new NSServiceResponse<UserResponse>(), ActivateusersList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A List Of DeActiveUsers In UserDetails List */
	@SuppressWarnings("unchecked")
	@GetMapping(UsersConstant.DEACTIVATEUSERS)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<UserResponse>> getDeactivateUsers() {
		List<UserResponse> deactivateUsersList = userService.getDeactivateUsers();
		/*
		 * if(deactivateUsersList ==null && !deactivateUsersList.isEmpty()) { return
		 * ResponseEntity.notFound().build(); }
		 */
		return ResponseHelper.createResponse(new NSServiceResponse<UserResponse>(), deactivateUsersList,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Update User in UserDetails list */
	@PatchMapping(UsersConstant.UPDATEUSERPROFILEID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<String> updatePatchUser(@RequestBody Map<String, Object> request,
			@PathVariable int id) {
		return ResponseEntity.ok(userService.updatePatchUser(request, id));
	}

	/** Retrieves A list Of ActiveUsers In UserDetails List */
	@SuppressWarnings("unchecked")
	@GetMapping(UsersConstant.USERSLISTBYUSERID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<User>> findAllCustomByUserId(@PathVariable Integer userId)

	{
		List<User> usersList = userService.findAllCustomByUserId(userId);
		return ResponseHelper.createResponse(new NSServiceResponse<User>(), usersList, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	/** Retrieves A list Of ActiveUsers In UserDetails List */
	@SuppressWarnings("unchecked")
	@GetMapping(UsersConstant.USERSLISTBYUSERNAME)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<User>> findAllUsersByUserName(@PathVariable String userName)
	{
		List<User> usersList = userService.findAllUsersByUserName(userName);
		return ResponseHelper.createResponse(new NSServiceResponse<User>(), usersList, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	/** Retrieves A list Of ActiveUsers In UserDetails List */
	@SuppressWarnings("unchecked")
	@GetMapping(UsersConstant.USERSDETAILSBYUSERID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<UserDetailsResponse>> getUserById(@PathVariable Integer userId)

	{
		List<UserDetailsResponse> usersList = userService.getUserByUserId(userId);
		return ResponseHelper.createResponse(new NSServiceResponse<UserDetailsResponse>(), usersList, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	/** Retrieves A list Of ActiveUsers In UserDetails List */
	@SuppressWarnings("unchecked")
	@GetMapping(UsersConstant.USERSDETAILSBYUSERNAME)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<UserDetailsResponse>> getUserByUserName(@PathVariable String userName)
	{
		List<UserDetailsResponse> usersList = userService.getUserByUserName(userName);
		return ResponseHelper.createResponse(new NSServiceResponse<UserDetailsResponse>(), usersList, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}
	
	

}