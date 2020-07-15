package com.carwash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.dto.LoginDto;
import com.carwash.entity.LoginEntity;
import com.carwash.entity.SignupEntity;
import com.carwash.repository.LoginRepository;
import com.carwash.repository.SignupRepository;

@Service
public class UserSignUpServiceImpl implements IUserSignUpService {
	
	@Autowired
	private LoginRepository loginrepo;

	@Autowired
	private SignupRepository signuprepo;
	
	@Override
	public LoginEntity addSignupRecord(SignupEntity signuprecord) {
		LoginEntity loginrecord = new LoginEntity();	
		String userStatus = signuprepo.finduserIfExists(signuprecord.getMailId());
		String status;
		
		if(userStatus != null){
			status = "User already Exists!";
		}
		else {
			
			loginrecord.setLoginMailId(signuprecord.getMailId());
			loginrecord.setPassword(signuprecord.getPassword());
			loginrepo.save(loginrecord);
			signuprepo.save(signuprecord);
			status = "Successfully signed Up!";
	  }
		System.out.println("status"+status);
		return loginrecord;
	}

	@Override
	public LoginDto checkUserLogin(String userName, String password) {
		
		String status = loginrepo.checkUserLogin(userName, password);			
		LoginDto loginDto = new LoginDto();
		
		if(status != null) {
			if(userName.equalsIgnoreCase("admin@gmail.com")) {
				loginDto.setUserName("@dmin");
				loginDto.setMailId("@dmin");
				loginDto.setMobile("@dmin");
			}
			else {
				
			SignupEntity logindetails = signuprepo.getuserDetails(userName);
				if(logindetails != null) {
					loginDto.setUserName(logindetails.getFirstName());
					loginDto.setMailId(logindetails.getMailId());
					loginDto.setMobile(logindetails.getMobile());
					
				}
				else {
					System.out.println("singup logindetails"+logindetails);
					loginDto.setUserName("washer");
					loginDto.setMailId("washer");
					loginDto.setMobile("washer");
			}
		  }
		}
		return loginDto;
	}

}
