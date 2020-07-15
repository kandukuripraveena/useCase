package com.carwash.dto;

import java.util.Date;
import java.util.List;

import com.carwash.entity.CarRequestSubEntity;

public class UserRequestsDto {

	private List<CarRequestSubEntity> carRequestDetails;
	private Date scheduledDate;
	private String address;
		
	public List<CarRequestSubEntity> getCarRequestDetails() {
		return carRequestDetails;
	}
	public void setCarRequestDetails(List<CarRequestSubEntity> carRequestDetails) {
		this.carRequestDetails = carRequestDetails;
	}
	public Date getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		
}

