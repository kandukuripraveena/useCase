package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.entity.LoginEntity;

@Repository
public interface LoginRepository extends MongoRepository<LoginEntity, String> {

	@Query("{'loginMailId' : ?0, 'password' : ?1}")
	public String checkUserLogin(String userName, String password);

}
