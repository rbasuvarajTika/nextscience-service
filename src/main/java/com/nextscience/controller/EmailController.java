package com.nextscience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.EmailConstant;
import com.nextscience.component.EmailBuilder;
import com.nextscience.dto.request.EmailDto;
import com.nextscience.dto.request.EmailRequestDto;
import com.nextscience.dto.response.EmailResponseDto;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.enums.ErrorCodes;
import com.nextscience.exceptions.NSException;
import com.nextscience.service.EmailService;
import com.nextscience.service.UserService;
import com.nextscience.utility.ResponseHelper;

import jakarta.mail.MessagingException;

/**
 * Processes an {@link EmailController} controller.
 * 
 * @author Raghu
 *
 */

@RestController
@RequestMapping(CommonConstants.APIV1NOTIFICATIONEMAILS)
public class EmailController {

	@Autowired
	private EmailService emailService;

	@Value(CommonConstants.MAILFROMEMAILID)
	private String fromEmail;

	@Value(CommonConstants.MAILSUBJECTRESETPASSWORDTEMPLATE)
	private String resetTemplate;

	@Value(CommonConstants.MAILSUBJECTEMAIL)
	private String subject;

	@Value(CommonConstants.MAILSUBJECTRESETPASSWORDLINK)
	private String resetParams;

	@Value(CommonConstants.MAILSUBJECTEMAILRESETPASSWORD)
	private String resetPassword;

	@Value(CommonConstants.MAILSUBJECTCREATEUSERTEMPLATE)
	private String createUserTemplate;

	@Value(CommonConstants.MAILSUBJECTCREATEUSERFIRSTNAME)
	private String firstName;

	@Value(CommonConstants.MAILSUBJECTCREATEUSERUSERNAME)
	private String userName;

	@Value(CommonConstants.MAILSUBJECTCREATEUSERUSERCREATED)
	private String userCreated;

	/**
	 * Processes an {@link resetpassword} request.
	 * 
	 * @RequestBody params
	 * @return send message success or failure
	 *
	 */

	@Autowired
	private UserService userService;

	/** For ForgotPassword for a User. */
	@SuppressWarnings("unchecked")
	@PostMapping(EmailConstant.FORGOTPASSWORD)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<EmailResponseDto> resetpassword(@RequestBody EmailRequestDto request) {
		try {
			EmailResponseDto response = new EmailResponseDto();
			int userid = userService.getUserId(request.getEmail());
			EmailDto mail = new EmailBuilder().From(fromEmail).To(request.getEmail()).Template(resetTemplate)
					.AddContext(subject, resetPassword).AddContext(resetParams, request.getResetLink() + "/" + userid)
					.Subject(resetPassword).createMail();
			emailService.sendMail(mail, true);
			response.setMessage(CommonConstants.EMAILSENTSUCCESSFULLY);
			return ResponseHelper.createResponse(new NSServiceResponse<EmailResponseDto>(), response,
					CommonConstants.EMAILSENTSUCCESSFULLY, CommonConstants.EMAILSENTFAILED);
		} catch (MessagingException e) {
			throw new NSException(ErrorCodes.INTERNAL_SERVER_ERROR, CommonConstants.EMAILSENTFAILED);
		}
	}

}
