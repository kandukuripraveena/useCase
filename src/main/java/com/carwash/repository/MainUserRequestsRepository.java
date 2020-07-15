package com.carwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.entity.MainUserRequestEntity;

@Repository
public interface MainUserRequestsRepository extends MongoRepository<MainUserRequestEntity, String>{

	@Query("{'requestId' : ?0}")
	MainUserRequestEntity findAllById(String requestId);

	@Query("{'washer' : ?0}")	
	List<MainUserRequestEntity> getWasherRequestsById(String washer);

	@Query("{'userMail' : ?0}")
	List<MainUserRequestEntity> getUserRequestsById(String userMail);

	
}
