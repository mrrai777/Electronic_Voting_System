package com.evs.bean;

public class CredentialsBean {
	private String userId;
	private String password;
	private String userType;
	private int loginStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString() {
		return "[userId=" + userId + " || password=" + password + " || userType=" + userType
				+ " || loginStatus=" + loginStatus + "]";
	}

}
