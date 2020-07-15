package com.carwash.service;

import com.carwash.dto.LoginDto;
import com.carwash.entity.LoginEntity;
import com.carwash.entity.SignupEntity;

public interface IUserSignUpService {

	public LoginEntity addSignupRecord(SignupEntity signuprecord);

	public LoginDto checkUserLogin(String userName, String password);
	
}
