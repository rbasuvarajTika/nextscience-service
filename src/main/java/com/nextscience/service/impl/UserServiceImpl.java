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
				
				/*
				 * existingUser.setUserName(request.getUserName()) existingUser
				 * .SetFirstName(request.getFirstName()) existingUser
				 * .SetMiddleName(request.getMiddleName()) existingUser
				 * .SetLastName(request.getLastName()) existingUser
				 * .SetUserMail(request.getUserMail()) existingUser
				 * .SetFullName(request.getFullName()) existingUser .SetTitle(request.getTitle())
				 * existingUser .Role(request.getRole()) existingUser
				 * .SetUserMail(request.getUserMail()) existingUser .SetPhone(request.getPhone())
				 * existingUser .SetUserMobile(request.getUserMobile()) existingUser
				 * .SetUserEmpID(request.getUserEmpID()) existingUser
				 * .SetAddress1(request.getAddress1()) existingUser
				 * .address2(request.getAddress2()) existingUser .city(request.getCity())
				 * existingUser .state(request.getState()) existingUser .zip(request.getZip())
				 * existingUser .preferredName(request.getPreferredName()) existingUser
				 * .activeInd(request.getActiveInd()) existingUser
				 * .userTerr(request.getUserTerr()) existingUser .empId(request.getEmpId())
				 * existingUser .hireDate(request.getHireDate()) existingUser
				 * .endDate(request.getEndDate()) existingUser
				 * .startDate(request.getStartDate()) existingUser
				 * .admToolsFlag(request.getAdmToolsFlag()) existingUser
				 * .attendeeFlag(request.getAttendeeFlag()) existingUser
				 * .bookingUrl(request.getBookingUrl()) existingUser
				 * .managerEmail(request.getManagerEmail()) existingUser
				 * .userTimeZone(request.getUserTimeZone()) existingUser
				 * .userNtId(request.getUserNtId()) existingUser
				 * .outlookClientId(request.getOutlookClientId()) existingUser
				 * .outlookSecretCode(request.getOutlookSecretCode()) existingUser
				 * .outlookEmailId(request.getOutlookEmailId()) existingUser
				 * .salesForce(request.getSalesForce()) //
				 * .password(passwordEncoder.encode(request.getPassword())) //
				 * .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				 * existingUser .passwordUpdatedDate(request.getPasswordUpdatedDate())
				 * existingUser .userStatusFlag(request.getUserStatusFlag()) existingUser
				 * .userType(request.getUserType()) existingUser
				 * .otherPassword(passwordEncoder.encode(request.getOtherPassword()))
				 * existingUser .userImageUrl(request.getUserImageUrl()) existingUser
				 * .createdUser(request.getCreatedUser()) existingUser
				 * .createdDate(request.getCreatedDate()) existingUser
				 * .updatedUser(request.getUpdatedUser()) existingUser
				 * .updatedDate(request.getUpdatedDate()).build();
				 */
				 
			 userRepository.save(existingUser);
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

}
