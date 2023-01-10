package com.gcu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model class for Users.
 *
 */
public class UserModel 
{
	@NotNull(message="User name is a required field")
	@Size(min=4, max=32, message="User name must be between 4 and 32 characters")
	private String username;
	@NotNull(message="Password is a required field")
	@Size(min=2, max=32, message="Password must be between 2 and 32 characters")
	private String password;
	@NotNull(message="Email is a required field")
	@Email(message="Please provide a valid email address")
	private String email;
	@NotNull(message="Phone number is a required field")
	@Size(min=0, max=10, message="Please enter valid 10-digit phone number")
	private String phoneNum;
	
	private int userId;
	
	/**
	 * @param username username
	 * @param password password
	 * @param email email
	 * @param phoneNum phone number
	 * @param userId user ID
	 */
	public UserModel(String username, String password, String email, String phoneNum, int userId) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNum = phoneNum;
		this.userId = userId;
	}
	
	/**
	 * Default constructor
	 */
	public UserModel() {

	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
