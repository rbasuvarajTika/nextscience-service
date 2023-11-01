package com.nextscience.service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.UrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nextscience.dto.request.EmailDto;
import com.nextscience.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * @author Raghu The {@code EmailServiceImpl} implements {@code EmailService}
 *         <br>
 *         {@code @Service} is a stereotypical annotation used for Service Layer
 * 
 */

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	/**
	 * Injecting the JavaMailSender Dependency
	 */

	private JavaMailSender mailSender;

	/**
	 * <p>
	 * The entire JavaMail {@link javax.mail.Session} management is abstracted by
	 * the JavaMailSender. Client code should not deal with a Session in any way,
	 * rather leave the entire JavaMail configuration and resource handling to the
	 * JavaMailSender implementation. This also increases testability.
	 */

	@Autowired
	public EmailServiceImpl(JavaMailSender javamailSender) {
		this.mailSender = javamailSender;
	}

	public void sendMail(EmailDto message, boolean isHtml) throws MessagingException {

		MimeMessage emailMessage = mailSender.createMimeMessage();
		MimeMessageHelper mailBuilder = new MimeMessageHelper(emailMessage, true);

		mailBuilder.setTo(message.getMailTo());
		mailBuilder.setFrom(message.getMailFrom());
		mailBuilder.setText(message.getMailContent(), isHtml);
		mailBuilder.setSubject(message.getMailSubject());

		mailSender.send(emailMessage);

	}

	public void sendAlertMail(EmailDto message, boolean isHtml, UrlResource urlResource) throws MessagingException {

		MimeMessage emailMessage = mailSender.createMimeMessage();
		MimeMessageHelper mailBuilder = new MimeMessageHelper(emailMessage, true);

		mailBuilder.setTo(message.getMailTo());
		mailBuilder.setFrom(message.getMailFrom());
		mailBuilder.setText(message.getMailContent(), isHtml);
		mailBuilder.setSubject(message.getMailSubject());
		mailBuilder.addAttachment(urlResource.getFilename(), urlResource);
		mailSender.send(emailMessage);

	}
}