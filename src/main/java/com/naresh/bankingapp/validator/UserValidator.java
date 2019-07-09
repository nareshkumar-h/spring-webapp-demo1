package com.naresh.bankingapp.validator;

import org.springframework.stereotype.Component;

import com.naresh.bankingapp.model.User;

@Component
public class UserValidator {

	public void validate(User user) {
		System.out.println("UserValidator->" + user);
	}
}
