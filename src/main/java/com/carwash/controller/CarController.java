package com.carwash.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.carwash.dto.LoginDto;
import com.carwash.dto.PaymentDto;
import com.carwash.entity.AddsOnEntity;
import com.carwash.entity.LoginEntity;
import com.carwash.entity.MainUserRequestEntity;
import com.carwash.entity.PackageEntity;
import com.carwash.entity.PaytmDetails;
import com.carwash.entity.SignupEntity;
import com.carwash.entity.WasherDetailsEntity;
import com.carwash.repository.PackagesRepository;
import com.carwash.repository.AddsOnRepository;
import com.carwash.repository.CarsDetailsRepository;
import com.carwash.repository.LoginRepository;
import com.carwash.repository.MainUserRequestsRepository;
import com.carwash.repository.WasherDetailsRepository;
import com.carwash.service.ICarRequestsService;
import com.carwash.service.IImageUploadService;
import com.carwash.service.IUserSignUpService;
import com.paytm.pg.merchant.CheckSumServiceHelper;

@RestController
@RequestMapping(value = "/app")
public class CarController {

	@Autowired
	private LoginRepository loginrepo;
	
	@Autowired
	private PackagesRepository packagerepo;
	
	@Autowired
	IUserSignUpService iUserSignUpService;
	
	@Autowired
	ICarRequestsService iCarRequestsService;
	
	@Autowired
	PackagesRepository packagesRepo;
	
	@Autowired
	CarsDetailsRepository carRepo;
	
	@Autowired
	WasherDetailsRepository washerDetailsRepo;
	
	@Autowired
	AddsOnRepository addsOnRepo;
	
	@Autowired
	MainUserRequestsRepository requestsRepo;
	
	@Autowired
	IImageUploadService iImageUpload;
	
	@Autowired
	private PaytmDetails paytmDetails;
	
	
	@RequestMapping(value = "/addSignuprecord", method = RequestMethod.POST)
	public LoginEntity addSignupRecord(@RequestBody SignupEntity signuprecord) {
		return iUserSignUpService.addSignupRecord(signuprecord);
	}
	
	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String imageUpload(@RequestParam("file") MultipartFile file) {
//		MultipartFile file = entity.getImage();
//		String reqId = entity.getReqId();
		return iImageUpload.imageUpload(file);
	}
	
	@RequestMapping(value = "/checklogin", method = RequestMethod.GET)
	public LoginDto checkUserLogin(@RequestParam String userName, @RequestParam String password) {
		return iUserSignUpService.checkUserLogin(userName,password);
	}
	
	@RequestMapping(value = "/addUserRequest", method = RequestMethod.POST, consumes="application/json")
	public String addUserRequest(@RequestBody MainUserRequestEntity requestsDto) throws IOException {
		return iCarRequestsService.addUserRequest(requestsDto);
	}

	@RequestMapping(value = "/assignWasher", method = RequestMethod.POST, consumes="application/json")
	public MainUserRequestEntity assignWasher(@RequestBody MainUserRequestEntity requestsDto) throws IOException {
		MainUserRequestEntity assign = requestsRepo.findAllById(requestsDto.getRequestId());
		assign.setWasher(requestsDto.getWasher());
		assign.setRequestStatus(requestsDto.getRequestStatus());
		System.out.println("assign"+assign.getWasher());
		return requestsRepo.save(assign);
	}
	
	@RequestMapping(value = "/getWasherRequestsById", method = RequestMethod.GET)
	public List<MainUserRequestEntity> getWasherRequestsById(@RequestParam String washer){
		return requestsRepo.getWasherRequestsById(washer);
	}
	
	@RequestMapping(value = "/getUserRequestsById", method = RequestMethod.GET)
	public List<MainUserRequestEntity> getUserRequestsById(@RequestParam String userMail){
		return requestsRepo.getUserRequestsById(userMail);
	}
	
	@RequestMapping(value = "/getAlluserRequests", method = RequestMethod.GET)
	public List<MainUserRequestEntity> getAllRequests(){
		return requestsRepo.findAll();
	}	
	
	@RequestMapping(value = "/addPackage", method = RequestMethod.POST)
	public PackageEntity addPackageAdmin(@RequestBody PackageEntity packagerecord) {
		return packagerepo.save(packagerecord); 
	}
	
	@RequestMapping(value = "/addCarsAddsOn", method = RequestMethod.POST)
	public AddsOnEntity addAddsOnAdmin(@RequestBody AddsOnEntity addsOnrecord) {
		return addsOnRepo.save(addsOnrecord); 
	}
	
	@RequestMapping(value = "/addWasher", method = RequestMethod.POST)
	public WasherDetailsEntity addWasherAdmin(@RequestBody WasherDetailsEntity washerDetails) {
		LoginEntity logincreds = new LoginEntity();
		logincreds.setLoginMailId(washerDetails.getWasherMailId());
		logincreds.setPassword(washerDetails.getPassword());
		loginrepo.save(logincreds);
		return washerDetailsRepo.save(washerDetails); 
	}	
	
	@RequestMapping(value = "/closeService", method = RequestMethod.POST)
	public String closeService(@RequestBody MainUserRequestEntity requestsDto) {
		MainUserRequestEntity entity = requestsRepo.findAllById(requestsDto.getRequestId());
		entity.setRequestStatus("Service Closed");
		requestsRepo.save(entity);
		return "Closed"; 
	}	
	
	@RequestMapping(value = "/getAllpackages", method = RequestMethod.GET)
	public List<PackageEntity> getAllpackages(){
		return packagesRepo.findAll();
	}
		
	@RequestMapping(value = "/getAllAddsOn", method = RequestMethod.GET)
	public List<AddsOnEntity> getAllAddsOn(){
		return addsOnRepo.findAll();
	}
	
	@RequestMapping(value = "/getAllWashers", method = RequestMethod.GET)
	public List<WasherDetailsEntity> getAllWashers(){
		return washerDetailsRepo.findAll();
	}
	
	@RequestMapping(value = "/deletePackage", method = RequestMethod.POST)
	public String deletePackageAdmin(@RequestBody PackageEntity packageName){
		packagesRepo.delete(packageName);
		return "deleted";
	}
	
	@RequestMapping(value = "/deleteAddson", method = RequestMethod.POST)
	public String deleteAddsOnAdmin(@RequestBody AddsOnEntity addson){
		addsOnRepo.delete(addson);
		return "deleted";
	}
	
	 @RequestMapping(value = "/pgredirect", method = RequestMethod.POST)
	 public ModelAndView getRedirect(@RequestBody PaymentDto payDto) throws Exception {

		 System.out.println("Hello In pgredirect");
	        ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
	        TreeMap<String, String> parameters = new TreeMap<>();
	        System.out.println("payDto"+payDto);
	        paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MOBILE_NO", payDto.getMobileNo());
	        parameters.put("EMAIL", payDto.getEmailId());
	        parameters.put("ORDER_ID", payDto.getOrderId());
	        parameters.put("TXN_AMOUNT", payDto.getTransactionAmount());
	        parameters.put("CUST_ID", payDto.getCustomerId());
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
	        System.out.println("modelAndView"+modelAndView);
	        return modelAndView;
	    }	
	 
	 @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        mapData.forEach((key, val) -> parameters.put(key, val[0]));
	        String paytmChecksum = "";
	        if (mapData.containsKey("CHECKSUMHASH")) {
	            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        return "success";
	    }
	 
		private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
			return CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(paytmDetails.getMerchantKey(), parameters);
		}
	 
	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(paytmDetails.getMerchantKey(),
	                parameters, paytmChecksum);
	    }	


}

	

