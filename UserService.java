package com.example.ExpenseManagement.service;

import com.example.ExpenseManagement.dto.SignIn;
import com.example.ExpenseManagement.dto.TrackerDto;
import com.example.ExpenseManagement.entity.User;

public interface UserService 
{


	public Integer checkCustomerinDb(SignIn signin);
	
	public Integer checkCustomerinDb(TrackerDto dto);
	
	public User saveUser(SignIn signin);

	public void saveUser(TrackerDto trackerDto);

	
}
