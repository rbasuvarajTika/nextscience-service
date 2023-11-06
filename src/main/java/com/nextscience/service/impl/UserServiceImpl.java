package com.nextscience.service.impl;

import java.lang.reflect.Field;
import java.security.cert.CollectionCertStoreParameters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nextscience.component.EmailBuilder;
import com.nextscience.config.CustomPasswordEncoder;
import com.nextscience.dto.request.EmailDto;
import com.nextscience.dto.request.SignUpRequest;
import com.nextscience.dto.request.UpdatePasswordRequest;
import com.nextscience.dto.request.UpdateUserRequest;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.dto.response.UserDetailsResponse;
import com.nextscience.dto.response.UserResponse;
import com.nextscience.entity.User;
import com.nextscience.enums.ErrorCodes;
import com.nextscience.exceptions.NSException;
import com.nextscience.repo.UserRepository;
import com.nextscience.service.EmailService;
import com.nextscience.service.UserService;
import com.nextscience.utility.CommonUtilService;

import io.jsonwebtoken.lang.Collections;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;

/**
 * Service Class for managing {@link UserServiceImpl}.request
 * 
 * @author Raghu
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	// private PasswordEncoder passwordEncoder;

	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;

	@Value("${mail.from.email.id}")
	private String fromEmail;

	@Value("${mail.subject.resetpassword.template}")
	private String resetTemplate;

	@Value("${mail.subject.email}")
	private String subject;

	@Value("${mail.subject.resetpassword.link}")
	private String resetParams;

	@Value("${mail.subject.email.resetpassword}")
	private String resetPassword;

	@Value("${mail.subject.createUser.template}")
	private String createUserTemplate;

	@Value("${mail.subject.createUser.firstName}")
	private String firstName;

	@Value("${mail.subject.createUser.userName}")
	private String userName;

	@Value("${mail.subject.createUser.userCreated}")
	private String userCreated;

	@Override
	public String createUser(SignUpRequest request) {

		if (userRepository.existsByUserName(request.getUserName())) {
			throw new NSException(ErrorCodes.OK, "User Name already exist by this name");
		}
		if (userRepository.existsByUserMail(request.getEmail())) {
			throw new NSException(ErrorCodes.OK, "Mail Id already exist by this email");
		}

		var user = User.builder().userName(request.getUserName()).firstName(request.getFirstName())
				.middleName(request.getMiddleName()).lastName(request.getLastName()).userMail(request.getEmail())
				// .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				.password(passwordEncoder.encode(request.getPassword()))
				// .otherPassword(passwordEncoder.encode(request.getOtherPassword()))
				.passwordUpdatedDate(request.getPasswordUpdatedDate()).phone(request.getPhone())
				.address1(request.getAddress()).role(request.getRole()).userType(request.getType())
				.city(request.getCity()).state(request.getState()).zip(request.getZip())
				.userImageUrl(request.getImage()).salesForce(request.getSalesForce())
				.userStatusFlag(request.getUserStatusFlag()).createdUser(request.getCreatedUser())
				.createdDate(request.getCreatedDate()).updatedUser(request.getUpdatedUser())
				.updatedDate(request.getUpdateDate()).build();
		userRepository.save(user);
		log.info("Saved user");
		EmailDto mail = new EmailBuilder().From(fromEmail).To(request.getEmail()).Template(createUserTemplate)
				.AddContext(subject, "New User Created").AddContext(firstName, request.getFirstName())
				.AddContext(userName, request.getUserName())
				.AddContext(resetParams, "http://localhost:3000/resetpassword" + "/" + user.getUserId())
				.Subject(userCreated).createMail();
		try {
			log.info("Email Sending");
			emailService.sendMail(mail, true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Email Successfully Send");
		return "User created successfully";
	}

	@Override
	public String updateUser(UpdateUserRequest request, int id) {

		// Optional<User> existingUserOptional =
		// userRepository.findByUserName(request.getUserName());
		Optional<User> existingUserOptional = userRepository.findByUserId(id);
		if (existingUserOptional != null) {

			User existingUser = existingUserOptional.get();
			existingUser.setUserName(request.getUserName());
			existingUser.setFirstName(request.getFirstName());
			existingUser.setMiddleName(request.getMiddleName());
			existingUser.setLastName(request.getLastName());
			existingUser.setUserMail(request.getUserName());
			existingUser.setFullName(request.getFullName());
			existingUser.setTitle(request.getTitle());
			existingUser.setRole(request.getRole());
			existingUser.setUserMail(request.getUserMail());
			existingUser.setPhone(request.getPhone());
			existingUser.setUserMobile(request.getUserMobile());
			existingUser.setUserEmpID(request.getUserEmpID());
			existingUser.setAddress1(request.getAddress1());
			existingUser.setAddress2(request.getAddress2());
			existingUser.setCity(request.getCity());
			existingUser.setState(request.getState());
			existingUser.setZip(request.getZip());
			existingUser.setPreferredName(request.getPreferredName());
			existingUser.setActiveInd(request.getActiveInd());
			existingUser.setUserTerr(request.getUserTerr());
			existingUser.setEmpId(request.getEmpId());
			existingUser.setHireDate(request.getHireDate());
			existingUser.setEndDate(request.getEndDate());
			existingUser.setStartDate(request.getStartDate());
			existingUser.setAdmToolsFlag(request.getAdmToolsFlag());
			existingUser.setAttendeeFlag(request.getAttendeeFlag());
			existingUser.setBookingUrl(request.getBookingUrl());
			existingUser.setManagerEmail(request.getManagerEmail());
			existingUser.setUserTimeZone(request.getUserTimeZone());
			existingUser.setUserNtId(request.getUserNtId());
			existingUser.setOutlookClientId(request.getOutlookClientId());
			existingUser.setOutlookSecretCode(request.getOutlookSecretCode());
			existingUser.setOutlookEmailId(request.getOutlookEmailId());
			existingUser.setSalesForce(request.getSalesForce());

			existingUser.setUpdatedDate(request.getPasswordUpdatedDate());
			existingUser.setUserStatusFlag(request.getUserStatusFlag());
			existingUser.setUserType(request.getUserType());

			existingUser.setUserImageUrl(request.getUserImageUrl());
			existingUser.setCreatedUser(request.getCreatedUser());
			existingUser.setCreatedDate(request.getCreatedDate());
			existingUser.setUpdatedUser(request.getUpdatedUser());

			existingUser.setUpdatedDate(request.getUpdatedDate());

			if (CommonUtilService.maskNullValue(request.getPassword()) != "") {
				existingUser.setPassword(passwordEncoder.encode(request.getPassword()));
				existingUser.setConfirmPassword(passwordEncoder.encode(request.getConfirmPassword()));
			}

			userRepository.save(existingUser);
		}
		return "User updated successfully";
	}

	public List<UserResponse> getUserDetail() {
		try {
			List<User> users = userRepository.findAll(); // Fetch all users from the table
			return users.stream()
					.map(user -> new UserResponse(user.getUserId(), user.getFirstName(), user.getLastName(),
							user.getPhone(), user.getRole(), user.getUserType(), user.getUserStatusFlag(),
							user.getUsername()))
					.collect(Collectors.toList());
		} catch (Exception ex) {
			throw new NSException(ErrorCodes.OK, ex);
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

	@Override
	public int getUserId(String userName) {
		User existingUser = userRepository.findByUserName(userName).get();
		if (existingUser == null) {
			return 0;
		}

		int userId = existingUser.getUserId();
		// sendUsernameByEmail(email, userName);
		return userId;
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
		Page<User> pageOfFaxResponses = userRepository.findAllCustom(page);
		PageResponseDTO pageResponse = new PageResponseDTO();
		pageResponse.setData(pageOfFaxResponses.getContent().stream().filter(e -> e.getUsername() != null)
				.collect(Collectors.toList()));
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

		List<UserResponse> activeUserList = userList.stream().filter(user -> "Active".equals(user.getUserStatusFlag())) // Filter
																														// users
																														// with
																														// userType
																														// "active"
				.map(user -> {
					UserResponse userResponse = new UserResponse();
					userResponse.setUser_Id(user.getUserId());
					userResponse.setUserName(user.getUsername());
					userResponse.setFirst_name(user.getFirstName());
					userResponse.setLast_name(user.getLastName());
					userResponse.setPhone(user.getPhone());
					userResponse.setRole(user.getRole());
					userResponse.setType(user.getUserType());
					// userResponse.setStatus(user.getUserStatusFlag());
					return userResponse;
				}).collect(Collectors.toList());
		return activeUserList;
	}

	@Override
	public List<UserResponse> getDeactivateUsers() {
		List<User> userList = userRepository.findAll();

		List<UserResponse> deactiveUserList = userList.stream()
				.filter(user -> "Deactivated".equals(user.getUserStatusFlag())) // Filter users with userType "active"
				.map(user -> {
					UserResponse userResponse = new UserResponse();
					userResponse.setUser_Id(user.getUserId());
					userResponse.setUserName(user.getUsername());
					userResponse.setFirst_name(user.getFirstName());
					userResponse.setLast_name(user.getLastName());
					userResponse.setPhone(user.getPhone());
					userResponse.setRole(user.getRole());
					userResponse.setType(user.getUserType());
					// userResponse.setStatus(user.getUserStatusFlag());
					return userResponse;
				}).collect(Collectors.toList());
		return deactiveUserList;
	}

	@Override
	public String updatePatchUser(Map<String, Object> request, int id) {

		Optional<User> existingUserOptional = userRepository.findByUserId(id);
		if (existingUserOptional != null) {

			User existingUser = existingUserOptional.get();
			if (request.containsKey("password")) {
				String encodePassword = passwordEncoder.encode(request.get("password").toString());
				request.replace("password", encodePassword);
			}
			if (request.containsKey("confirmPassword")) {
				String encodePassword = passwordEncoder.encode(request.get("confirmPassword").toString());
				request.replace("confirmPassword", encodePassword);
			}
			request.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(User.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingUser, value);
			});

			userRepository.save(existingUser);
		}
		return "User updated successfully";
	}

	@Override
	public List<User> findAllCustomByUserId(Integer userId) {
		List<User> userList = userRepository.findAllCustomByUserId(userId);
		if (userList == null) {
			throw new NSException(ErrorCodes.OK, "User Id Not Found");
		}
		return userList;
	}

	@Override
	public List<User> findAllUsersByUserName(String userName) {
		List<User> userList = userRepository.findAllUsersByUserName(userName);
		if (userList == null) {
			throw new NSException(ErrorCodes.OK, "User Name Not Found");
		}
		return userList;

	}

	@Override
	public List<UserDetailsResponse> getUserByUserId(Integer userId) {
		List<User> userList = userRepository.findAllCustomByUserId(userId);
		List<UserDetailsResponse> userDetailsList = userList.stream()
				.map(user -> {
					UserDetailsResponse userResponse = new UserDetailsResponse();
					userResponse.setUserId(user.getUserId());
					userResponse.setUserName(user.getUsername());
					userResponse.setFirstName(user.getFirstName());
					userResponse.setMiddleName(user.getMiddleName());
					userResponse.setLastName(user.getLastName());
					userResponse.setFullName(user.getFullName());
					userResponse.setUserStatusFlag(user.getUserStatusFlag());
					userResponse.setTitle(user.getTitle());
					userResponse.setRole(user.getRole());
					userResponse.setUserMail(user.getUserMail());
					userResponse.setPhone(user.getPhone());
					userResponse.setUserMobile(user.getUserMobile());
					userResponse.setUserEmpID(user.getUserEmpID());
					userResponse.setAddress1(user.getAddress1());
					userResponse.setAddress2(user.getAddress2());
					userResponse.setCity(user.getCity());
					userResponse.setState(user.getState());
					userResponse.setZip(user.getZip());
					userResponse.setPreferredName(user.getPreferredName());
					userResponse.setActiveInd(user.getActiveInd());
					userResponse.setUserTerr(user.getUserTerr());
					userResponse.setEmpId(user.getEmpId());
					userResponse.setHireDate(user.getHireDate());
					userResponse.setEndDate(user.getEndDate());
					userResponse.setStartDate(user.getStartDate());
					userResponse.setAdmToolsFlag(user.getAdmToolsFlag());
					userResponse.setAttendeeFlag(user.getAttendeeFlag());
					userResponse.setBookingUrl(user.getBookingUrl());
					userResponse.setManagerEmail(user.getManagerEmail());
					userResponse.setUserTimeZone(user.getUserTimeZone());
					userResponse.setUserNtId(user.getUserNtId());
					userResponse.setOutlookClientId(user.getOutlookClientId());
					userResponse.setOutlookSecretCode(user.getOutlookSecretCode());
					userResponse.setOutlookEmailId(user.getOutlookEmailId());
					userResponse.setSalesForce(user.getSalesForce());

					userResponse.setUpdatedDate(user.getPasswordUpdatedDate());
					userResponse.setUserStatusFlag(user.getUserStatusFlag());
					userResponse.setUserType(user.getUserType());

					userResponse.setUserImageUrl(user.getUserImageUrl());
					userResponse.setCreatedUser(user.getCreatedUser());
					userResponse.setCreatedDate(user.getCreatedDate());
					userResponse.setUpdatedUser(user.getUpdatedUser());

					userResponse.setUpdatedDate(user.getUpdatedDate());
					userResponse.setPassword(user.getPassword());
					userResponse.setConfirmPassword(user.getConfirmPassword());
					return userResponse;
				}).collect(Collectors.toList());
		
		if (userDetailsList == null) {
			throw new NSException(ErrorCodes.OK, "User Id Not Found");
		}
		return userDetailsList;
	}

	@Override
	public List<UserDetailsResponse> getUserByUserName(String userName) {
		List<User> userList = userRepository.findAllUsersByUserName(userName);
		List<UserDetailsResponse> userDetailsList = userList.stream()
				.map(user -> {
					UserDetailsResponse userResponse = new UserDetailsResponse();
					userResponse.setUserId(user.getUserId());
					userResponse.setUserName(user.getUsername());
					userResponse.setFirstName(user.getFirstName());
					userResponse.setMiddleName(user.getMiddleName());
					userResponse.setLastName(user.getLastName());
					userResponse.setFullName(user.getFullName());
					userResponse.setUserStatusFlag(user.getUserStatusFlag());
					userResponse.setTitle(user.getTitle());
					userResponse.setRole(user.getRole());
					userResponse.setUserMail(user.getUserMail());
					userResponse.setPhone(user.getPhone());
					userResponse.setUserMobile(user.getUserMobile());
					userResponse.setUserEmpID(user.getUserEmpID());
					userResponse.setAddress1(user.getAddress1());
					userResponse.setAddress2(user.getAddress2());
					userResponse.setCity(user.getCity());
					userResponse.setState(user.getState());
					userResponse.setZip(user.getZip());
					userResponse.setPreferredName(user.getPreferredName());
					userResponse.setActiveInd(user.getActiveInd());
					userResponse.setUserTerr(user.getUserTerr());
					userResponse.setEmpId(user.getEmpId());
					userResponse.setHireDate(user.getHireDate());
					userResponse.setEndDate(user.getEndDate());
					userResponse.setStartDate(user.getStartDate());
					userResponse.setAdmToolsFlag(user.getAdmToolsFlag());
					userResponse.setAttendeeFlag(user.getAttendeeFlag());
					userResponse.setBookingUrl(user.getBookingUrl());
					userResponse.setManagerEmail(user.getManagerEmail());
					userResponse.setUserTimeZone(user.getUserTimeZone());
					userResponse.setUserNtId(user.getUserNtId());
					userResponse.setOutlookClientId(user.getOutlookClientId());
					userResponse.setOutlookSecretCode(user.getOutlookSecretCode());
					userResponse.setOutlookEmailId(user.getOutlookEmailId());
					userResponse.setSalesForce(user.getSalesForce());

					userResponse.setUpdatedDate(user.getPasswordUpdatedDate());
					userResponse.setUserStatusFlag(user.getUserStatusFlag());
					userResponse.setUserType(user.getUserType());

					userResponse.setUserImageUrl(user.getUserImageUrl());
					userResponse.setCreatedUser(user.getCreatedUser());
					userResponse.setCreatedDate(user.getCreatedDate());
					userResponse.setUpdatedUser(user.getUpdatedUser());

					userResponse.setUpdatedDate(user.getUpdatedDate());
					userResponse.setPassword(user.getPassword());
					userResponse.setConfirmPassword(user.getConfirmPassword());
					return userResponse;
				}).collect(Collectors.toList());
		
		if (userDetailsList == null) {
			throw new NSException(ErrorCodes.OK, "User Id Not Found");
		}
		return userDetailsList;
	}

}
