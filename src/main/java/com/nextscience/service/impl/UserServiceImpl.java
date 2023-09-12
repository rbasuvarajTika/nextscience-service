package com.nextscience.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nextscience.config.CustomPasswordEncoder;
import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.UpdatePasswordRequest;
import com.nextscience.dto.request.UpdateUserRequest;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.UserResponse;
import com.nextscience.entity.User;
import com.nextscience.enums.ErrorCodes;
import com.nextscience.exceptions.NSException;
import com.nextscience.repo.UserRepository;
import com.nextscience.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	// private PasswordEncoder passwordEncoder;

	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	@Override
	public String createUser(SignUpRequest request) {
		var user = User.builder().userName(request.getUserName()).firstName(request.getFirstName())
				.middleName(request.getMiddleName()).lastName(request.getLastName()).userMail(request.getEmail())
				.confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				.password(passwordEncoder.encode(request.getPassword()))
				.otherPassword(passwordEncoder.encode(request.getOtherPassword()))
				.passwordUpdatedDate(request.getPasswordUpdatedDate()).phone(request.getPhone())
				.address1(request.getAddress()).role(request.getRole()).userType(request.getType())
				.city(request.getCity()).state(request.getState()).zip(request.getZip())
				.userImageUrl(request.getImage()).salesForce(request.getSalesForce())
				.createdUser(request.getCreatedUser()).createdDate(request.getCreatedDate())
				.updatedUser(request.getUpdatedUser()).updatedDate(request.getUpdateDate()).build();
		userRepository.save(user);
		return "User created successfully";
	}

	@Override
	public String updateUser(UpdateUserRequest request,int id) {
	    Optional<User> existingUserOptional = userRepository.findByUserName(request.getUserName());
	    if(existingUserOptional !=null) {
			
			  User existingUser = existingUserOptional.get(); 
				
				
				  existingUser.setUserName(request.getUserName());
				  existingUser.setFirstName(request.getFirstName());
				   existingUser.setMiddleName(request.getMiddleName());
				   existingUser .setLastName(request.getLastName());
				  existingUser .setUserMail(request.getUserMail());
				  existingUser.setFullName(request.getFullName());
				   existingUser .setTitle(request.getTitle());
				  existingUser .setRole(request.getRole()); 
				  existingUser .setUserMail(request.getUserMail());
				  existingUser .setPhone(request.getPhone());
				  existingUser .setPhone(request.getUserMobile()); 
				  existingUser.setUserEmpID(request.getUserEmpID()) ;
				  existingUser  .setAddress1(request.getAddress1()); 
				  existingUser .setAddress2(request.getAddress2()) ;
				  existingUser .setCity(request.getCity());
				  existingUser .setState(request.getState()); 
				  existingUser .setZip(request.getZip());
				  existingUser .setPreferredName(request.getPreferredName()) ;
				  existingUser .setActiveInd(request.getActiveInd()) ;
				  existingUser  .setUserTerr(request.getUserTerr()) ;
				  existingUser .setEmpId(request.getEmpId());
				  existingUser .setHireDate(request.getHireDate()); 
				  existingUser  .setEndDate(request.getEndDate()); 
				  existingUser .setStartDate(request.getStartDate()); 
				  existingUser .setAdmToolsFlag(request.getAdmToolsFlag());
				  existingUser  .setAttendeeFlag(request.getAttendeeFlag()); 
				  existingUser .setBookingUrl(request.getBookingUrl()); 
				  existingUser .setManagerEmail(request.getManagerEmail()); 
				  existingUser .setUserTimeZone(request.getUserTimeZone()) ;
				  existingUser .setUserNtId(request.getUserNtId()); 
				  existingUser .setOutlookClientId(request.getOutlookClientId()); 
				  existingUser.setOutlookSecretCode(request.getOutlookSecretCode());
				  existingUser .setOutlookEmailId(request.getOutlookEmailId()) ;
				  existingUser .setSalesForce(request.getSalesForce());
				  // .(passwordEncoder.encode(request.getPassword()))
				  //.confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				  
				  existingUser .setUpdatedDate(request.getPasswordUpdatedDate());
				  existingUser .setUserStatusFlag(request.getUserStatusFlag());
				  existingUser  .setUserType(request.getUserType()) ;
				 
				  existingUser.setOtherPassword(passwordEncoder.encode(request.getOtherPassword()));
				  
				  existingUser .setUserImageUrl(request.getUserImageUrl()) ;
				  existingUser .setCreatedUser(request.getCreatedUser());
				  existingUser.setCreatedDate(request.getCreatedDate()) ;
				  existingUser.setUpdatedUser(request.getUpdatedUser()) ;
				  
				  existingUser.setUpdatedDate(request.getUpdatedDate());
				  				 
			 userRepository.save(existingUser);
	    }
		return "User updated successfully";
	}

	public List<UserResponse> getUserDetail() {
		try {
			List<User> users = userRepository.findAll(); // Fetch all users from the table
			return users.stream()
					.map(user -> new UserResponse(user.getUserId(), user.getFirstName(), user.getLastName(),
							user.getPhone(), user.getRole(), user.getUserType(), user.getUserStatusFlag(),user.getUsername()))
					.collect(Collectors.toList());
		} catch (Exception ex) {
			throw new NSException(ErrorCodes.INTERNAL_SERVER_ERROR, ex);
		}
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) {
				return userRepository.findByUserName(username)
						.orElseThrow(() -> new UsernameNotFoundException("User not found"));
			}
		};
	}

	@Override
	public String updatePassword(UpdatePasswordRequest request, int id) {
		Optional<User> existingUserOptional = userRepository.findByUserId(id);
		if (existingUserOptional != null) {
			User existingUser = existingUserOptional.get();
			existingUser.setPassword(passwordEncoder.encode(request.getNewPassword()));
			userRepository.save(existingUser);
		}
		return "Password changed successfully";

	}

	@Override
	public String deleteUser(int id) {
		Optional<User> existingUserOptional = userRepository.findByUserId(id);
		if (existingUserOptional != null) {
			User existingUser = existingUserOptional.get();
			existingUser.setUserType("Deactivated");
			userRepository.save(existingUser);
		}
		return "User deactivated successfully";
	}

	@Override
	public String getUserName(String email) {
		User existingUser = userRepository.findByUserMail(email);
		if (existingUser == null) {
			return null;
		}

		String userName = existingUser.getUsername();
		// sendUsernameByEmail(email, userName);
		return userName;
	}

	private void sendUsernameByEmail(String toEmail, String userName) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("");
		message.setText("Your UserName is: " + userName);
		javaMailSender.send(message);
	}

	@Override
	public PageResponseDTO fetchUserList(PageRequest page) {
		Page<User> pageOfFaxResponses = userRepository.findAll(page);
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfFaxResponses.getContent());
		pageResponse.setFirst(pageOfFaxResponses.isFirst());
		pageResponse.setLast(pageOfFaxResponses.isLast());
		pageResponse.setPageNumber(pageOfFaxResponses.getNumber());
		pageResponse.setRecordCount(pageOfFaxResponses.getNumberOfElements());
		pageResponse.setRecordOffset(pageOfFaxResponses.getPageable().getOffset());
		pageResponse.setRequestedCount(pageOfFaxResponses.getSize());
		pageResponse.setTotalPages(pageOfFaxResponses.getTotalPages());
		pageResponse.setTotalRecords(pageOfFaxResponses.getTotalElements());
		return pageResponse;
	}

	@Override
	public List<UserResponse> getActivateusers() {
		List<User> userList = userRepository.findAll();
		
		
		List<UserResponse> activeUserList = userList.stream()
	            .filter(user -> "Active".equals(user.getUserType())) // Filter users with userType "active"
	            .map(user -> {
	                UserResponse userResponse = new UserResponse();
	                userResponse.setUser_Id(user.getUserId());
	                userResponse.setUserName(user.getUsername());
	                userResponse.setFirst_name(user.getFirstName());
	                userResponse.setLast_name(user.getLastName());
	                userResponse.setPhone(user.getPhone());
	                userResponse.setRole(user.getRole());
	                userResponse.setType(user.getUserType());
	                //userResponse.setStatus(user.getUserStatusFlag());
	                return userResponse;
	            })
	            .collect(Collectors.toList()); 
	    return activeUserList;
	}

	@Override
	public List<UserResponse> getDeactivateUsers() {
       List<User> userList = userRepository.findAll();
		
		
		List<UserResponse> deactiveUserList = userList.stream()
	            .filter(user -> "Deactivated".equals(user.getUserType())) // Filter users with userType "active"
	            .map(user -> {
	                UserResponse userResponse = new UserResponse();
	                userResponse.setUser_Id(user.getUserId());
	                userResponse.setUserName(user.getUsername());
	                userResponse.setFirst_name(user.getFirstName());
	                userResponse.setLast_name(user.getLastName());
	                userResponse.setPhone(user.getPhone());
	                userResponse.setRole(user.getRole());
	                userResponse.setType(user.getUserType());
	                //userResponse.setStatus(user.getUserStatusFlag());
	                return userResponse;
	            })
	            .collect(Collectors.toList()); 
	    return deactiveUserList;
	}

}
