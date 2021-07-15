package com.example.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bill.entity.User;
import com.example.bill.model.RequestBill;
import com.example.bill.service.BillCalculator;
import com.example.bill.service.UserService;

@RestController("/")
public class BillController {
	
	@Autowired
	protected BillCalculator calc;
	
	@Autowired 
	protected UserService userServ;
	
	@PostMapping("calculate")
	public float calculateBill(@RequestBody RequestBill bill) {
		return calc.calculate(bill);
	}
	
	@PostMapping("user")
	public void addUser(@RequestBody User user) {
		userServ.addUser(user);
	}
	
	@GetMapping("user")
	public User getUser(@RequestParam("name") String name) {
		return userServ.getUser(name);
	}

}
