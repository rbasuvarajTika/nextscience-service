package com.nextscience.dto.response;



public class UserResponse{
	
	private int user_Id;
     private String first_name;
    private String last_name;
    private String phone;
    private String role;
    private String type;
    private String status;

    public UserResponse(int user_ID, String first_name, String last_name,String phone, String role, String type,String status) {
        this.user_Id = user_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone=phone;
        this.role = role;
        this.type = type;
        this.status=status;
    }

    public int getUser_id()
    {
    	return user_Id;
    }
    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

     public String getType()
     {
    	 return type;
     }
	public String getStatus()
	{
		return status;
	}

	
}
