package com.carwash.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AddsOnEntity {
	
	@Id
	private String addsOn;
	private long cost;
	
	public String getAddsOn() {
		return addsOn;
	}
	public void setAddsOn(String addsOn) {
		this.addsOn = addsOn;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
}
