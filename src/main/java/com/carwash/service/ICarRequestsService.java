package com.carwash.service;

import java.io.IOException;

import com.carwash.dto.UserRequestsDto;
import com.carwash.entity.MainUserRequestEntity;

public interface ICarRequestsService {
	
	public String addUserRequest(MainUserRequestEntity requestsDto) throws IOException; 
}
