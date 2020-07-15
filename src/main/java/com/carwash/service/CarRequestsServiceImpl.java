package com.carwash.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carwash.dto.UserRequestsDto;
import com.carwash.entity.AddsOnEntity;
import com.carwash.entity.CarRequestSubEntity;
import com.carwash.entity.MainUserRequestEntity;
import com.carwash.entity.UsersAllRequestRecords;
import com.carwash.repository.MainUserRequestsRepository;

@Service
public class CarRequestsServiceImpl implements ICarRequestsService{

	@Autowired
	MainUserRequestsRepository userRequestsRepo;
	
	@Override
	public String addUserRequest(MainUserRequestEntity requestsDto) throws IOException {
		System.out.println(requestsDto.getAddsonlist());

		MainUserRequestEntity mainUserRequestDetails = new MainUserRequestEntity();
		mainUserRequestDetails.setRequestId(requestsDto.getRequestId());
		mainUserRequestDetails.setName(requestsDto.getName());
		mainUserRequestDetails.setMobileNo(requestsDto.getMobileNo());
		mainUserRequestDetails.setVehicleDetails(requestsDto.getVehicleDetails());
		mainUserRequestDetails.setAddress(requestsDto.getAddress());
		mainUserRequestDetails.setLandmark(requestsDto.getLandmark());
		mainUserRequestDetails.setScheduledDate(requestsDto.getScheduledDate());
		mainUserRequestDetails.setPostalCode(requestsDto.getPostalCode());
		mainUserRequestDetails.setPackagewash(requestsDto.getPackagewash());
		mainUserRequestDetails.setAddsonlist(requestsDto.getAddsonlist());
		mainUserRequestDetails.setFinalCost(requestsDto.getFinalCost());
		mainUserRequestDetails.setRequestStatus(requestsDto.getRequestStatus());
		mainUserRequestDetails.setUserMail(requestsDto.getUserMail());
			
		
		userRequestsRepo.save(mainUserRequestDetails);
		return "success";
	}
	
}		
		
