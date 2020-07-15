package com.carwash.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UsersAllRequestRecords {

	private String requestId;
	private String name;
	private String mobileNo;
	private String emailId;
	private String vehicleDetails;
	private String address;
	private String landmark;
	private String postalCode;
	private Date scheduledDate; 
	private PackageEntity packagewash;
	private List<AddsOnEntity> addsonlist;
	private String finalCost;
//	private Binary image;
	private String requestStatus;
	private String washer;
	
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getVehicleDetails() {
		return vehicleDetails;
	}
	public void setVehicleDetails(String vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Date getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public PackageEntity getPackagewash() {
		return packagewash;
	}
	public void setPackagewash(PackageEntity packagewash) {
		this.packagewash = packagewash;
	}
	public List<AddsOnEntity> getAddsonlist() {
		return addsonlist;
	}
	public void setAddsonlist(List<AddsOnEntity> addsonlist) {
		this.addsonlist = addsonlist;
	}
	public String getFinalCost() {
		return finalCost;
	}
	public void setFinalCost(String finalCost) {
		this.finalCost = finalCost;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getWasher() {
		return washer;
	}
	public void setWasher(String washer) {
		this.washer = washer;
	}
	
	
}
