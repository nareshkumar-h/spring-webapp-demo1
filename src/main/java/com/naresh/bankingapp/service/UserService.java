package com.naresh.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.bankingapp.dao.UserDAO2;
import com.naresh.bankingapp.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO2 userDAO ;//= new UserDAO();
	
	public void save(User user) {

		System.out.println("UserService - save" + user);
		userDAO.save(user);
	}

}
