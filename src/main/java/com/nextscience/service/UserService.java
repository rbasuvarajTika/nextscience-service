package com.nextscience.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nextscience.dto.UserDto;

public interface UserService {
	List<UserDto> getUserDto();
	UserDetailsService userDetailsService();
}