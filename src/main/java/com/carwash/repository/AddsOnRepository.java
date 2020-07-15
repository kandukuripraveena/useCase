package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.entity.AddsOnEntity;

@Repository
public interface AddsOnRepository  extends MongoRepository<AddsOnEntity, String>{

}
