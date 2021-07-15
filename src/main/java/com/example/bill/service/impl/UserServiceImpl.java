package com.example.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bill.dao.UserRepo;
import com.example.bill.entity.User;
import com.example.bill.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	protected UserRepo repo;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		User user = repo.findById(name).get();
		return user;
	}

}
