package com.naresh.bankingapp.dao;

import org.springframework.stereotype.Repository;

import com.naresh.bankingapp.model.User;

@Repository
public class UserDAO {

	public void save(User user) {
		System.out.println("UserDAO->save" + user);
	}
}
