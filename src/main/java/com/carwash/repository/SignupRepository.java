package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.entity.SignupEntity;

@Repository
public interface SignupRepository extends MongoRepository<SignupEntity, String>{

	@Query("{'mailId': ?0}")
	public String finduserIfExists(String mailId);
	
	@Query("{'mailId': ?0}")
	public SignupEntity getuserDetails(String mailId);
	
}
