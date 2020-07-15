package com.carwash.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WasherDetailsEntity {

	@Id
	private String washerMailId;
	private String washerName;
	private String washerLocation;
	private String washerMobile;
	private String password;
	
	public String getWasherMailId() {
		return washerMailId;
	}
	public void setWasherMailId(String washerMailId) {
		this.washerMailId = washerMailId;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public String getWasherLocation() {
		return washerLocation;
	}
	public void setWasherLocation(String washerLocation) {
		this.washerLocation = washerLocation;
	}

	public String getWasherMobile() {
		return washerMobile;
	}
	public void setWasherMobile(String washerMobile) {
		this.washerMobile = washerMobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
