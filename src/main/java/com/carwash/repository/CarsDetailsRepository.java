package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.entity.CarsEntity;

@Repository
public interface CarsDetailsRepository  extends MongoRepository<CarsEntity, String>{

}
