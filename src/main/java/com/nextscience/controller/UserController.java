package com.nextscience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.dto.NSServiceResponse;
import com.nextscience.dto.UserDto;
import com.nextscience.entity.User;
import com.nextscience.repo.UserRepository;
import com.nextscience.service.impl.UserServiceImpl;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private final UserServiceImpl userService;

	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	
	

	@SuppressWarnings("unchecked")
	@GetMapping("/subset")
	public NSServiceResponse<List<UserDto>> getUserDto() {
		List<UserDto> userDto = userService.getUserDto();
		//return ResponseEntity.ok(userDto);
		return ResponseHelper.createResponse(new NSServiceResponse<UserDto>(), 
				userDto, "Successfully ", "Error");
	}
}