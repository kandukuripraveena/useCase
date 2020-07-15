package com.carwash.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PackageEntity {
	
	@Id
	private String packageName;	
	private long packageCost;
	private List<AddsOnEntity> addson; 

	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public long getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(long packageCost) {
		this.packageCost = packageCost;
	}
	public List<AddsOnEntity> getAddson() {
		return addson;
	}
	public void setAddson(List<AddsOnEntity> addson) {
		this.addson = addson;
	}	
}
