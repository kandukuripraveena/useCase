package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.entity.CarImageUploadEntity;

@Repository
public interface ImageUploadRepository extends MongoRepository<CarImageUploadEntity, String>{


}
