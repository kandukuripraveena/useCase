package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.entity.WasherDetailsEntity;

@Repository
public interface WasherDetailsRepository extends MongoRepository<WasherDetailsEntity, String>{
	

}
