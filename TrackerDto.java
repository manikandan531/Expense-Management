package com.example.ExpenseManagement.dto;

import java.util.List;

import com.example.ExpenseManagement.entity.Activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackerDto {
	
	private List<Activity> activity;
	
	private String username;
	
	private String email;
	
	

}
