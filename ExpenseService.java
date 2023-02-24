package com.example.ExpenseManagement.service;

import com.example.ExpenseManagement.dto.TrackerDto;

public interface ExpenseService 
{

	Double calculateBillAmount(TrackerDto trackerdto);

}