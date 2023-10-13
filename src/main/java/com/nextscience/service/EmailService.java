package com.nextscience.service;

import com.nextscience.dto.request.EmailDto;
import jakarta.mail.MessagingException;

/**
 * Service interface for managing {@link EmailService}.
 * 
 * @author Raghu
 */

public interface EmailService {

	/**
	 * sendMail details
	 * 
	 * @param EmailDto,isHtml
	 * @return
	 */
	public void sendMail(EmailDto message, boolean isHtml) throws MessagingException;
}