package com.example.ExpenseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExpenseManagement.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	User findUserByUsernameAndPassword(String userName, String password);

}
