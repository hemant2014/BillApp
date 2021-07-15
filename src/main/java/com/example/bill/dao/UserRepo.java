package com.example.bill.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bill.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
