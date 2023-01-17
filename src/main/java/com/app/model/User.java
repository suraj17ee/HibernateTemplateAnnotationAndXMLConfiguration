package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tab1")
public class User {
	@Id
	@Column(name = "u_id")
	private int userId;
	@Column(name = "uname")
	private String userName;
	@Column(name = "ucode")
	private String userCode;

	public User() {
		super();
	}

	public User(int userId, String userName, String userCode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userCode = userCode;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userCode=" + userCode + "]";
	}
}
