package com.example.ExpenseManagement.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseManagement.ExpenseService;
import com.example.ExpenseManagement.ExpenseTracker;
import com.example.ExpenseManagement.dto.ResponseTrackerDto;
import com.example.ExpenseManagement.dto.SignIn;
import com.example.ExpenseManagement.dto.TrackerDto;
import com.example.ExpenseManagement.entity.User;
import com.example.ExpenseManagement.service.UserService;


@RestController
public class ExpenseTrackerController {
	
	private static final Logger log=LoggerFactory.getILoggerFactory(ExpenseTrackerController.class);
	
	private UserService userService;
	
	private com.example.ExpenseManagement.service.ExpenseService expenseService;
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody SignIn signin)
	{
		User user=new User(signin.getUsername(),signin.getPassword());
		Integer userInDb=userService.checkCustomerinDb(signin);
		log.info("Checking user present in Database"+userInDb);
		
		if(userInDb!=null)
		{
			user.setUserId(userInDb);
			log.info("User already present in Db with userID:"+userInDb);
			return"Account already exists,Kindly Login with your Username and Password";
		}
		else
		{
			userService.saveUser(signin);
			log.info("user Signed-in Successfully");
		}
		return "Account Successfully Signed-In";
	}
	
	@PostMapping("/expenseTracker")
	public ResponseTrackerDto expenses(@RequestBody TrackerDto trackerDto)
	{
		ResponseTrackerDto responseDto=new ResponseTrackerDto();
		Double totalAmount=expenseService.calculateBillAmount(trackerDto.getActivity());
		
		User user=new User(trackerDto.getUsername(), trackerDto.getEmail());
		Integer userPresentInDb=userService.checkCustomerinDb(trackerDto);
		
		if(userPresentInDb!=null)
		{
			user.setUserId(userPresentInDb);
			log.info("User already present in Db with userID:"+ userPresentInDb);
		}
		else
		{
			userService.saveUser(trackerDto);
			log.info("user saved to Database Successfully");
		}
		
		ExpenseTracker tracker=new ExpenseTracker(user,trackerDto.getActivity());
		tracker.setTotalAmount(totalAmount);
		expenseService.save(tracker);
		log.info("Order placed Successfully");
		
		responseDto.setExpenseId(tracker.getExpenseId());
		responseDto.setTotalAmount(totalAmount);
		return responseDto;
		
		
	}
	
	
	
	
}
