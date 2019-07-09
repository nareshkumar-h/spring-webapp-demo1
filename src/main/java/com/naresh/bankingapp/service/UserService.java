package com.naresh.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.bankingapp.dao.UserDAO;
import com.naresh.bankingapp.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO ;//= new UserDAO();
	
	public void save(User user) {

		System.out.println("UserService - save" + user);
		userDAO.save(user);
	}

}
