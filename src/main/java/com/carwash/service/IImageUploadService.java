package com.carwash.service;

import org.springframework.web.multipart.MultipartFile;


public interface IImageUploadService {

	String imageUpload(MultipartFile image);
	
}
