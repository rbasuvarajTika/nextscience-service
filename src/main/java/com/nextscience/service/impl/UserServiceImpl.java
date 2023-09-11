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
	
    private PasswordEncoder passwordEncoder;
    

	@Override
	public String createUser(SignUpRequest request) {
		var user = User.builder()
				 .userName(request.getUserName())
				 .firstName(request.getFirstName())
				 .middleName(request.getMiddleName())
				 .lastName(request.getLastName())
				 .userMail(request.getEmail())
				 .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				 .password(passwordEncoder.encode(request.getPassword()))
				 .otherPassword(passwordEncoder.encode(request.getOtherPassword()))
				 .passwordUpdatedDate(request.getPasswordUpdatedDate())
				 .phone(request.getPhone())
				 .address1(request.getAddress())
				 .role(request.getRole())
				 .userType(request.getType())
				 .city(request.getCity())
				 .state(request.getState())
				 .zip(request.getZip())
				 .userImageUrl(request.getImage())
				 .salesForce(request.getSalesForce())
				 .createdUser(request.getCreatedUser())
				 .createdDate(request.getCreatedDate())
				 .updatedUser(request.getUpdatedUser())
				 .updatedDate(request.getUpdateDate()).build();
		 userRepository.save(user);
	        return "User created successfully";
	    }

	@Override
	public String updateUser(UpdateUserRequest request,int id) {
	    Optional<User> existingUser = userRepository.findByUserName(request.getUserName());
	    if(existingUser !=null) {
	    	User user= User.builder()
					 .userName(request.getUserName())
					 .firstName(request.getFirstName())
					 .middleName(request.getMiddleName())
					 .lastName(request.getLastName())
					 .userMail(request.getUserMail())
					 .fullName(request.getFullName())
					 .title(request.getTitle())
					 .role(request.getRole())
					 .userMail(request.getUserMail())
					 .phone(request.getPhone())
					 .userMobile(request.getUserMobile())
					 .UserEmpID(request.getUserEmpID())
					 .address1(request.getAddress1())
					 .address2(request.getAddress2())
					 .city(request.getCity())
					 .state(request.getState())
					 .zip(request.getZip())
					 .preferredName(request.getPreferredName())
					 .activeInd(request.getActiveInd())
					 .userTerr(request.getUserTerr())
					 .empId(request.getEmpId())
					 .hireDate(request.getHireDate())
					 .endDate(request.getEndDate())
					 .startDate(request.getStartDate())
					 .admToolsFlag(request.getAdmToolsFlag())
					 .attendeeFlag(request.getAttendeeFlag())
					 .bookingUrl(request.getBookingUrl())
					 .managerEmail(request.getManagerEmail())
					 .userTimeZone(request.getUserTimeZone())
					 .userNtId(request.getUserNtId())
					 .outlookClientId(request.getOutlookClientId())
					 .outlookSecretCode(request.getOutlookSecretCode())
					 .outlookEmailId(request.getOutlookEmailId())
					 .salesForce(request.getSalesForce())
					// .password(passwordEncoder.encode(request.getPassword()))
					// .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
					 .passwordUpdatedDate(request.getPasswordUpdatedDate())
					 .userStatusFlag(request.getUserStatusFlag())
					 .userType(request.getUserType())
					 .otherPassword(passwordEncoder.encode(request.getOtherPassword()))
					 .userImageUrl(request.getUserImageUrl())
					 .createdUser(request.getCreatedUser())
					 .createdDate(request.getCreatedDate())
					 .updatedUser(request.getUpdatedUser())
					 .updatedDate(request.getUpdatedDate()).build();
	    	user.setUserId(id);
			 userRepository.save(user);
	    }
		return "User updated successfully";
	}
	
	
public List<UserResponse> getUserDetail() {
		try {
			List<User> users = userRepository.findAll(); // Fetch all users from the table
			return users.stream()
					.map(user -> new UserResponse(user.getUserId(), user.getFirstName(), user.getLastName(),
							user.getPhone(), user.getRole(), user.getUserType(), user.getUserStatusFlag()))
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
	    Optional<User> existingUser = userRepository.findByUserId(id);
	    if(existingUser !=null) {
	    	User user= User.builder()
		    .password(passwordEncoder.encode(request.getNewPassword())).build();
	    	user.setUserId(id);
			 userRepository.save(user);
	    }
		return "Password changed successfully";
	    
	}

	@Override
	public String deleteUser(int id) {
	    Optional<User> existingUser = userRepository.findByUserId(id);
	    if(existingUser !=null) {
	    	User user= User.builder()
		    .userType("Deactivated").build();
	    	user.setUserId(id);
			userRepository.save(user);
	    }
		return "User deactivated successfully";	}

	@Override
	public String getUserName(String email) {
	    User existingUser = userRepository.findByUserMail(email);
	    if(existingUser == null) {
	    	return null;
	    }
	    
	    String userName = existingUser.getUsername();
	    sendUsernameByEmail(email, userName);
		return userName;
	}

	private void sendUsernameByEmail(String toEmail, String userName) {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(toEmail);
      message.setSubject("");
      message.setText("Your UserName is: "+ userName);
      javaMailSender.send(message);
	}

	@Override
	public PageResponseDTO fetchUserList(PageRequest page) {
		Page<User> listDetails = userRepository.findAll(page);
		List<User> listGetDetails = listDetails.getContent();
		Page<User> pageOfFaxResponses = new PageImpl<User>(listGetDetails, page, listDetails.getTotalElements());

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

	 
}
