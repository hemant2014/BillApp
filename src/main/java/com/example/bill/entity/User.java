package com.example.bill.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Column(name = "userId")
	public int userId;
	
	@Id
	@Column(name = "userName")
	public String userName;
	
	@Column(name = "userType")
	public String userType;
	
	@Column(name = "association")
	public String association;
	
}
