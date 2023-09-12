package com.nextscience.service;

import com.nextscience.dto.request.EmailDto;

import jakarta.mail.MessagingException;

/**
 * @author R@aghu
 * The UserService interface
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