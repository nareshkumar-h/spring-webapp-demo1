package com.naresh.bankingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.bankingapp.dao.UserDAO3;
import com.naresh.bankingapp.model.User;

@Service
public class UserService2 {

	@Autowired
	private UserDAO3 userDAO;

	@Transactional
	public void save(User user) {
		System.out.println("UserService2 -> save" + user);
		userDAO.save(user);
	}
}
