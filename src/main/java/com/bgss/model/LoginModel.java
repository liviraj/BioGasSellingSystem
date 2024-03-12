package com.bgss.model;

/**
 * Login data beens
 */
public class LoginModel {
	private String username;
	private String password;
	private String email;
	private String mobileNo;
	private String address;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + ", email=" + email + ", mobileNo="
				+ mobileNo + ", address=" + address + "]";
	}

}
