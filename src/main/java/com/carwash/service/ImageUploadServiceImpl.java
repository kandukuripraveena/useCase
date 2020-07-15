package com.carwash.service;


import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carwash.entity.CarImageUploadEntity;
import com.carwash.repository.ImageUploadRepository;

@Service
public class ImageUploadServiceImpl implements IImageUploadService {
	
	@Autowired
	ImageUploadRepository iImageUploadRepo;

		@Override
		public String imageUpload(MultipartFile image) {
			CarImageUploadEntity imageEntity = new CarImageUploadEntity();
			try {
				imageEntity.setImage(BsonBinarySubType.BINARY, image.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			return null;
		}	

	}

	

