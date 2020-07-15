package com.carwash.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CarRequestSubEntity {
	
	private String carName;
	private String packageName;
	//private Binary carImage;
	
	private String instructions;

	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
//	public Binary getCarImage() {
//		return carImage;
//	}
//	public void setCarImage(Binary carImage) {
//		this.carImage = carImage;
//	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
