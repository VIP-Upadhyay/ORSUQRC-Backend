package com.vip.orsuqrc.model.projection.user;

import com.vip.orsuqrc.model.dbmodel.user.User;

public class UserProjection {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	
	public UserProjection(String username, String password, String firstname, String lastname, String email, String mobile) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public User convertToUser() {
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setEmail(this.email);
		user.setFirstname(this.firstname);
		user.setLastname(this.lastname);
		user.setMobile(this.mobile);
		return user;
	}
	
	@Override
	public String toString() {
		return "UserProjection [username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", mobile=" + mobile + "]";
	}

	
}
