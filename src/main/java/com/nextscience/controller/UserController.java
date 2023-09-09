package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.UpdateUserRequest;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.UserResponse;
import com.nextscience.entity.User;
import com.nextscience.service.UserService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private  UserService userService;

	@PostMapping("/create/user")
    public ResponseEntity<String> createUser(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }
	
	@PutMapping("/update/user/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(request));
    }

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getUser")
	public NSServiceResponse<List<UserResponse>> getUserDetail() {
		List<UserResponse> userDto = userService.getUserDetail();
		//return ResponseEntity.ok(userDto);
		return ResponseHelper.createResponse(new NSServiceResponse<UserResponse>(), 
				userDto, "Successfully ", "Error");
	}

}