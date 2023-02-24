package com.example.ExpenseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.ExpenseTracker;

	@Repository
	public interface ExpenseTrackerRepository extends JpaRepository<ExpenseTracker, Integer>
{

}

