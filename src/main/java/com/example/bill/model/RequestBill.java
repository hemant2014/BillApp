package com.example.bill.model;

import java.util.List;

public class RequestBill {
	
	private String userName;
	private String dateOfBill;
	private String address;
	private String storeName;
	private List<ItemInfo> items;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDateOfBill() {
		return dateOfBill;
	}
	public void setDateOfBill(String dateOfBill) {
		this.dateOfBill = dateOfBill;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public List<ItemInfo> getItems() {
		return items;
	}
	public void setItems(List<ItemInfo> items) {
		this.items = items;
	}

}
