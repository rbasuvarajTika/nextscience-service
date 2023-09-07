package com.nextscience.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "DIM_USER", schema = "dbo")
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int user_ID;
	 
	 @Column(name = "USER_NAME")    
	 private String user_name;
	 
	 @Column(name = "FIRST_NAME") 
	 private String first_name;
	 
	 @Column(name = "MIDDLE_NAME")
	 private String middle_name;
	 
	 @Column(name = "LAST_NAME")
	 private String last_name;
	 
	 @Column(name = "FULL_NAME")
	 private String full_name;
	 
	 @Column(name = "TITLE")
	 private String title;
	 
	 @Column(name = "Role")
	 private String role;
	 
	 @Column(name = "USER_EMAIL")
	 private String user_mail;
	 
	 @Column(name = "USER_PHONE")
	 private String phone;
	 
	 @Column(name = "USER_MOBILE")
	 private String user_mobile;
	 
	 @Column(name = "USER_EMP_ID")
	 private String emp_ID;
	 
	 @Column(name = "ADDRESS1")
	 private String address1;
	 
	 @Column(name = "ADDRESS2")
	 private String address2;
	 
	 @Column(name = "CITY")
	 private String city;
	 
	 @Column(name = "STATE")
	 private String state;
	 
	 @Column(name = "ZIP")
	 private String zip;
	 
	 @Column(name = "PREFERRED_NAME")
	 private String preferred_name;
	 
	 @Column(name = "ACTIVE_IND")
	 private String active_ind;
	 
	 @Column(name = "USER_TERR")
	 private String user_terr;
	 
	 
	 @Column(name = "EMP_ID")
	 private String emp_Id;
	 
	 @Column(name = "HIRE_DATE")
	 private Date hire_date;
	 
	 @Column(name = "END_DATE")
	 private Date end_date;
	 
	 @Column(name = "START_DATE")
	 private Date start_date;
	 
	 @Column(name = "ADM_TOOLS_FLAG")
	 private String adm_tools_flag;
	 
	 @Column(name = "ATTENDEE_FLAG")
	 private String attendee_flag;
	 
	 @Column(name = "BOOKING_URL")
	 private String booking_url;
	 
	 @Column(name = "MANAGER_EMAIL")
	 private String manager_email;
	 
	 @Column(name = "USER_TIME_ZONE")
	 private String user_time_zone;
	 
	 @Column(name = "USER_NT_ID")
	 private String user_nt_id;
	 
	 @Column(name = "OUTLOOK_CLIENT_ID")
	 private String outlook_client_id;
	 
	 @Column(name = "OUTLOOK_SECRET_CODE")
	 private String outlook_secret_code;
	 
	 @Column(name = "OUTLOOK_EMAIL_ID")
	 private String outlook_email_id;
	 

	 @Column(name = "SALES_FORCE")
	 private String sales_force;
	 
	 @Column(name = "PASSWORD")
	 private String password;
	 
	 @Column(name = "CONFIRM_PASSWORD")
	 private String confirm_password;
	 
	 @Column(name = "PASSWORD_UPDATED_DATE")
	 private Date password_updated_date;
	 
	 @Column(name = "USER_STATUS_FLAG")
	 private String user_status_flag;
	 
	 @Column(name = "USER_TYPE")
	 private String user_type;
	 
	 @Column(name = "OTHER_PASSWORD")
	 private String other_password;
	 
	 @Column(name = "USER_IMAGE_URL")
	 private String user_image_url;
	 
	 @Column(name = "CREATED_USER")
	 private String created_user;
	 
	 @Column(name = "CREATED_DATE")
	 private String created_date;
	 
	 @Column(name = "UPDATED_USER")
	 private String updated_user;
	 
	 @Column(name = "UPDATED_DATE")
	 private String updated_date;
	 
	 
	 
	 
	 
	 
	 
	 
	  
	    
	 
	  
	   
	 
	 
}
