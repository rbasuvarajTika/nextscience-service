package com.nextscience.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nextscience.dto.UserDto;
import com.nextscience.entity.User;
import com.nextscience.enums.ErrorCodes;
import com.nextscience.exceptions.NSException;
import com.nextscience.repo.UserRepository;
import com.nextscience.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	public List<UserDto> getUserDto() {
		try {
			List<User> users = userRepository.findAll(); // Fetch all users from the table
			return users.stream()
					.map(user -> new UserDto(user.getUserID(), user.getFirstName(), user.getLastName(),
							user.getPhone(), user.getRole(), user.getUserType(), user.getUserStatusFlag()))
					.collect(Collectors.toList());
		} catch (Exception ex) {
			throw new NSException(ErrorCodes.INTERNAL_SERVER_ERROR, ex);
		}
	}
	
	 @Override
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsService() {
	            @Override
	            public UserDetails loadUserByUsername(String username) {
	                return userRepository.findByUserMail(username)
	                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	            }
	        };
	    }
}
