package com.nextscience.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse{
	
	private int user_Id;
    private String userName;
    private String first_name;
    private String last_name;
    private String phone;
    private String role;
    private String type;
    private String status;

}
