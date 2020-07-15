package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.entity.LoginEntity;
import com.carwash.entity.PackageEntity;

@Repository
public interface PackagesRepository extends MongoRepository<PackageEntity, String>{

}
