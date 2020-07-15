package com.carwash.entity;

import org.bson.BsonBinarySubType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Document
public class CarImageUploadEntity {
	
	@Id
	private byte[] image;
	
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(BsonBinarySubType binary, byte[] image) {
		this.image = image;
	}
	
	
	
	
}
	
//	public String getReqId() {
//		return reqId;
//	}
//	public void setReqId(String reqId) {
//		this.reqId = reqId;
//	}
//	public MultipartFile getImage() {
//		return image;
//	}
//	public void setImage(MultipartFile image) {
//		this.image = image;
//	}
//	public void setImage(BsonBinarySubType binary, byte[] bytes) {
//		// TODO Auto-generated method stub
//		
//	}		
//}
