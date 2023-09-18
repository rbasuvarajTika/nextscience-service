package com.nextscience.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * Processes an {@link EmailController} request.
 * @author R@aghu
 *
 */


@RestController
@RequestMapping("/api/v1/notification/emails")
public class EmailController {
	
	
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
	
	/**
	 * Processes an {@link resetpassword} request.
	 * @RequestBody params
	 * @return send message success or failure
	 *
	 */
	
	@Autowired
	private  UserService userService;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/forgotpassword")
	public NSServiceResponse<EmailResponseDto> resetpassword( @RequestBody EmailRequestDto request){
		try {
			EmailResponseDto response = new EmailResponseDto();
			int userid = userService.getUserId(request.getEmail());
			EmailDto mail = new EmailBuilder()
					.From(fromEmail)
					.To(request.getEmail())
					.Template(resetTemplate)
					.AddContext(subject, resetPassword)
					.AddContext(resetParams,request.getResetLink()+"/"+userid)
					.Subject(resetPassword).createMail();
			emailService.sendMail(mail, true);
			response.setMessage("Email Sent Successfully");
			return ResponseHelper.createResponse(new NSServiceResponse<EmailResponseDto>(), response,
					"Email Sent Successfully", "Email Send Failed");
		} catch (MessagingException e) {
			throw new NSException(ErrorCodes.INTERNAL_SERVER_ERROR, "Email Sent Failed");
		}
	}

}
