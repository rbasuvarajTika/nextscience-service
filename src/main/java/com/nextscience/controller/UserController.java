package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.UpdatePasswordRequest;
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
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserRequest request, @PathVariable int id) {
        return ResponseEntity.ok(userService.updateUser(request,id));
    }

	
	@PutMapping("/update/user/password/{id}")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest request, @PathVariable int id) {
        return ResponseEntity.ok(userService.updatePassword(request,id));
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getUser")
	public NSServiceResponse<List<UserResponse>> getUserDetail() {
		List<UserResponse> userDto = userService.getUserDetail();
		//return ResponseEntity.ok(userDto);
		return ResponseHelper.createResponse(new NSServiceResponse<UserResponse>(), 
				userDto, "Successfully ", "Error");
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@PutMapping("/delete/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
	
	@GetMapping("/forgot/user/{id}")
    public ResponseEntity<String> getUserName(@RequestParam String email) {
		String userName = userService.getUserName(email);
		if(userName ==null) {
			return ResponseEntity.notFound().build();
		}
        return ResponseEntity.ok("Your UserName is: "+ userName);
    }
	
	
	

}