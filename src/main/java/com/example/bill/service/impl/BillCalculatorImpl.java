package com.example.bill.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bill.entity.User;
import com.example.bill.model.ItemInfo;
import com.example.bill.model.RequestBill;
import com.example.bill.service.BillCalculator;
import com.example.bill.service.UserService;

@Service
public class BillCalculatorImpl implements BillCalculator{
	
	@Autowired
	protected UserService userServ;

	@Override
	public float calculate(RequestBill bill) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		// TODO Auto-generated method stub
		float billAmount = 0;
		User userDetail = userServ.getUser(bill.getUserName());
		
		for(ItemInfo item : bill.getItems()) {
			float itemAmount = item.getQuantity() * item.getRate();
			if("Grocery".equalsIgnoreCase(item.getItemType())) {
				billAmount = billAmount + (itemAmount);
			}else {
				if("Employee".equalsIgnoreCase(userDetail.userType)) {
					float amount =calculateDiscount(itemAmount, 0.3f);
					billAmount = billAmount + amount;
				}
				else if("Affiliated".equalsIgnoreCase(userDetail.userType)) {
					float amount = calculateDiscount(itemAmount,0.1f);
					billAmount = billAmount + amount;
				}
				else if ((LocalDate.parse(bill.getDateOfBill(),formatter).getYear() - LocalDate.parse(userDetail.association,formatter).getYear()) > 2) {
					float amount = calculateDiscount(itemAmount, 0.05f);
					billAmount = billAmount + amount;
				}
			}
		}
		
		int multiply = (int) (billAmount/100);
		billAmount = billAmount - (multiply * 5);
		
		return billAmount;
	}

	private float calculateDiscount(float itemAmount,float percent) {
		float amount = itemAmount - ((float) (itemAmount * percent));
		return amount;
	}

}
