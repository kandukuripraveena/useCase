package com.carwash.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LoginEntity {

	@Id
	private String idObj;
	private String loginMailId;
	private String password;
	
	public String getIdObj() {
		return idObj;
	}
	public void setIdObj(String idObj) {
		this.idObj = idObj;
	}
	public String getLoginMailId() {
		return loginMailId;
	}
	public void setLoginMailId(String loginMailId) {
		this.loginMailId = loginMailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
