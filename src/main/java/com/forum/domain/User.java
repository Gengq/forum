package com.forum.domain;

public class User{
	
	private int userId;
	private String userName;
	private String password;
	private int userType;
	private int locked;
	private int credit;
	
	public int getLocked() {
		return locked;
	}
	public void setLocked(int locked) {
		this.locked = locked;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String toString() {
		return "User:"+"[id="+this.userId+",name="
					+this.userName+",password="+password+",userType="+userType
					+",userLock="+locked+",credit="+credit+"]";
	}
}
