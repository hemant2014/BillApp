package com.example.bill.service;

import com.example.bill.entity.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User getUser(String name);

}
